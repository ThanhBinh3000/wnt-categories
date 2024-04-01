package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class NhomBacSiesReq extends BaseRequest {

    private String tenNhomBacSy;
    private String ghiChu;
    private String maNhaThuoc;
}
