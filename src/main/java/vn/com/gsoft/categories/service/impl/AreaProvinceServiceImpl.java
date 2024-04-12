package vn.com.gsoft.categories.service.impl;

import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.AreaProvinceReq;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.AreaProvinceService;


@Service
@Log4j2
public class AreaProvinceServiceImpl extends BaseServiceImpl<AreaProvince, AreaProvinceReq,Long> implements AreaProvinceService {

	private AreaProvinceRepository hdrRepo;
	@Autowired
	public AreaProvinceServiceImpl(AreaProvinceRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
