package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.util.Date;

@Data
public class WarehouseLocationReq extends BaseRequest {
    private Long id;
    private String code;
    private String nameWarehouse;
    private String storeCode;
    private Date created;
    private Date modified;
    private Integer createBy;
    private Integer modifieBy;
    private Integer recordStatusId;
    private String descriptions;
}

