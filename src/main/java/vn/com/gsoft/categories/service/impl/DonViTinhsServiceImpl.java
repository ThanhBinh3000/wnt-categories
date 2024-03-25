package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.DonViTinhs;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.model.dto.DonViTinhsReq;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.DonViTinhsRepository;
import vn.com.gsoft.categories.repository.NhomBacSiesRepository;
import vn.com.gsoft.categories.service.DonViTinhsService;
import vn.com.gsoft.categories.service.NhomBacSiesService;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class DonViTinhsServiceImpl extends BaseServiceImpl<DonViTinhs, DonViTinhsReq,Long> implements DonViTinhsService {

	private DonViTinhsRepository hdrRepo;
	@Autowired
	public DonViTinhsServiceImpl(DonViTinhsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}
}
