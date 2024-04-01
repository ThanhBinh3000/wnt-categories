package vn.com.gsoft.categories.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class WarehouseTransitionReq {
    private Integer deliveryNoteId;
    private Integer receiptNoteId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date createdDateTime;
    private Integer sourceStoreId;
    private Integer targetStoreId;
    private String sourceStoreCode;
    private String targetStoreCode;
}

