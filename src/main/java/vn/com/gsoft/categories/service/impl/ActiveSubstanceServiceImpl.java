package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.ActiveSubstance;
import vn.com.gsoft.categories.model.dto.ActiveSubstanceReq;
import vn.com.gsoft.categories.repository.ActiveSubstanceRepository;
import vn.com.gsoft.categories.service.ActiveSubstanceService;

import java.util.List;

@Service
@Log4j2
public class ActiveSubstanceServiceImpl extends BaseServiceImpl<ActiveSubstance, ActiveSubstanceReq, Long> implements ActiveSubstanceService {
    private ActiveSubstanceRepository hdrRepo;

    @Autowired
    public ActiveSubstanceServiceImpl(ActiveSubstanceRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

    @Override
    public Page<ActiveSubstance> searchPage(ActiveSubstanceReq req) throws Exception {
        Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        return hdrRepo.searchPage(req, pageable);
    }

    @Override
    public List<ActiveSubstance> searchList(ActiveSubstanceReq req) throws Exception {
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        return hdrRepo.searchList(req);
    }
}
