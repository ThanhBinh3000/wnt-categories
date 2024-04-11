package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Column;
import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class TieuChiTrienKhaisReq extends BaseRequest {
    private String name;
    private Long type;
}
