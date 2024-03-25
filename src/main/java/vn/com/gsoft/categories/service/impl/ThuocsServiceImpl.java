package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.entity.Thuocs;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.dto.ThuocsReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.DonViTinhsRepository;
import vn.com.gsoft.categories.repository.NhomBacSiesRepository;
import vn.com.gsoft.categories.repository.ThuocsRepository;
import vn.com.gsoft.categories.service.NhomBacSiesService;
import vn.com.gsoft.categories.service.ThuocsService;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ThuocsServiceImpl extends BaseServiceImpl<Thuocs, ThuocsReq,Long> implements ThuocsService {

	private ThuocsRepository hdrRepo;

	@Autowired
	public ThuocsServiceImpl(ThuocsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
