package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.BankAccount;
import vn.com.gsoft.categories.model.dto.BankAccountReq;
import vn.com.gsoft.categories.repository.BankAccountRepository;
import vn.com.gsoft.categories.service.BankAccountService;

import java.util.List;

@Service
@Log4j2
public class BankAccountServiceImpl extends BaseServiceImpl<BankAccount, BankAccountReq, Long> implements BankAccountService {
    private BankAccountRepository hdrRepo;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

    @Override
    public Page<BankAccount> searchPage(BankAccountReq req) throws Exception {
        Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        req.setStoreCode(getLoggedUser().getNhaThuoc().getMaNhaThuoc());
        return hdrRepo.searchPage(req, pageable);
    }

    @Override
    public List<BankAccount> searchList(BankAccountReq req) throws Exception {
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        req.setStoreCode(getLoggedUser().getNhaThuoc().getMaNhaThuoc());
        return hdrRepo.searchList(req);
    }
}
