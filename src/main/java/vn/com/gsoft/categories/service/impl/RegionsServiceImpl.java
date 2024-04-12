package vn.com.gsoft.categories.service.impl;

import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.RegionsReq;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.RegionsService;


@Service
@Log4j2
public class RegionsServiceImpl extends BaseServiceImpl<Regions, RegionsReq,Long> implements RegionsService {

	private RegionsRepository hdrRepo;
	@Autowired
	public RegionsServiceImpl(RegionsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
