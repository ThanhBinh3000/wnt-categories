package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String tenNhomNhaCungCap;
    private String ghiChu;
    private String maNhaThuoc;
    private Boolean active;
    private Boolean isDefault;
    private Long archivedId;
    private Long storeId;


}
