package vn.com.gsoft.categories.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.RewardProgramSupplier;
import vn.com.gsoft.categories.model.dto.RewardProgramSupplierReq;

import java.util.List;

@Repository
public interface RewardProgramSupplierRepository extends BaseRepository<RewardProgramSupplier, RewardProgramSupplierReq, Long> {
    @Query("SELECT c FROM RewardProgramSupplier c " +
            "WHERE 1=1 "
    )
    Page<RewardProgramSupplier> searchPage(@Param("param") RewardProgramSupplierReq param, Pageable pageable);
    @Query("SELECT c FROM RewardProgramSupplier c " +
            "WHERE 1=1 "
    )
    List<RewardProgramSupplier> searchList(@Param("param") RewardProgramSupplierReq param);
      @Query(value = "SELECT c.Id AS id, c.SupplierId AS supplierId, c.Content AS content," +
          " c.FromDate AS fromDate, c.ToDate AS toDate, NULL AS items" +
          " FROM RewardProgramSupplier c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.Id =:#{#param.id})"
          + " AND (:#{#param.SupplierId} IS NULL OR c.SupplierId =:#{#param.supplierId})"
          + " AND (:#{#param.storeCode} IS NULL OR c.StoreCode =:#{#param.storeCode})"
          + " AND (:#{#param.fromDate} IS NULL OR c.FromDate >=:#{#param.fromDate})"
          + " AND (:#{#param.toDate} IS NULL OR c.ToDate <=:#{#param.toDate})"
          + " AND (:#{#param.recordStatusId} IS NULL OR c.RecordStatusId =:#{#param.recordStatusId})"
          + " ORDER BY c.Created desc",
          nativeQuery = true
    )
    List<Tuple> searchListManagement(@Param("param") RewardProgramSupplierReq param);

      //lấy ra danh sách phiếu thu khác
    @Query(value = "SELECT c.id AS id, c.RewardProgramId AS rewardProgramId," +
            " c.Amount AS amount, c.Description AS description," +
            " c.SoPhieu AS noteNumber, c.NgayTao AS noteDate" +
            " FROM PhieuThuChis c" +
            " WHERE 1=1" +
            " AND c.NhaThuoc_MaNhaThuoc = :storeCode" +
            " AND c.NhaCungCap_MaNhaCungCap in (:supplierIds)" +
            " AND c.LoaiPhieu = 3", nativeQuery = true)
    List<Tuple> findPhieuThuKhacByMaNhaCungCap(@Param("storeCode") String storeCode,
                                               @Param("supplierIds") Long[] supplierId);

}
