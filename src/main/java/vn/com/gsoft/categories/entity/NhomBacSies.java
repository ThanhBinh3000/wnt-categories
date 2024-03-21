package vn.com.gsoft.categories.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "NhomBacSies")
public class NhomBacSies extends BaseEntity {

    @Id
    private String maNhomBacSy;
    private String tenNhomBacSy;
    private String ghiChu;
    private String maNhaThuoc;
    private Long recordStatusID;


}
