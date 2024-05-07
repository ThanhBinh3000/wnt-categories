package vn.com.gsoft.categories.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.ESDiagnose;
import vn.com.gsoft.categories.model.dto.ESDiagnoseReq;
import vn.com.gsoft.categories.service.ESDiagnoseService;
import vn.com.gsoft.categories.repository.ESDiagnoseRepository;

import java.util.List;

@Service
public class ESDiagnoseServiceImpl implements ESDiagnoseService {
    @Autowired
    private ESDiagnoseRepository esdiagnoseRepository;

    @Override
    public List<ESDiagnose> searchList(ESDiagnoseReq req) {
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        return esdiagnoseRepository.searchList(req);
    }

    @Override
    public Page<ESDiagnose> searchPage(ESDiagnoseReq req) {
        Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        return esdiagnoseRepository.searchPage(req, pageable);
    }
}
