package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "WarehouseTransition")
public class WarehouseTransitionReq {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "DeliveryNoteId")
    private Integer deliveryNoteId;
    @Column(name = "ReceiptNoteId")
    private Integer receiptNoteId;
    @Column(name = "RecordStatusId")
    private Integer recordStatusId;
    @Column(name = "CreatedDateTime")
    private Date createdDateTime;
    @Column(name = "SourceStoreId")
    private Integer sourceStoreId;
    @Column(name = "TargetStoreId")
    private Integer targetStoreId;
    @Column(name = "SourceStoreCode")
    private String sourceStoreCode;
    @Column(name = "TargetStoreCode")
    private String targetStoreCode;
}

