package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class AreaReq extends BaseRequest {
    private String areaCode;
    private String areaName;
}
