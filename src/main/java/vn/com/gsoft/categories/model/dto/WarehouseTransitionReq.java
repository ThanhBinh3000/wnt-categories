package vn.com.gsoft.categories.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class WarehouseTransitionReq {
    private Long deliveryNoteId;
    private Long receiptNoteId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date createdDateTime;
    private Long sourceStoreId;
    private Long targetStoreId;
    private String sourceStoreCode;
    private String targetStoreCode;
}

