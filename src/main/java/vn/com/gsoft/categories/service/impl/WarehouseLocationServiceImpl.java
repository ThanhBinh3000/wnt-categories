package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.WarehouseLocation;
import vn.com.gsoft.categories.model.dto.WarehouseLocationReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.ThuocsRepository;
import vn.com.gsoft.categories.repository.WarehouseLocationRepository;
import vn.com.gsoft.categories.service.WarehouseLocationService;
import vn.com.gsoft.categories.service.WarehouseLocationService;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class WarehouseLocationServiceImpl extends BaseServiceImpl<WarehouseLocation, WarehouseLocationReq,Long> implements WarehouseLocationService {

	private WarehouseLocationRepository hdrRepo;

	@Autowired
	public WarehouseLocationServiceImpl(WarehouseLocationRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}
}
