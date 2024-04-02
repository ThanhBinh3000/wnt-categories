package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.entity.NhomKhachHangs;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.dto.NhomKhachHangsReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.NhomKhachHangsRepository;
import vn.com.gsoft.categories.service.NhomKhachHangsService;

import java.util.Optional;

@Service
@Log4j2
public class NhomKhachHangsServiceImpl extends BaseServiceImpl<NhomKhachHangs, NhomKhachHangsReq, Long> implements NhomKhachHangsService {
    private NhomKhachHangsRepository hdrRepo;

    @Autowired
    public NhomKhachHangsServiceImpl(NhomKhachHangsRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

    @Override
    public NhomKhachHangs create(NhomKhachHangsReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");
        NhomKhachHangs hdr = new NhomKhachHangs();
        BeanUtils.copyProperties(req, hdr, "id");
        if(hdr.getRecordStatusId() == null){
            req.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        // Set theo user đăng nhập
//        hdr.setArchivedId(userInfo.getNhaThuoc().get);
//        hdr.setStoreId();
        return hdrRepo.save(hdr);
    }

    @Override
    public NhomKhachHangs update(NhomKhachHangsReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");
        Optional<NhomKhachHangs> optional = hdrRepo.findById(req.getId());
        if (optional.isEmpty()) {
            throw new Exception("Không tìm thấy dữ liệu.");
        }
        NhomKhachHangs hdr = optional.get();
        BeanUtils.copyProperties(req, hdr, "id");
        if(hdr.getRecordStatusId() == null){
            hdr.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        // Set theo user đăng nhập
//        hdr.setArchivedId(userInfo.getNhaThuoc().get);
//        hdr.setStoreId();
//        hdr.setMaNhaThuoc(userInfo.getNhaThuoc().getMaNhaThuoc());
        return hdrRepo.save(hdr);
    }

}
