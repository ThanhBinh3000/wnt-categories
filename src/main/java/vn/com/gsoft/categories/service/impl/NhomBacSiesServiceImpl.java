package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.repository.NhomBacSiesRepository;
import vn.com.gsoft.categories.service.NhomBacSiesService;

@Service
@Log4j2
public class NhomBacSiesServiceImpl extends BaseServiceImpl<NhomBacSies, NhomBacSiesReq,Long> implements NhomBacSiesService {
	private NhomBacSiesRepository hdrRepo;
	@Autowired
	public NhomBacSiesServiceImpl(NhomBacSiesRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}
}
