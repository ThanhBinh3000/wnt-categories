package vn.com.gsoft.categories.service.impl;

import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.CitiesReq;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.CitiesService;


@Service
@Log4j2
public class CitiesServiceImpl extends BaseServiceImpl<Cities, CitiesReq,Long> implements CitiesService {

	private CitiesRepository hdrRepo;
	@Autowired
	public CitiesServiceImpl(CitiesRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
