package vn.com.gsoft.categories.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.TransitionFrom;
import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.util.Date;
import java.util.List;

@Data
public class RewardProgramSupplierRes {

    private Long id;

    private Integer supplierId;

    private String content;

    private Date fromDate;

    private Date toDate;
    @TransitionFrom
    private List<PhieuThuKhacReq> items;
}
