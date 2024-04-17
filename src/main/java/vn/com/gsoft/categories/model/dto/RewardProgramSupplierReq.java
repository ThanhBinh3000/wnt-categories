package vn.com.gsoft.categories.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.util.Date;

@Data
public class RewardProgramSupplierReq extends BaseRequest {
    private Integer supplierId;

    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date fromDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date toDate;

    private String storeCode;
}
