package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Transient;
import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.util.List;

@Data
public class OrderStoreMappingReq extends BaseRequest {
    private String storeCode;
    private String targetStoreCode;
    private Boolean isDefault;
    private Long mappingTypeId;
    private List<String> targetStoreCodes;

    // Transient
    @Transient
    private Integer updateTypeId;
    @Transient
    private Boolean updateValue;
}
