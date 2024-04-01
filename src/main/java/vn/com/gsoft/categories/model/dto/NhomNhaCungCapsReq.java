package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Id;
import lombok.*;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class NhomNhaCungCapsReq extends BaseRequest {

    private String tenNhomNhaCungCap;
    private String ghiChu;
    private String maNhaThuoc;
    private Boolean active;
    private Boolean isDefault;
    private Long archivedId;
    private Long storeId;


}
