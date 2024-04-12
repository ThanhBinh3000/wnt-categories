package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Column;
import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class RegionsReq extends BaseRequest {
    private String name;
    private Long countryId;
    private Integer levelId;
}
