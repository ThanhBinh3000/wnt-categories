package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.entity.NhomKhachHangs;
import vn.com.gsoft.categories.model.system.NhomBacSiesReq;
import vn.com.gsoft.categories.model.system.NhomKhachHangsReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.NhomBacSiesRepository;
import vn.com.gsoft.categories.repository.NhomKhachHangsRepository;
import vn.com.gsoft.categories.service.NhomBacSiesService;
import vn.com.gsoft.categories.service.NhomKhachHangsService;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class NhomKhachHangsServiceImpl extends BaseServiceImpl implements NhomKhachHangsService {

	@Autowired
	private NhomKhachHangsRepository hdrRepo;

	@Override
	public Page<NhomKhachHangs> searchPage(NhomKhachHangsReq req) throws Exception {
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
		return hdrRepo.searchPage(req, pageable);
	}

	@Override
	public List<NhomKhachHangs> searchList(NhomKhachHangsReq req) throws Exception {
		return hdrRepo.searchList(req);
	}

	@Override
	public NhomKhachHangs create(NhomKhachHangsReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		NhomKhachHangs nhaThuocs = new NhomKhachHangs();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public NhomKhachHangs update(NhomKhachHangsReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<NhomKhachHangs> optional = hdrRepo.findById(req.getRecordStatusID());
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}

		NhomKhachHangs nhaThuocs = optional.get();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public NhomKhachHangs detail(Long id) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<NhomKhachHangs> optional = hdrRepo.findById(id);
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

		Optional<NhomKhachHangs> optional = hdrRepo.findById(id);
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}
		hdrRepo.delete(optional.get());
	}

}
