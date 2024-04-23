package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.entity.NhomNhaCungCaps;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.dto.NhomNhaCungCapsReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.NhomBacSiesRepository;
import vn.com.gsoft.categories.service.NhomBacSiesService;

import java.lang.reflect.ParameterizedType;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class NhomBacSiesServiceImpl extends BaseServiceImpl<NhomBacSies, NhomBacSiesReq,Long> implements NhomBacSiesService {
	private NhomBacSiesRepository hdrRepo;
	@Autowired
	public NhomBacSiesServiceImpl(NhomBacSiesRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

	@Override
	public Page<NhomBacSies> searchPage(NhomBacSiesReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		var storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
		req.setMaNhaThuoc(storeCode);
		req.setRecordStatusId(RecordStatusContains.ACTIVE);
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
		return hdrRepo.searchPage(req, pageable);
	}

	@Override
	public List<NhomBacSies> searchList(NhomBacSiesReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		req.setMaNhaThuoc(userInfo.getNhaThuoc().getMaNhaThuoc());
		req.setRecordStatusId(RecordStatusContains.ACTIVE);
		return hdrRepo.searchList(req);
	}

	@Override
	public NhomBacSies create(NhomBacSiesReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		NhomBacSies hdr = new NhomBacSies();
		BeanUtils.copyProperties(req, hdr, "id");
		if(hdr.getRecordStatusId() == null){
			req.setRecordStatusId(RecordStatusContains.ACTIVE);
		}
		hdr.setMaNhaThuoc(userInfo.getNhaThuoc().getMaNhaThuoc());
		hdr.setCreatedByUserId(userInfo.getId());
		hdr.setCreated(Date.from(Instant.now()));
		return hdrRepo.save(hdr);
	}

	@Override
	public NhomBacSies update(NhomBacSiesReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		Optional<NhomBacSies> optional = hdrRepo.findById(req.getId());
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}
		NhomBacSies hdr = optional.get();
		BeanUtils.copyProperties(req, hdr, "id");
		if(hdr.getRecordStatusId() == null){
			hdr.setRecordStatusId(RecordStatusContains.ACTIVE);
		}
		hdr.setMaNhaThuoc(userInfo.getNhaThuoc().getMaNhaThuoc());
		hdr.setModifiedByUserId(userInfo.getId());
		hdr.setModified(Date.from(Instant.now()));
		return hdrRepo.save(hdr);
	}

}
