package vn.com.gsoft.categories.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PhieuThuKhacReq extends BaseRequest {

    private Long id;

    private Integer rewardProgramId;

    private BigDecimal amount;

    private String description;

    private Integer noteNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date noteDate;
}
