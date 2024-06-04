package vn.com.gsoft.categories.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.parameters.P;
import vn.com.gsoft.categories.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.gsoft.categories.model.dto.NhaCungCapsReq;
import vn.com.gsoft.categories.model.dto.PhieuNhapNoDauKyRes;

import java.util.List;

@Repository
public interface NhaCungCapsRepository extends BaseRepository<NhaCungCaps, NhaCungCapsReq, Long> {
  @Query("SELECT c FROM NhaCungCaps c " +
         "WHERE 1=1 "
          + " AND (:#{#param.tenNhaCungCap} IS NULL OR lower(c.tenNhaCungCap) LIKE lower(concat('%',CONCAT(:#{#param.tenNhaCungCap},'%'))))"
          + " AND (:#{#param.diaChi} IS NULL OR lower(c.diaChi) LIKE lower(concat('%',CONCAT(:#{#param.diaChi},'%'))))"
          + " AND (:#{#param.soDienThoai} IS NULL OR lower(c.soDienThoai) LIKE lower(concat('%',CONCAT(:#{#param.soDienThoai},'%'))))"
          + " AND (:#{#param.soFax} IS NULL OR lower(c.soFax) LIKE lower(concat('%',CONCAT(:#{#param.soFax},'%'))))"
          + " AND (:#{#param.maSoThue} IS NULL OR lower(c.maSoThue) LIKE lower(concat('%',CONCAT(:#{#param.maSoThue},'%'))))"
          + " AND (:#{#param.nguoiDaiDien} IS NULL OR lower(c.nguoiDaiDien) LIKE lower(concat('%',CONCAT(:#{#param.nguoiDaiDien},'%'))))"
          + " AND (:#{#param.nguoiLienHe} IS NULL OR lower(c.nguoiLienHe) LIKE lower(concat('%',CONCAT(:#{#param.nguoiLienHe},'%'))))"
          + " AND (:#{#param.email} IS NULL OR lower(c.email) LIKE lower(concat('%',CONCAT(:#{#param.email},'%'))))"
          + " AND (:#{#param.noDauKy} IS NULL OR c.noDauKy = :#{#param.noDauKy}) "
          + " AND (:#{#param.maNhaThuoc} IS NULL OR c.maNhaThuoc = :#{#param.maNhaThuoc}) "
          + " AND (:#{#param.maNhomNhaCungCap} IS NULL OR c.maNhomNhaCungCap = :#{#param.maNhomNhaCungCap}) "
          + " AND (:#{#param.createdByUserId} IS NULL OR c.createdByUserId = :#{#param.createdByUserId}) "
          + " AND (:#{#param.modifiedByUserId} IS NULL OR c.modifiedByUserId = :#{#param.modifiedByUserId}) "
          + " AND (:#{#param.supplierTypeId} IS NULL OR c.supplierTypeId = :#{#param.supplierTypeId}) "
          + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
          + " AND (:#{#param.barcode} IS NULL OR lower(c.barCode) LIKE lower(concat('%',CONCAT(:#{#param.barcode},'%'))))"
          + " AND (:#{#param.diaBanHoatDong} IS NULL OR lower(c.diaBanHoatDong) LIKE lower(concat('%',CONCAT(:#{#param.diaBanHoatDong},'%'))))"
          + " AND (:#{#param.website} IS NULL OR lower(c.website) LIKE lower(concat('%',CONCAT(:#{#param.website},'%'))))"
          + " AND (:#{#param.archivedId} IS NULL OR c.archivedId = :#{#param.archivedId}) "
          + " AND (:#{#param.referenceId} IS NULL OR c.referenceId = :#{#param.referenceId}) "
          + " AND (:#{#param.storeId} IS NULL OR c.storeId = :#{#param.storeId}) "
          + " AND (:#{#param.masterId} IS NULL OR c.masterId = :#{#param.masterId}) "
          + " AND (:#{#param.metadataHash} IS NULL OR c.metadataHash = :#{#param.metadataHash}) "
          + " AND (:#{#param.preMetadataHash} IS NULL OR c.preMetadataHash = :#{#param.preMetadataHash}) "
          + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
          + " AND (:#{#param.mappingStoreId} IS NULL OR c.mappingStoreId = :#{#param.mappingStoreId}) "
          + " AND (:#{#param.isOrganization} IS NULL OR c.isOrganization = :#{#param.isOrganization}) "
          + " ORDER BY c.created desc"
  )
  Page<NhaCungCaps> searchPage(@Param("param") NhaCungCapsReq param, Pageable pageable);
  
  
  @Query("SELECT c FROM NhaCungCaps c " +
         "WHERE 1=1 "
          + " AND (:#{#param.tenNhaCungCap} IS NULL OR lower(c.tenNhaCungCap) LIKE lower(concat('%',CONCAT(:#{#param.tenNhaCungCap},'%'))))"
          + " AND (:#{#param.diaChi} IS NULL OR lower(c.diaChi) LIKE lower(concat('%',CONCAT(:#{#param.diaChi},'%'))))"
          + " AND (:#{#param.soDienThoai} IS NULL OR lower(c.soDienThoai) LIKE lower(concat('%',CONCAT(:#{#param.soDienThoai},'%'))))"
          + " AND (:#{#param.soFax} IS NULL OR lower(c.soFax) LIKE lower(concat('%',CONCAT(:#{#param.soFax},'%'))))"
          + " AND (:#{#param.maSoThue} IS NULL OR lower(c.maSoThue) LIKE lower(concat('%',CONCAT(:#{#param.maSoThue},'%'))))"
          + " AND (:#{#param.nguoiDaiDien} IS NULL OR lower(c.nguoiDaiDien) LIKE lower(concat('%',CONCAT(:#{#param.nguoiDaiDien},'%'))))"
          + " AND (:#{#param.nguoiLienHe} IS NULL OR lower(c.nguoiLienHe) LIKE lower(concat('%',CONCAT(:#{#param.nguoiLienHe},'%'))))"
          + " AND (:#{#param.email} IS NULL OR lower(c.email) LIKE lower(concat('%',CONCAT(:#{#param.email},'%'))))"
          + " AND (:#{#param.noDauKy} IS NULL OR c.noDauKy = :#{#param.noDauKy}) "
          + " AND (:#{#param.maNhaThuoc} IS NULL OR c.maNhaThuoc = :#{#param.maNhaThuoc}) "
          + " AND (:#{#param.maNhomNhaCungCap} IS NULL OR c.maNhomNhaCungCap = :#{#param.maNhomNhaCungCap}) "
          + " AND (:#{#param.createdByUserId} IS NULL OR c.createdByUserId = :#{#param.createdByUserId}) "
          + " AND (:#{#param.modifiedByUserId} IS NULL OR c.modifiedByUserId = :#{#param.modifiedByUserId}) "
          + " AND (:#{#param.supplierTypeId} IS NULL OR c.supplierTypeId = :#{#param.supplierTypeId}) "
          + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
          + " AND (:#{#param.barcode} IS NULL OR lower(c.barCode) LIKE lower(concat('%',CONCAT(:#{#param.barcode},'%'))))"
          + " AND (:#{#param.diaBanHoatDong} IS NULL OR lower(c.diaBanHoatDong) LIKE lower(concat('%',CONCAT(:#{#param.diaBanHoatDong},'%'))))"
          + " AND (:#{#param.website} IS NULL OR lower(c.website) LIKE lower(concat('%',CONCAT(:#{#param.website},'%'))))"
          + " AND (:#{#param.archivedId} IS NULL OR c.archivedId = :#{#param.archivedId}) "
          + " AND (:#{#param.referenceId} IS NULL OR c.referenceId = :#{#param.referenceId}) "
          + " AND (:#{#param.storeId} IS NULL OR c.storeId = :#{#param.storeId}) "
          + " AND (:#{#param.masterId} IS NULL OR c.masterId = :#{#param.masterId}) "
          + " AND (:#{#param.metadataHash} IS NULL OR c.metadataHash = :#{#param.metadataHash}) "
          + " AND (:#{#param.preMetadataHash} IS NULL OR c.preMetadataHash = :#{#param.preMetadataHash}) "
          + " AND (:#{#param.code} IS NULL OR lower(c.code) LIKE lower(concat('%',CONCAT(:#{#param.code},'%'))))"
          + " AND (:#{#param.mappingStoreId} IS NULL OR c.mappingStoreId = :#{#param.mappingStoreId}) "
          + " AND (:#{#param.isOrganization} IS NULL OR c.isOrganization = :#{#param.isOrganization}) "
          + " ORDER BY c.created desc"
  )
  List<NhaCungCaps> searchList(@Param("param") NhaCungCapsReq param);
  //kiem tra ten nha cung cap da ton tai chua
  @Query(value = "SELECT c.Id FROM NhaCungCaps c WHERE 1=1" +
          " AND c.MaNhaThuoc = :storeCode AND c.TenNhaCungCap = :name" +
          " AND (:id IS NULL OR c.Id != :id)" +
          " AND c.RecordStatusId != 3"
          , nativeQuery = true)
  List<Long> findNhaCungCapByName(@Param("storeCode") String storeCode, @Param("name") String name,
                                  @Param("id") Long id);
  //kiem tra barcode nha cung cap da ton tai chua
  @Query(value = "SELECT c.Id FROM NhaCungCaps c WHERE 1=1" +
          " AND c.MaNhaThuoc = :storeCode AND c.Barcode = :barcode" +
          " AND (:id IS NULL OR c.Id != :id)" +
          " AND c.RecordStatusId != 3"
          , nativeQuery = true)
  List<Long> findNhaCungCapByBarcode(@Param("storeCode") String storeCode, @Param("barcode") String name,
                                  @Param("id") Long id);
  //kiem tra code nhà cung cấp da ton tai chua
  @Query(value = "SELECT c.Id FROM NhaCungCaps c WHERE 1=1" +
          " AND c.MaNhaThuoc = :storeCode AND c.Code = :code" +
          " AND (:id IS NULL OR c.Id != :id)" +
          " AND c.RecordStatusId != 3"
          , nativeQuery = true)
  List<Long> findNhaCungCapByCode(@Param("storeCode") String storeCode, @Param("code") String name,
                                  @Param("id") Long id);
  //kiểm tra đã có giao dịch nhập chưa
  @Query(value = "SELECT c.Id FROM PhieuNhaps c WHERE c.NhaThuoc_MaNhaThuoc = :storeCode" +
          " AND c.NhaCungCap_MaNhaCungCap = :id AND c.RecordStatusId != 3",
  nativeQuery = true)
  List<Long> findPhieuNhapByMaNhaCungCap(@Param("storeCode") String storeCode, @Param("id") Long id);
  //kiểm tra đã có giao dịch trả hàng chưa
  @Query(value = "SELECT c.Id FROM PhieuXuats c WHERE c.NhaThuoc_MaNhaThuoc = :storeCode" +
          " AND c.NhaCungCap_MaNhaCungCap = :id AND c.RecordStatusId != 3",
          nativeQuery = true)
  List<Long> findPhieuTraHangByMaNhaCungCap(@Param("storeCode") String storeCode, @Param("id") Long id);
}
