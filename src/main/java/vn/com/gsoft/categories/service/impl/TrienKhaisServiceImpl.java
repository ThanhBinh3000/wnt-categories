package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.OrderStoreMappingConstant;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.OrderStoreMapping;
import vn.com.gsoft.categories.entity.TieuChiTrienKhais;
import vn.com.gsoft.categories.entity.TrienKhais;
import vn.com.gsoft.categories.model.dto.OrderStoreMappingReq;
import vn.com.gsoft.categories.model.dto.TieuChiTrienKhaisReq;
import vn.com.gsoft.categories.model.dto.TrienKhaisReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.TieuChiTrienKhaisRepository;
import vn.com.gsoft.categories.repository.TrienKhaisRepository;
import vn.com.gsoft.categories.service.TieuChiTrienKhaisService;
import vn.com.gsoft.categories.service.TrienKhaisService;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class TrienKhaisServiceImpl extends BaseServiceImpl<TrienKhais, TrienKhaisReq,Long> implements TrienKhaisService {

	private TrienKhaisRepository hdrRepo;

	@Autowired
	public TrienKhaisServiceImpl(TrienKhaisRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

	@Override
	public TrienKhais create(TrienKhaisReq req) throws Exception {
		Profile userInfo = this.getLoggedUser();
		if (userInfo == null) throw new Exception("Bad request.");
		List<TrienKhais> trienKhaisList = hdrRepo.findAllByMaNhaThuoc(req.getMaNhaThuoc());
		if(!trienKhaisList.isEmpty()){
			hdrRepo.deleteAll(trienKhaisList);
		}
		TrienKhais e = new TrienKhais();
		if(req.getTieuChiTrienKhaiId() != null){
			BeanUtils.copyProperties(req, e);
			hdrRepo.save(e);
		}
		return e;
	}
}
