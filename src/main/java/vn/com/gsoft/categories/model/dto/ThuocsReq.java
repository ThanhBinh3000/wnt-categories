package vn.com.gsoft.categories.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.com.gsoft.categories.model.system.BaseRequest;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ThuocsReq extends BaseRequest {

    private String maThuoc;
    private String tenThuoc;
    private String thongTin;
    private Integer heSo;
    private BigDecimal giaNhap;
    private BigDecimal giaBanBuon;
    private BigDecimal giaBanLe;
    private BigDecimal soDuDauKy;
    private BigDecimal giaDauKy;
    private Integer gioiHan;
    private String nhaThuocMaNhaThuoc;
    private Integer nhomThuocMaNhomThuoc;
    private Integer nuocMaNuoc;
    private Integer dangBaoCheMaDangBaoChe;
    private Integer donViXuatLeMaDonViTinh;
    private Integer donViThuNguyenMaDonViTinh;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date created;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date modified;
    private Integer createdByUserId;
    private Integer modifiedByUserId;
    private String barCode;
    private Boolean hoatDong;
    private Boolean hangTuVan;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date hanDung;
    private Integer duTru;
    private Boolean active;
    private String nhaThuocMaNhaThuocCreate;
    private Integer recordStatusID;
    private Integer connectivityDrugID;
    private BigDecimal connectivityDrugFactor;
    private Integer maNhaCungCap;
    private Integer parentDrugId;
    private Integer metadataHash;
    private Integer rpMetadataHash;
    private Integer referenceId;
    private BigDecimal discount;
    private Boolean discountByRevenue;
    private Integer saleTypeId;
    private BigDecimal saleOff;
    private String saleDescription;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date saleStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date saleEndDate;
    private Boolean scorable;
    private String imageThumbUrl;
    private String imagePreviewUrl;
    private Integer connectivityTypeId;
    private Integer archivedId;
    private Integer storeId;
    private Integer productTypeId;
    private String serialNumber;
    private BigDecimal moneyToOneScoreRate;
    private Boolean presentation;
    private Long nameHash;
    private String registeredNo;
    private String activeSubstance;
    private String contents;
    private String packingWay;
    private String manufacturer;
    private String countryOfManufacturer;
    private Integer countryId;
    private String connectivityId;
    private String connectivityResult;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date connectivityDateTime;
    private String dosageForms;
    private String smallestPackingUnit;
    private String importers;
    private BigDecimal declaredPrice;
    private String connectivityCode;
    private Long codeHash;
    private Integer connectivityStatusId;
    private String organizeDeclaration;
    private String countryRegistration;
    private String addressRegistration;
    private String addressManufacture;
    private String identifier;
    private String classification;
    private Integer forWholesale;
    private String hoatChat;
    private Integer typeService;
    private Integer typeServices;
    private Integer idTypeService;
    private Integer idClinic;
    private Integer countNumbers;
    private Integer idWarehouseLocation;
    private String hamLuong;
    private String quyCachDongGoi;
    private String nhaSanXuat;
    private String advantages;
    private String userObject;
    private String userManual;
    private String pharmacokinetics;
    private Boolean isShowCustomerWebsite;
    private Boolean flag;
    private Integer groupIdMapping;
    private String groupNameMapping;
    private String resultService;
    private String titleResultService;
    private Integer typeResultService;
    private Integer groupIdMappingV2;
    private String storageConditions;
    private String storageLocation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date mappingDate;
    private String chiDinh;
    private String chongChiDinh;
    private String xuatXu;
    private String luuY;
    private BigDecimal promotionalDiscounts;
    private Boolean enablePromotionalDiscounts;
    private String descriptionOnWebsite;
    private Integer imgReferenceDrugId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date userUploadImgDate;
    private Integer userUploadImgId;
    private Integer statusConfirm;
    private Integer userIdConfirm;
    private Integer userIdMapping;
}

