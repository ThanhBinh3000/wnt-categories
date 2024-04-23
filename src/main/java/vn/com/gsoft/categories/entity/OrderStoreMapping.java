package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderStoreMapping")
public class OrderStoreMapping extends BaseEntity{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "TargetStoreCode")
    private String targetStoreCode;

    @Column(name = "IsDefault")
    private Boolean isDefault;

    @Column(name = "MappingTypeId")
    private Long mappingTypeId;

}
