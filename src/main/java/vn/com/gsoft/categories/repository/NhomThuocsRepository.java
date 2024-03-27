package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomThuocs;
import vn.com.gsoft.categories.model.dto.NhomThuocsReq;


import java.util.List;

@Repository
public interface NhomThuocsRepository extends BaseRepository<NhomThuocs, NhomThuocsReq, Long> {
//    List<NhaThuocs> findByUserId(Long id);

    @Query("SELECT c FROM NhomThuocs c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.tenNhomThuoc} IS NULL OR lower(c.tenNhomThuoc) LIKE lower(concat('%',CONCAT(:#{#param.tenNhomThuoc},'%'))))"
            + " AND (:#{#param.kyHieuNhomThuoc} IS NULL OR lower(c.kyHieuNhomThuoc) LIKE lower(concat('%',CONCAT(:#{#param.kyHieuNhomThuoc},'%'))))"
            + " AND (:#{#param.maNhaThuoc} IS NULL OR lower(c.maNhaThuoc) LIKE lower(concat('%',CONCAT(:#{#param.maNhaThuoc},'%'))))"
//            + " AND (:#{#param.created} IS NULL OR c.created >= :#{#param.createdFrom}) "
//            + " AND (:#{#param.created} IS NULL OR c.created <= :#{#param.createdTo}) "
//            + " AND (:#{#param.modified} IS NULL OR c.modified >= :#{#param.modifiedFrom}) "
//            + " AND (:#{#param.modified} IS NULL OR c.modified <= :#{#param.modifiedTo}) "
//            + " AND (:#{#param.createdByUserId} IS NULL OR c.createdByUserId = :#{#param.createdByUserId}) "
//            + " AND (:#{#param.modifiedByUserId} IS NULL OR c.modifiedByUserId = :#{#param.modifiedByUserId}) "
            + " AND (:#{#param.referenceId} IS NULL OR c.referenceId = :#{#param.referenceId}) "
            + " AND (:#{#param.archivedId} IS NULL OR c.archivedId = :#{#param.archivedId}) "
            + " AND (:#{#param.storeId} IS NULL OR c.storeId = :#{#param.storeId}) "
            + " AND (:#{#param.typeGroupProduct} IS NULL OR c.typeGroupProduct = :#{#param.typeGroupProduct}) "
            + " ORDER BY c.id desc"
    )
    Page<NhomThuocs> searchPage(@Param("param") NhomThuocsReq param, Pageable pageable);


    @Query("SELECT c FROM NhomThuocs c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.tenNhomThuoc} IS NULL OR lower(c.tenNhomThuoc) LIKE lower(concat('%',CONCAT(:#{#param.tenNhomThuoc},'%'))))"
            + " AND (:#{#param.kyHieuNhomThuoc} IS NULL OR lower(c.kyHieuNhomThuoc) LIKE lower(concat('%',CONCAT(:#{#param.kyHieuNhomThuoc},'%'))))"
            + " AND (:#{#param.maNhaThuoc} IS NULL OR lower(c.maNhaThuoc) LIKE lower(concat('%',CONCAT(:#{#param.maNhaThuoc},'%'))))"
//            + " AND (:#{#param.created} IS NULL OR c.created >= :#{#param.createdFrom}) "
//            + " AND (:#{#param.created} IS NULL OR c.created <= :#{#param.createdTo}) "
//            + " AND (:#{#param.modified} IS NULL OR c.modified >= :#{#param.modifiedFrom}) "
//            + " AND (:#{#param.modified} IS NULL OR c.modified <= :#{#param.modifiedTo}) "
//            + " AND (:#{#param.createdByUserId} IS NULL OR c.createdByUserId = :#{#param.createdByUserId}) "
//            + " AND (:#{#param.modifiedByUserId} IS NULL OR c.modifiedByUserId = :#{#param.modifiedByUserId}) "
            + " AND (:#{#param.referenceId} IS NULL OR c.referenceId = :#{#param.referenceId}) "
            + " AND (:#{#param.archivedId} IS NULL OR c.archivedId = :#{#param.archivedId}) "
            + " AND (:#{#param.storeId} IS NULL OR c.storeId = :#{#param.storeId}) "
            + " AND (:#{#param.typeGroupProduct} IS NULL OR c.typeGroupProduct = :#{#param.typeGroupProduct}) "
            + " ORDER BY c.id desc"
    )
    List<NhomThuocs> searchList(@Param("param") NhomThuocsReq param);

}
