package vn.com.gsoft.categories.service.impl;

import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.AreaReq;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.AreaService;


@Service
@Log4j2
public class AreaServiceImpl extends BaseServiceImpl<Area, AreaReq,Long> implements AreaService {

	private AreaRepository hdrRepo;
	@Autowired
	public AreaServiceImpl(AreaRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
