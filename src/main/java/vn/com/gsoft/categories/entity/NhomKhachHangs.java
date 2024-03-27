package vn.com.gsoft.categories.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "NhomKhachHangs")
public class NhomKhachHangs extends BaseEntity {

    @Id
    @Column(name="id")
    private Long id;
    private String tenNhomKhachHang;
    private String ghiChu;
    @Column(name="NhaThuoc_MaNhaThuoc")
    private String nhaThuocMaNhaThuoc;
    private Boolean active;
    private Long recordStatusID;
    private Long groupTypeId;
    private String fullName;
    private String idCard;
    private Date birthDate;
    private String classId;
    private String mobile;
    private Long archivedId;
    private Long storeId;




}
