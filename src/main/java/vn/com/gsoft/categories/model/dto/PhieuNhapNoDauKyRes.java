package vn.com.gsoft.categories.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class PhieuNhapNoDauKyRes {
    private String maNhaThuoc;
    private Long maNhaCungCap;
    private Date ngayNhap;
    private Date created ;
    private Long createdByUserId;
    private Long recordStatusId;
    private Boolean isDebt;
    private BigDecimal tongTien;
    private Long loaiXuatNhap_MaLoaiXuatNhap;
    private Long storeId;
    private Long modifiedByUserId;
    private Date modified;
    private Long id;
}
