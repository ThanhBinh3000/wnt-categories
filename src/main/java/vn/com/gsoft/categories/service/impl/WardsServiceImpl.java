package vn.com.gsoft.categories.service.impl;

import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.WardsReq;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.WardsService;


@Service
@Log4j2
public class WardsServiceImpl extends BaseServiceImpl<Wards, WardsReq,Long> implements WardsService {

	private WardsRepository hdrRepo;
	@Autowired
	public WardsServiceImpl(WardsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
