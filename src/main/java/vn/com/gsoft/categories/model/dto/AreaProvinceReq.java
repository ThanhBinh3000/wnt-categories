package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class AreaProvinceReq extends BaseRequest {
    private Long areaId;
    private Long provinceId;
}
