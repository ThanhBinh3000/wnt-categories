package vn.com.gsoft.categories.service.impl;

import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.TinhThanhsReq;
import vn.com.gsoft.categories.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.service.TinhThanhsService;


@Service
@Log4j2
public class TinhThanhsServiceImpl extends BaseServiceImpl<TinhThanhs, TinhThanhsReq,Long> implements TinhThanhsService {

	private TinhThanhsRepository hdrRepo;
	@Autowired
	public TinhThanhsServiceImpl(TinhThanhsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
