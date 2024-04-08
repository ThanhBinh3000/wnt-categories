package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class BanksReq extends BaseRequest {
    private String name;
    private String code;
    private String bin;
    private String shortName;
    private String logo;
    private String swiftCode;
    private Integer transferSupported;
    private Integer lookupSupported;
    private Integer support;
    private Boolean isTransfer;
}
