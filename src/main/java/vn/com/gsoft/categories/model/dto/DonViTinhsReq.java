package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import vn.com.gsoft.categories.model.system.BaseRequest;


@Data
public class DonViTinhsReq extends BaseRequest {
    private String tenDonViTinh;
    private String maNhaThuoc;
    private Integer referenceId;
    private Integer archivedId;
    private Integer storeId;
}

