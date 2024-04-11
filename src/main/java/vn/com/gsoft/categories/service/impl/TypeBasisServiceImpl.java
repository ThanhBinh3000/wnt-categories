package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.TypeBasis;
import vn.com.gsoft.categories.model.dto.TypeBasisReq;
import vn.com.gsoft.categories.repository.TypeBasisRepository;
import vn.com.gsoft.categories.service.TypeBasisService;


@Service
@Log4j2
public class TypeBasisServiceImpl extends BaseServiceImpl<TypeBasis, TypeBasisReq,Long> implements TypeBasisService {

	private TypeBasisRepository hdrRepo;
	@Autowired
	public TypeBasisServiceImpl(TypeBasisRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
