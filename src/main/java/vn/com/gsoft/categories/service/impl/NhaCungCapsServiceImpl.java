package vn.com.gsoft.categories.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	//endregion

	//region Constructor
	@Autowired
	public NhaCungCapsServiceImpl(NhaCungCapsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}
    //endregions

	//region Interface Implementation
	@Override
	public Page<NhaCungCapsRes> searchSupplierManagementPage(NhaCungCapsReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		String storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		req.setMaNhaThuoc(storeCode);
		req.setSupplierTypeId(0);
		req.setRecordStatusId(req.getDataDelete() ? RecordStatusContains.DELETED : RecordStatusContains.ACTIVE);
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
		return DataUtils.convertPage(hdrRepo.searchSupplierManagementPage(req, pageable), NhaCungCapsRes.class);
	}
	@Override
	public NhaCungCaps create(NhaCungCapsReq req) throws Exception{
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		var storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		req.setMaNhaThuoc(storeCode);
		//kiểm tra tên nhà cung cấp có tồn tại chưa
		if(!req.getTenNhaCungCap().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByName(storeCode, req.getTenNhaCungCap(), null);
			if(!supplier.isEmpty())
				throw  new Exception("Tên nhà cung cấp đã tồn tại");
		}
		//kiểm tra mã vạch
		if(!req.getBarcode().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByBarcode(storeCode, req.getBarcode(), null);
			if(!supplier.isEmpty())
				throw new Exception("Mã vạch đã tồn tại");
		}
		//kiểm tra mã
		if(!req.getCode().isEmpty()){
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
			//taoPhieuDauKy(storeCode, e.getId(), userInfo.getId(), e.getNoDauKy(), userInfo.getNhaThuoc().getId());
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
		if(!req.getTenNhaCungCap().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByName(storeCode, req.getTenNhaCungCap(), req.getId());
			if(!supplier.isEmpty())
				throw  new Exception("Tên nhà cung cấp đã tồn tại");
		}
		//kiểm tra mã vạch
		if(!req.getBarcode().isEmpty()){
			var supplier = this.hdrRepo.findNhaCungCapByBarcode(storeCode, req.getBarcode(), req.getId());
			if(!supplier.isEmpty())
				throw new Exception("Mã vạch đã tồn tại");
		}
		//kiểm tra mã
		if(!req.getCode().isEmpty()){
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
			//taoPhieuDauKy(storeCode, e.getId(), userInfo.getId(), e.getNoDauKy(), userInfo.getNhaThuoc().getId());
		}
		return e;
	}
	//endregion

	//region Private Methods
	//tạo phiếu đầu kỳ
	private void taoPhieuDauKy(String storeCode, Long maNhaCungCap,
							   Long userId, BigDecimal tongTien, Long storeId) throws Exception{
		var phieuNhapNoDauKy = new PhieuNhapNoDauKyRes();
		List<PhieuNhapNoDauKyRes> phieuNhapNoDauKys = this.hdrRepo.findPhieuNhapNoDauKyById(storeCode, maNhaCungCap);
		Long recordStatusId = 0L;
		if(!phieuNhapNoDauKys.isEmpty()){
			recordStatusId = tongTien.compareTo(BigDecimal.valueOf(0)) == 0
					? RecordStatusContains.DELETED : RecordStatusContains.ACTIVE;
			phieuNhapNoDauKy.setModified(Date.from(Instant.now()));
			phieuNhapNoDauKy.setModifiedByUserId(userId);
			phieuNhapNoDauKy.setRecordStatusId(recordStatusId);
			phieuNhapNoDauKy.setTongTien(tongTien);
			phieuNhapNoDauKy.setId(phieuNhapNoDauKys.get(0).getId());
			hdrRepo.updatePhieuNhapNoDauKy(phieuNhapNoDauKy);
		}else{
			phieuNhapNoDauKy.setNgayNhap(Date.from(Instant.now()));
			phieuNhapNoDauKy.setCreated(Date.from(Instant.now()));
			phieuNhapNoDauKy.setLoaiXuatNhap_MaLoaiXuatNhap(7L);
			phieuNhapNoDauKy.setMaNhaCungCap(maNhaCungCap);
			phieuNhapNoDauKy.setCreatedByUserId(userId);
			phieuNhapNoDauKy.setIsDebt(true);
			phieuNhapNoDauKy.setStoreId(storeId);
			phieuNhapNoDauKy.setMaNhaThuoc(storeCode);
			phieuNhapNoDauKy.setTongTien(tongTien);
			phieuNhapNoDauKy.setRecordStatusId(RecordStatusContains.ACTIVE);

			this.hdrRepo.insertPhieuNhapNoDauKy(phieuNhapNoDauKy);
		}
	}
	//endregion
}
