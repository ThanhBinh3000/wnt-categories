package vn.com.gsoft.categories.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date created;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date modified;
    private Integer createBy;
    private Integer modifieBy;
    private Integer recordStatusId;
    private String descriptions;
}

