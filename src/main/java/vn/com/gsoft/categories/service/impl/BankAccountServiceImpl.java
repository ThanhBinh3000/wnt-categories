package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.BankAccount;
import vn.com.gsoft.categories.entity.Banks;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.model.dto.BankAccountReq;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.BankAccountRepository;
import vn.com.gsoft.categories.repository.BanksRepository;
import vn.com.gsoft.categories.service.BankAccountService;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class BankAccountServiceImpl extends BaseServiceImpl<BankAccount, BankAccountReq, Long> implements BankAccountService {
    private BankAccountRepository hdrRepo;

    @Autowired
    public BanksRepository banksRepository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

    @Override
    public Page<BankAccount> searchPage(BankAccountReq req) throws Exception {
        Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        if(req.getStoreCode() == null || req.getStoreCode().isEmpty()){
            req.setStoreCode(getLoggedUser().getNhaThuoc().getMaNhaThuoc());
        }
        Page<BankAccount> bankAccounts = hdrRepo.searchPage(req, pageable);
        bankAccounts.getContent().forEach( item -> {
            if(item.getBankBin() != null){
                Optional<Banks> byBin = banksRepository.findByBin(item.getBankBin());
                if(byBin.isPresent()){
                    Banks bank = byBin.get();
                    item.setBankLogo(bank.getLogo());
                    item.setBankCode(bank.getCode());
                    item.setBankName(bank.getName());
                    item.setBankShortName(bank.getShortName());
                }
            }
        });
        return bankAccounts;
    }

    @Override
    public List<BankAccount> searchList(BankAccountReq req) throws Exception {
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        req.setStoreCode(getLoggedUser().getNhaThuoc().getMaNhaThuoc());
        return hdrRepo.searchList(req);
    }

    @Override
    public BankAccount create(BankAccountReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");
        BankAccount hdr = new BankAccount();
        BeanUtils.copyProperties(req, hdr, "id");
        if(hdr.getRecordStatusId() == null){
            hdr.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        hdr.setStoreCode(userInfo.getNhaThuoc().getMaNhaThuoc());
        return hdrRepo.save(hdr);
    }

    @Override
    public BankAccount update(BankAccountReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");
        Optional<BankAccount> optional = hdrRepo.findById(req.getId());
        if (optional.isEmpty()) {
            throw new Exception("Không tìm thấy dữ liệu.");
        }
        BankAccount hdr = optional.get();
        BeanUtils.copyProperties(req, hdr, "id");
        if(hdr.getRecordStatusId() == null){
            hdr.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        hdr.setStoreCode(userInfo.getNhaThuoc().getMaNhaThuoc());
        return hdrRepo.save(hdr);
    }
}
