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
@Table(name = "WarehouseLocation")
public class WarehouseLocation extends BaseEntity {
    @Id
    @Column(name = "Id")
    private Long id;
    @Column(name = "Code")
    private String code;
    @Column(name = "NameWarehouse")
    private String nameWarehouse;
    @Column(name = "StoreCode")
    private String storeCode;
    @Column(name = "RecordStatusId")
    private Integer recordStatusId;
    @Column(name = "Descriptions")
    private String descriptions;
}

