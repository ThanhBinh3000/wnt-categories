package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.Countries;
import vn.com.gsoft.categories.model.dto.CountriesReq;
import vn.com.gsoft.categories.repository.CountriesRepository;
import vn.com.gsoft.categories.service.CountriesService;


@Service
@Log4j2
public class CountriesServiceImpl extends BaseServiceImpl<Countries, CountriesReq,Long> implements CountriesService {

	private CountriesRepository hdrRepo;
	@Autowired
	public CountriesServiceImpl(CountriesRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
