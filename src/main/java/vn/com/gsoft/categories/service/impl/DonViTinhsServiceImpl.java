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
public class DonViTinhsServiceImpl extends BaseServiceImpl implements DonViTinhsService {

	@Autowired
	private DonViTinhsRepository hdrRepo;

	@Override
	public Page<DonViTinhs> searchPage(DonViTinhsReq req) throws Exception {
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
		return hdrRepo.searchPage(req, pageable);
	}

	@Override
	public List<DonViTinhs> searchList(DonViTinhsReq req) throws Exception {
		return hdrRepo.searchList(req);
	}

	@Override
	public DonViTinhs create(DonViTinhsReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		DonViTinhs nhaThuocs = new DonViTinhs();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public DonViTinhs update(DonViTinhsReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

//		Optional<DonViTinhs> optional = hdrRepo.findById(req.());
//		if (optional.isEmpty()) {
//			throw new Exception("Không tìm thấy dữ liệu.");
//		}

		DonViTinhs nhaThuocs = new DonViTinhs();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public DonViTinhs detail(Long id) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<DonViTinhs> optional = hdrRepo.findById(id);
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

		Optional<DonViTinhs> optional = hdrRepo.findById(id);
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}
		hdrRepo.delete(optional.get());
	}

}
