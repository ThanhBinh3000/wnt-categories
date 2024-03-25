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
import vn.com.gsoft.categories.repository.WarehouseLocationRepository;
import vn.com.gsoft.categories.service.WarehouseLocationService;
import vn.com.gsoft.categories.service.WarehouseLocationService;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class WarehouseLocationServiceImpl extends BaseServiceImpl implements WarehouseLocationService {

	@Autowired
	private WarehouseLocationRepository hdrRepo;

	@Override
	public Page<WarehouseLocation> searchPage(WarehouseLocationReq req) throws Exception {
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
		return hdrRepo.searchPage(req, pageable);
	}

	@Override
	public List<WarehouseLocation> searchList(WarehouseLocationReq req) throws Exception {
		return hdrRepo.searchList(req);
	}

	@Override
	public WarehouseLocation create(WarehouseLocationReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		WarehouseLocation nhaThuocs = new WarehouseLocation();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public WarehouseLocation update(WarehouseLocationReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

//		Optional<WarehouseLocation> optional = hdrRepo.findById(req.getId());
//		if (optional.isEmpty()) {
//			throw new Exception("Không tìm thấy dữ liệu.");
//		}

		WarehouseLocation nhaThuocs = new WarehouseLocation();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public WarehouseLocation detail(Long id) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<WarehouseLocation> optional = hdrRepo.findById(id);
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}
		return optional.get();
	}

	@Override
	public void delete(Long id) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<WarehouseLocation> optional = hdrRepo.findById(id);
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}
		hdrRepo.delete(optional.get());
	}

}
