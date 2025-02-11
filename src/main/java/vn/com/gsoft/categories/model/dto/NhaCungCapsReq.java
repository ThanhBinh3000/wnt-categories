package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class NhaCungCapsReq extends BaseRequest {
    private String tenNhaCungCap;
    private String diaChi;
    private String soDienThoai;
    private String soFax;
    private String maSoThue;
    private String nguoiDaiDien;
    private String nguoiLienHe;
    private String email;
    private BigDecimal noDauKy;
    private String maNhaThuoc;
    private Integer maNhomNhaCungCap;
    private Date created;
    private Date modified;
    private Integer createdByUserId;
    private Integer modifiedByUserId;
    private Boolean active;
    private Integer supplierTypeId;
    private Long recordStatusId;
    private String barcode;
    private String diaBanHoatDong;
    private String website;
    private Integer archivedId;
    private Integer referenceId;
    private Integer storeId;
    private Integer masterId;
    private Integer metadataHash;
    private Integer preMetadataHash;
    private String code;
    private Integer mappingStoreId;
    private Integer isOrganization;
    private Boolean dataDelete;
}

