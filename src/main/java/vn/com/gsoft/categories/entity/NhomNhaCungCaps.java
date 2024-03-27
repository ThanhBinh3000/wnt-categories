package vn.com.gsoft.categories.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "NhomNhaCungCaps")
public class NhomNhaCungCaps extends BaseEntity {

    @Id
    @Column(name="id")
    private Long id;
    private String tenNhomNhaCungCap;
    private String ghiChu;
    private String maNhaThuoc;
    private Boolean active;
    private Boolean isDefault;
    private Long recordStatusID;
    private Long archivedId;
    private Long storeId;


}
