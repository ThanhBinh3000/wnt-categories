package vn.com.gsoft.categories.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.NhomNhaCungCaps;
import vn.com.gsoft.categories.model.dto.NhomNhaCungCapsReq;
import vn.com.gsoft.categories.repository.NhomNhaCungCapsRepository;
import vn.com.gsoft.categories.service.NhomNhaCungCapsService;

@Service
@Log4j2
public class NhomNhaCungCapsServiceImpl extends BaseServiceImpl<NhomNhaCungCaps, NhomNhaCungCapsReq, Long> implements NhomNhaCungCapsService {
    private NhomNhaCungCapsRepository hdrRepo;

    @Autowired
    public NhomNhaCungCapsServiceImpl(NhomNhaCungCapsRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

}
