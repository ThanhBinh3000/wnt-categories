package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomNhaCungCaps;
import vn.com.gsoft.categories.entity.NhomThuocs;
import vn.com.gsoft.categories.model.system.NhomNhaCungCapsReq;
import vn.com.gsoft.categories.model.system.NhomThuocsReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.NhomNhaCungCapsRepository;
import vn.com.gsoft.categories.repository.NhomThuocsRepository;
import vn.com.gsoft.categories.service.NhomNhaCungCapsService;
import vn.com.gsoft.categories.service.NhomThuocsService;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class NhomThuocsServiceImpl extends BaseServiceImpl implements NhomThuocsService {

	@Autowired
	private NhomThuocsRepository hdrRepo;

	@Override
	public Page<NhomThuocs> searchPage(NhomThuocsReq req) throws Exception {
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
		return hdrRepo.searchPage(req, pageable);
	}

	@Override
	public List<NhomThuocs> searchList(NhomThuocsReq req) throws Exception {
		return hdrRepo.searchList(req);
	}

	@Override
	public NhomThuocs create(NhomThuocsReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		NhomThuocs nhaThuocs = new NhomThuocs();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public NhomThuocs update(NhomThuocsReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<NhomThuocs> optional = hdrRepo.findById(req.getStoreId());
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}

		NhomThuocs nhaThuocs = optional.get();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public NhomThuocs detail(Long id) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<NhomThuocs> optional = hdrRepo.findById(id);
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

		Optional<NhomThuocs> optional = hdrRepo.findById(id);
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}
		hdrRepo.delete(optional.get());
	}

}
