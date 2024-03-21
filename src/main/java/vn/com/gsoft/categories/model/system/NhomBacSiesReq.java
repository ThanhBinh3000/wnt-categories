package vn.com.gsoft.categories.model.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import vn.com.gsoft.categories.entity.BaseEntity;

@Data
public class NhomBacSiesReq extends BaseRequest {

    private String maNhomBacSy;
    private String tenNhomBacSy;
    private String ghiChu;
    private String maNhaThuoc;
    private Long recordStatusID;


}
