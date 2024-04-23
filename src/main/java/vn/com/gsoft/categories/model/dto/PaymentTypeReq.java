package vn.com.gsoft.categories.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class PaymentTypeReq {
    private Integer id;
    private String name;
    private String displayName;
    private Boolean visible;
}

