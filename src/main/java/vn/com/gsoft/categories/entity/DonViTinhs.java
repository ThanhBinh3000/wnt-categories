package vn.com.gsoft.categories.entity;

import jakarta.persistence.Column;
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
@Table(name = "DonViTinhs")
public class DonViTinhs {
    @Id
    @Column(name = "MaDonViTinh")
    private Integer maDonViTinh;
    @Column(name = "TenDonViTinh")
    private String tenDonViTinh;
    @Column(name = "MaNhaThuoc")
    private String maNhaThuoc;
    @Column(name = "ReferenceId")
    private Integer referenceId;
    @Column(name = "ArchivedId")
    private Integer archivedId;
    @Column(name = "StoreId")
    private Integer storeId;
}

