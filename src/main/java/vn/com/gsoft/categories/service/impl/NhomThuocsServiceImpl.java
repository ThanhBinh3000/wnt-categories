package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomThuocs;
import vn.com.gsoft.categories.model.dto.NhomThuocsReq;
import vn.com.gsoft.categories.repository.NhomThuocsRepository;
import vn.com.gsoft.categories.service.NhomThuocsService;

@Service
@Log4j2
public class NhomThuocsServiceImpl extends BaseServiceImpl<NhomThuocs, NhomThuocsReq,Long> implements NhomThuocsService {

	private NhomThuocsRepository hdrRepo;
	@Autowired
	public NhomThuocsServiceImpl(NhomThuocsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
