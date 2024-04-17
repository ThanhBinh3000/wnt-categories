package vn.com.gsoft.categories.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.persistence.Tuple;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.NhaCungCaps;
import vn.com.gsoft.categories.entity.RewardProgramSupplier;
import vn.com.gsoft.categories.model.dto.*;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.RewardProgramSupplierRepository;
import vn.com.gsoft.categories.service.RewardProgramSupplierService;
import vn.com.gsoft.categories.util.system.DataUtils;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


@Service
@Log4j2
public class RewardProgramSupplierServiceImpl extends BaseServiceImpl<RewardProgramSupplier, RewardProgramSupplierReq, Long> implements RewardProgramSupplierService {

	//region Fields
	private RewardProgramSupplierRepository hdrRepo;
	//endregion

	//region Constructor
	@Autowired
	public RewardProgramSupplierServiceImpl(RewardProgramSupplierRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}
    //endregions

	//region Interface Implementation
	@Override
	public List<RewardProgramSupplierRes> searchManagementList(RewardProgramSupplierReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		String storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		req.setMaNhaThuoc(storeCode);
		req.setRecordStatusId(RecordStatusContains.ACTIVE);
		var listChuongTrinhTraThuong = DataUtils.convertList(hdrRepo.searchListManagement(req), RewardProgramSupplierRes.class);

		var rewardProgramIds = listChuongTrinhTraThuong.stream()
				.map(RewardProgramSupplierRes::getId).collect(Collectors.toList());

		if(!rewardProgramIds.isEmpty()){
			//lấy ra phiếu thu khác có gán chương trình trả thưởng
			var phieuThus = DataUtils.convertList(hdrRepo.findPhieuThuKhacByMaNhaCungCap(storeCode, rewardProgramIds),
					PhieuThuKhacReq.class);
			Map<Long, List<PhieuThuKhacReq>> rewardProgramListGrouped =
					phieuThus.stream().collect(Collectors.groupingBy(w -> w.getRewardProgramId()));

			if(!phieuThus.isEmpty()){
				for(var i : listChuongTrinhTraThuong){
                   if(rewardProgramListGrouped.containsKey(i.getId())){
					   i.setItems(rewardProgramListGrouped.get(i.getId()));
				   }
				}
			}
		}
		return listChuongTrinhTraThuong;
	}
	//thêm mới
	@Override
	public RewardProgramSupplier create (RewardProgramSupplierReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		String storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		RewardProgramSupplier e =new RewardProgramSupplier();
		BeanUtils.copyProperties(req, e,"id");
		e.setStoreCode(storeCode);
		e.setRecordStatusId(RecordStatusContains.ACTIVE);
		e.setCreated(Date.from(Instant.now()));
		e.setCreatedByUserId(userInfo.getId());
		e = hdrRepo.save(e);
		return e;
	}
	@Override
	public RewardProgramSupplier update (RewardProgramSupplierReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<RewardProgramSupplier> optional = this.hdrRepo.findById(req.getId());
		RewardProgramSupplier e = optional.get();
		e.setModified(Date.from(Instant.now()));
		e.setModifiedByUserId(userInfo.getId());
		e.setContent(req.getContent());
		e.setFromDate(req.getFromDate());
		e.setToDate(req.getToDate());
		e = hdrRepo.save(e);
		return e;
	}
	//endregion
}
