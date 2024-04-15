package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.TrienKhais;
import vn.com.gsoft.categories.model.dto.TrienKhaisReq;
import vn.com.gsoft.categories.repository.TrienKhaisRepository;
import vn.com.gsoft.categories.service.TrienKhaisService;


@Service
@Log4j2
public class TrienKhaisServiceImpl extends BaseServiceImpl<TrienKhais, TrienKhaisReq,Long> implements TrienKhaisService {

	private TrienKhaisRepository hdrRepo;
	@Autowired
	public TrienKhaisServiceImpl(TrienKhaisRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
