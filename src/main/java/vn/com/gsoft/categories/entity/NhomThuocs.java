package vn.com.gsoft.categories.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "NhomThuocs")
public class NhomThuocs extends BaseEntity {

    @Id
    private Long maNhomThuoc;
    private String tenNhomThuoc;
    private String kyHieuNhomThuoc;
    private String maNhaThuoc;
    private Boolean active;
    private Boolean referenceId;
    private Long archivedId;
    private Long storeId;
    private Long typeGroupProduct;



}
