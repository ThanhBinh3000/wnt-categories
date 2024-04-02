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
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.NhomBacSiesRepository;
import vn.com.gsoft.categories.service.NhomBacSiesService;

import java.lang.reflect.ParameterizedType;
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
		return hdrRepo.save(hdr);
	}

}
