package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.entity.ActiveSubstanceContents;
import vn.com.gsoft.categories.entity.ActiveSubstanceDoseOfTimeADay;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.util.List;

@Data
public class ActiveSubstanceReq extends BaseRequest {
    private String name;

    private String doseByWeight;

    private Integer doseMinimum;

    private Integer doseMaximum;

    private List<ActiveSubstanceContents> contents;
    private List<ActiveSubstanceDoseOfTimeADay> doseOfTimeADay;
}
