package vn.com.gsoft.categories.service.impl;

import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.NhaCungCapsReq;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.NhaCungCapsService;


@Service
@Log4j2
public class NhaCungCapsServiceImpl extends BaseServiceImpl<NhaCungCaps, NhaCungCapsReq,Long> implements NhaCungCapsService {

	private NhaCungCapsRepository hdrRepo;
	@Autowired
	public NhaCungCapsServiceImpl(NhaCungCapsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
