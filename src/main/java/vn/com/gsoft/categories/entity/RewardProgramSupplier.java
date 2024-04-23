package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RewardProgramSupplier")
public class RewardProgramSupplier extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "SupplierId")
    private Integer supplierId;
    @Column(name = "Content")
    private String content;
    @Column(name = "FromDate")
    private Date fromDate;
    @Column(name = "ToDate")
    private Date toDate;
    @Column(name = "StoreCode")
    private String storeCode;
}
