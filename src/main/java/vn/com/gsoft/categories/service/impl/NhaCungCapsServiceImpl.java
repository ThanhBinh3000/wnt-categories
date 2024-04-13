package vn.com.gsoft.categories.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.NhaCungCapsReq;
import vn.com.gsoft.categories.model.dto.NhaCungCapsRes;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.NhaCungCapsService;
import vn.com.gsoft.categories.util.system.DataUtils;


@Service
@Log4j2
public class NhaCungCapsServiceImpl extends BaseServiceImpl<NhaCungCaps, NhaCungCapsReq,Long> implements NhaCungCapsService {

	private NhaCungCapsRepository hdrRepo;
	@Autowired
	public NhaCungCapsServiceImpl(NhaCungCapsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

	@Override
	public Page<NhaCungCapsRes> searchSupplierManagementPage(NhaCungCapsReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		String storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		req.setMaNhaThuoc(storeCode);
		req.setRecordStatusId(req.getDataDelete() ? RecordStatusContains.DELETED : RecordStatusContains.ACTIVE);
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
		return DataUtils.convertPage(hdrRepo.searchSupplierManagementPage(req, pageable), NhaCungCapsRes.class);
	}
}
