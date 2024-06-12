package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class CountriesReq extends BaseRequest {
    private Long id;
    private String iso;
    private String iso3;
    private String name;
    private Integer numCode;
    private Integer phoneCode;
}
