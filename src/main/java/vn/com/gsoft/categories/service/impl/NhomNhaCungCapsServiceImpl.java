package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.entity.NhomKhachHangs;
import vn.com.gsoft.categories.entity.NhomNhaCungCaps;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.dto.NhomKhachHangsReq;
import vn.com.gsoft.categories.model.dto.NhomNhaCungCapsReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.NhomNhaCungCapsRepository;
import vn.com.gsoft.categories.service.NhomNhaCungCapsService;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class NhomNhaCungCapsServiceImpl extends BaseServiceImpl<NhomNhaCungCaps, NhomNhaCungCapsReq, Long> implements NhomNhaCungCapsService {
    private NhomNhaCungCapsRepository hdrRepo;

    @Autowired
    public NhomNhaCungCapsServiceImpl(NhomNhaCungCapsRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }
    @Override
    public Page<NhomNhaCungCaps> searchPage(NhomNhaCungCapsReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");
        var storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
        req.setMaNhaThuoc(storeCode);
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        return hdrRepo.searchPage(req, pageable);
    }
    @Override
    public List<NhomNhaCungCaps> searchList(NhomNhaCungCapsReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");
        var storeCode = userInfo.getNhaThuoc().getMaNhaThuoc();
        req.setMaNhaThuoc(storeCode);
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        return hdrRepo.searchList(req);
    }
    @Override
    public NhomNhaCungCaps create(NhomNhaCungCapsReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");
        NhomNhaCungCaps hdr = new NhomNhaCungCaps();
        BeanUtils.copyProperties(req, hdr, "id");
        if(hdr.getRecordStatusId() == null){
            req.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        hdr.setMaNhaThuoc(userInfo.getNhaThuoc().getMaNhaThuoc());
//        hdr.setArchivedId(userInfo.getNhaThuoc().get);
//        hdr.setStoreId();
        return hdrRepo.save(hdr);
    }

    @Override
    public NhomNhaCungCaps update(NhomNhaCungCapsReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");
        Optional<NhomNhaCungCaps> optional = hdrRepo.findById(req.getId());
        if (optional.isEmpty()) {
            throw new Exception("Không tìm thấy dữ liệu.");
        }
        NhomNhaCungCaps hdr = optional.get();
        BeanUtils.copyProperties(req, hdr, "id");
        if(hdr.getRecordStatusId() == null){
            hdr.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        hdr.setMaNhaThuoc(userInfo.getNhaThuoc().getMaNhaThuoc());
//        hdr.setArchivedId(userInfo.getNhaThuoc().get);
//        hdr.setStoreId();
        return hdrRepo.save(hdr);
    }

}
