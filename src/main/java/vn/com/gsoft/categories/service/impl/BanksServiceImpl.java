package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.Banks;
import vn.com.gsoft.categories.model.dto.BanksReq;
import vn.com.gsoft.categories.repository.BanksRepository;
import vn.com.gsoft.categories.service.BanksService;

@Service
@Log4j2
public class BanksServiceImpl extends BaseServiceImpl<Banks, BanksReq, Long> implements BanksService {
    private BanksRepository hdrRepo;

    @Autowired
    public BanksServiceImpl(BanksRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }
}
