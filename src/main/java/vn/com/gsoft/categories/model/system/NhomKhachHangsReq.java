package vn.com.gsoft.categories.model.system;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class NhomKhachHangsReq extends BaseRequest {

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
