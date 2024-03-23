package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import vn.com.gsoft.categories.entity.BaseEntity;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class NhomBacSiesReq extends BaseRequest {

    private String maNhomBacSy;
    private String tenNhomBacSy;
    private String ghiChu;
    private String maNhaThuoc;
    private Long recordStatusID;


}
