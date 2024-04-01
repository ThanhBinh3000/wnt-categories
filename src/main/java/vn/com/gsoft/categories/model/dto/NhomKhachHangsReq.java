package vn.com.gsoft.categories.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.util.Date;

@Data
public class NhomKhachHangsReq extends BaseRequest {

    private String tenNhomKhachHang;
    private String ghiChu;
    private String nhaThuocMaNhaThuoc;
    private Boolean active;
    private Long groupTypeId;
    private String fullName;
    private String idCard;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date birthDate;
    private String classId;
    private String mobile;
    private Long archivedId;
    private Long storeId;




}
