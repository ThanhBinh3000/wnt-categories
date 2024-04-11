package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.TieuChiTrienKhais;
import vn.com.gsoft.categories.model.dto.TieuChiTrienKhaisReq;
import vn.com.gsoft.categories.repository.TieuChiTrienKhaisRepository;
import vn.com.gsoft.categories.service.TieuChiTrienKhaisService;


@Service
@Log4j2
public class TieuChiTrienKhaisServiceImpl extends BaseServiceImpl<TieuChiTrienKhais, TieuChiTrienKhaisReq,Long> implements TieuChiTrienKhaisService {

	private TieuChiTrienKhaisRepository hdrRepo;
	@Autowired
	public TieuChiTrienKhaisServiceImpl(TieuChiTrienKhaisRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
