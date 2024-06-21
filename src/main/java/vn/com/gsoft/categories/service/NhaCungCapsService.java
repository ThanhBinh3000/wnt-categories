package vn.com.gsoft.categories.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.NhaCungCapsReq;
import vn.com.gsoft.categories.model.dto.NhaCungCapsRes;
import vn.com.gsoft.categories.repository.*;

public interface NhaCungCapsService extends BaseService<NhaCungCaps, NhaCungCapsReq, Long> {
    boolean importExcel(MultipartFile file) throws Exception;

}