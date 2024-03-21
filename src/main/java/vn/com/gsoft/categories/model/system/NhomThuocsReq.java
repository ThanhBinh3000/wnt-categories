package vn.com.gsoft.categories.model.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import vn.com.gsoft.categories.entity.BaseEntity;

@Data
public class NhomThuocsReq extends BaseRequest {

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
