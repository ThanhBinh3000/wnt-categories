package vn.com.gsoft.categories.service.impl;

import jakarta.persistence.Tuple;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.RewardProgramSupplier;
import vn.com.gsoft.categories.model.dto.*;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.RewardProgramSupplierRepository;
import vn.com.gsoft.categories.service.RewardProgramSupplierService;
import vn.com.gsoft.categories.util.system.DataUtils;

import java.util.List;
import java.util.Map;
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
		var listChuongTrinhTraThuong = DataUtils.convertList(hdrRepo.searchListManagement(req), RewardProgramSupplierRes.class);
		//lấy ra mã nhà cung cấp
		var supplierIds = listChuongTrinhTraThuong.stream()
				.map(RewardProgramSupplierRes::getId).collect(Collectors.toList());
		if(!supplierIds.isEmpty()){
			var phieuThus = DataUtils.convertList(hdrRepo.findPhieuThuKhacByMaNhaCungCap(storeCode, (Long[]) supplierIds.toArray()), PhieuThuKhacReq.class);
			Map<Long, List<PhieuThuKhacReq>> supplierListGrouped =
					phieuThus.stream().collect(Collectors.groupingBy(w -> w.getId()));
			if(!phieuThus.isEmpty()){
				for(var i : listChuongTrinhTraThuong){
                   if(supplierListGrouped.containsKey(i.getSupplierId())){
					   i.setItems(supplierListGrouped.get(i.getSupplierId()));
				   }
				}
			}
		}
		return listChuongTrinhTraThuong;
	}
	//endregion
}
