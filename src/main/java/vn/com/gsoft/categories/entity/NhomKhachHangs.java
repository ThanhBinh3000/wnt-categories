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
@Table(name = "NhomKhachHangsReq")
public class NhomKhachHangs extends BaseEntity {

    @Id
    private String maNhomKhachHang;
    private String tenNhomKhachHang;
    private String ghiChu;
    @Column(name="NhaThuoc_MaNhaThuoc")
    private String nhaThuocMaNhaThuoc;
    private Boolean active;
    private Long recordStatusID;
    private Long groupTypeId;
    private String fullName;
    private String idCard;
    private LocalDateTime birthDate;
    private String classId;
    private String mobile;
    private Long archivedId;
    private Long storeId;




}
