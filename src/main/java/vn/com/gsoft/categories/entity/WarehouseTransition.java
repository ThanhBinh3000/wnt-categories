package vn.com.gsoft.categories.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "WarehouseTransition")
public class WarehouseTransition extends BaseEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "DeliveryNoteId")
    private Long deliveryNoteId;
    @Column(name = "ReceiptNoteId")
    private Long receiptNoteId;
    @Column(name = "CreatedDateTime")
    private Date createdDateTime;
    @Column(name = "SourceStoreId")
    private Long sourceStoreId;
    @Column(name = "TargetStoreId")
    private Long targetStoreId;
    @Column(name = "SourceStoreCode")
    private String sourceStoreCode;
    @Column(name = "TargetStoreCode")
    private String targetStoreCode;
}

