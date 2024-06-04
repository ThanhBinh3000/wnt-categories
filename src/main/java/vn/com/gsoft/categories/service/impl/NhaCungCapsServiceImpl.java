package vn.com.gsoft.categories.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import vn.com.gsoft.categories.constant.ENoteType;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.NhaCungCapsReq;
import vn.com.gsoft.categories.model.dto.NhaCungCapsRes;
import vn.com.gsoft.categories.model.dto.PhieuNhapNoDauKyRes;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.NhaCungCapsService;
import vn.com.gsoft.categories.util.system.DataUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class NhaCungCapsServiceImpl extends BaseServiceImpl<NhaCungCaps, NhaCungCapsReq,Long> implements NhaCungCapsService {

	//region Fields
	private NhaCungCapsRepository hdrRepo;
	private NhomNhaCungCapsRepository nhomNhaCungCapsRepository;
	private PhieuNhapsRepository phieuNhapsRepository;
	//endregion

	//region Constructor
	@Autowired
	public NhaCungCapsServiceImpl(NhaCungCapsRepository hdrRepo,
								  NhomNhaCungCapsRepository nhomNhaCungCapsRepository,
								  PhieuNhapsRepository phieuNhapsRepository) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
		this.nhomNhaCungCapsRepository = nhomNhaCungCapsRepository;
		this.phieuNhapsRepository = phieuNhapsRepository;
	}
    //endregions

	//region Interface Implementation
	@Override
	public Page<NhaCungCaps> searchPage(NhaCungCapsReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		String storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		req.setMaNhaThuoc(storeCode);
		req.setSupplierTypeId(0);
		req.setRecordStatusId(req.getDataDelete() ? RecordStatusContains.DELETED : RecordStatusContains.ACTIVE);
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
		Page<NhaCungCaps> nhaCungCaps= hdrRepo.searchPage(req,pageable);
		for (NhaCungCaps nc : nhaCungCaps.getContent()){
			if(nc.getMaNhomNhaCungCap() != null && nc.getMaNhomNhaCungCap() > 0){
				Optional<NhomNhaCungCaps> byId = nhomNhaCungCapsRepository.findById(nc.getMaNhomNhaCungCap().longValue());
				byId.ifPresent(nc::setNhomNhaCungCaps);
			}
		}
		return nhaCungCaps;
	}
	@Override
	public NhaCungCaps create(NhaCungCapsReq req) throws Exception{
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		var storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		req.setMaNhaThuoc(storeCode);
		//kiểm tra tên nhà cung cấp có tồn tại chưa
		if(req.getTenNhaCungCap() != null && !req.getTenNhaCungCap().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByName(storeCode, req.getTenNhaCungCap(), null);
			if(!supplier.isEmpty())
				throw  new Exception("Tên nhà cung cấp đã tồn tại");
		}
		//kiểm tra mã vạch
		if(req.getBarcode() != null && !req.getBarcode().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByBarcode(storeCode, req.getBarcode(), null);
			if(!supplier.isEmpty())
				throw new Exception("Mã vạch đã tồn tại");
		}
		//kiểm tra mã
		if(req.getCode() != null && !req.getCode().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByCode(storeCode, req.getCode(), null);
			if(!supplier.isEmpty())
				throw new Exception("Mã nhà cung cấp đã tồn tại");
		}
		NhaCungCaps e = new NhaCungCaps();
		BeanUtils.copyProperties(req, e, "id");
		e.setCreated(Date.from(Instant.now()));
		e.setCreatedByUserId(userInfo.getId());
		e.setRecordStatusId(RecordStatusContains.ACTIVE);
		e = hdrRepo.save(e);
		if (e.getNoDauKy() != null && e.getId() > 0){
			taoPhieuDauKy(storeCode, e.getId(), userInfo.getId(), e.getNoDauKy().doubleValue(), userInfo.getNhaThuoc().getId());
		}
		return e;
	}
	@Override
	public NhaCungCaps update(NhaCungCapsReq req) throws Exception{
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		var storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		req.setMaNhaThuoc(storeCode);
		//kiểm tra tên nhà cung cấp có tồn tại chưa
		if(req.getTenNhaCungCap() != null && !req.getTenNhaCungCap().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByName(storeCode, req.getTenNhaCungCap(), req.getId());
			if(!supplier.isEmpty())
				throw  new Exception("Tên nhà cung cấp đã tồn tại");
		}
		//kiểm tra mã vạch
		if(req.getBarcode() != null && !req.getBarcode().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByBarcode(storeCode, req.getBarcode(), req.getId());
			if(!supplier.isEmpty())
				throw new Exception("Mã vạch đã tồn tại");
		}
		//kiểm tra mã
		if(req.getCode() != null && !req.getCode().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByCode(storeCode, req.getCode(), req.getId());
			if(!supplier.isEmpty())
				throw new Exception("Mã nhà cung cấp đã tồn tại");
		}
		Optional<NhaCungCaps> optional = this.hdrRepo.findById(req.getId());
        NhaCungCaps e = optional.get();
        //cập nhật những trường thay đổi
		e.setCode(req.getCode());
		e.setTenNhaCungCap(req.getTenNhaCungCap());
		e.setBarCode(req.getBarcode());
		e.setDiaChi(req.getDiaChi());
		e.setMaSoThue(req.getMaSoThue());
		e.setModified(Date.from(Instant.now()));
		e.setModifiedByUserId(userInfo.getId());
		e.setMaNhomNhaCungCap(req.getMaNhomNhaCungCap());
		e.setNguoiDaiDien(req.getNguoiDaiDien());
		e.setNguoiLienHe(req.getNguoiLienHe());
		e.setEmail(req.getEmail());
		e.setSoDienThoai(req.getSoDienThoai());
		e.setSoFax(req.getSoFax());
		e.setNoDauKy(req.getNoDauKy());
		e.setDiaBanHoatDong(req.getDiaBanHoatDong());
		e.setWebsite(req.getWebsite());

		e = hdrRepo.save(e);
		if (e.getNoDauKy() != null){
			taoPhieuDauKy(storeCode, e.getId(), userInfo.getId(), e.getNoDauKy().doubleValue(), userInfo.getNhaThuoc().getId());
		}
		return e;
	}
	//xoá vĩnh viễn
	@Override
	public boolean deleteForever(Long id) throws Exception{
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		Optional<NhaCungCaps> optional = hdrRepo.findById(id);
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}
		var storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		//kiểm tra có giao dịch nhập xuất chưa
		var phieuNhaps = this.hdrRepo.findPhieuNhapByMaNhaCungCap(storeCode, id);
		var phieuTraLais = this.hdrRepo.findPhieuTraHangByMaNhaCungCap(storeCode, id);
		if(!phieuNhaps.isEmpty() || !phieuTraLais.isEmpty())
			throw new Exception("Đã tồn tại giao dịch bạn không được xoá");

		optional.get().setRecordStatusId(RecordStatusContains.DELETED_FOREVER);
		hdrRepo.save(optional.get());
		return true;
	}
	//endregion

	//region Private Methods
	//tạo phiếu đầu kỳ
	private void taoPhieuDauKy(String storeCode, Long maNhaCungCap,
							   Long userId, Double tongTien, Long storeId) throws Exception{
		PhieuNhaps phieuNhaps = this.phieuNhapsRepository.findByNhaThuocMaNhaThuocAndNhaCungCapMaNhaCungCapAndLoaiXuatNhapMaLoaiXuatNhapAndRecordStatusId(
				storeCode,
				maNhaCungCap,
				ENoteType.InitialSupplierDebt,
				(int) RecordStatusContains.ACTIVE);
		if(phieuNhaps != null && phieuNhaps.getId() != null && phieuNhaps.getId() > 0){
			phieuNhaps.setRecordStatusId(tongTien > 0 ? RecordStatusContains.ACTIVE : RecordStatusContains.DELETED_FOREVER);
			phieuNhaps.setTongTien(tongTien);
			phieuNhaps.setIsDebt(tongTien > 0);
		}else {
			phieuNhaps = new PhieuNhaps();
			phieuNhaps.setNhaCungCapMaNhaCungCap(maNhaCungCap);
			phieuNhaps.setSoPhieuNhap(0L);
			phieuNhaps.setRecordStatusId(RecordStatusContains.ACTIVE);
			phieuNhaps.setCreated(new Date());
			phieuNhaps.setCreatedByUserId(userId);
			phieuNhaps.setTongTien(tongTien);
			phieuNhaps.setIsDebt(true);
			phieuNhaps.setLoaiXuatNhapMaLoaiXuatNhap(ENoteType.InitialSupplierDebt.longValue());
			phieuNhaps.setNhaThuocMaNhaThuoc(storeCode);
			phieuNhaps.setStoreId(storeId);
			phieuNhaps.setTargetId(null);
			phieuNhaps.setTargetStoreId(null);
			phieuNhaps.setTargetManagementId(null);
			phieuNhaps.setIsModified(false);
			phieuNhaps.setConnectivityStatusID(0L);
			phieuNhaps.setDaTra(0d);
			phieuNhaps.setDiscount(0d);
			phieuNhaps.setVat(0);
		}
		phieuNhapsRepository.save(phieuNhaps);
	}
	//endregion
}
