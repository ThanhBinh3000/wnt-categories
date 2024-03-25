package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.NhomBacSiesRepository;
import vn.com.gsoft.categories.service.NhomBacSiesService;


import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class NhomBacSiesServiceImpl extends BaseServiceImpl implements NhomBacSiesService {

	@Autowired
	private NhomBacSiesRepository hdrRepo;

	@Override
	public Page<NhomBacSies> searchPage(NhomBacSiesReq req) throws Exception {
		Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
		return hdrRepo.searchPage(req, pageable);
	}

	@Override
	public List<NhomBacSies> searchList(NhomBacSiesReq req) throws Exception {
		return hdrRepo.searchList(req);
	}

	@Override
	public NhomBacSies create(NhomBacSiesReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");
		NhomBacSies nhaThuocs = new NhomBacSies();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public NhomBacSies update(NhomBacSiesReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<NhomBacSies> optional = hdrRepo.findById(req.getRecordStatusID());
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}

		NhomBacSies nhaThuocs = optional.get();
		BeanUtils.copyProperties(req, nhaThuocs, "id");
		hdrRepo.save(nhaThuocs);
		return nhaThuocs;
	}

	@Override
	public NhomBacSies detail(Long id) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<NhomBacSies> optional = hdrRepo.findById(id);
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}
		return optional.get();
	}

	@Override
	public boolean delete(Long id) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null)
			throw new Exception("Bad request.");

		Optional<NhomBacSies> optional = hdrRepo.findById(id);
		if (optional.isEmpty()) {
			throw new Exception("Không tìm thấy dữ liệu.");
		}
		hdrRepo.delete(optional.get());
		return true;
	}

}
