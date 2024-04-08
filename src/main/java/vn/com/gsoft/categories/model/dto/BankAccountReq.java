package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

@Data
public class BankAccountReq extends BaseRequest {
    private String accountName;
    private String storeCode;
    private String bankBin;
    private String shortName;
    private String accountNo;
}
