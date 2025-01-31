package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class NhaCungCapsRes{

    private Long id;
    private String tenNhaCungCap;
    private String diaChi;
    private String soDienThoai;
    private String tenNhomNhaCungCap;
    private String barcode;
    private String code;
}

