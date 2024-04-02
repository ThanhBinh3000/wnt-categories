package vn.com.gsoft.categories.repository;

import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomKhachHangs;
import vn.com.gsoft.categories.model.dto.NhomKhachHangsReq;

import java.util.List;

@Repository
public interface NhomKhachHangsRepository extends BaseRepository<NhomKhachHangs, NhomKhachHangsReq, Long> {
//    List<NhaThuocs> findByUserId(Long id);

    @Query("SELECT c FROM NhomKhachHangs c " +
            "WHERE 1=1 "
            + " AND (:#{#param.tenNhomKhachHang} IS NULL OR lower(c.tenNhomKhachHang) LIKE lower(concat('%',CONCAT(:#{#param.tenNhomKhachHang},'%'))))"
            + " AND (:#{#param.ghiChu} IS NULL OR lower(c.ghiChu) LIKE lower(concat('%',CONCAT(:#{#param.ghiChu},'%'))))"
            + " AND (:#{#param.nhaThuocMaNhaThuoc} IS NULL OR lower(c.nhaThuocMaNhaThuoc) LIKE lower(concat('%',CONCAT(:#{#param.nhaThuocMaNhaThuoc},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " AND (:#{#param.groupTypeId} IS NULL OR c.groupTypeId = :#{#param.groupTypeId}) "
            + " AND (:#{#param.fullName} IS NULL OR lower(c.fullName) LIKE lower(concat('%',CONCAT(:#{#param.fullName},'%'))))"
            + " AND (:#{#param.idCard} IS NULL OR lower(c.idCard) LIKE lower(concat('%',CONCAT(:#{#param.idCard},'%'))))"
            + " AND (:#{#param.classId} IS NULL OR lower(c.classId) LIKE lower(concat('%',CONCAT(:#{#param.classId},'%'))))"
            + " AND (:#{#param.mobile} IS NULL OR lower(c.mobile) LIKE lower(concat('%',CONCAT(:#{#param.mobile},'%'))))"
            + " AND (:#{#param.archivedId} IS NULL OR c.archivedId = :#{#param.archivedId}) "
            + " AND (:#{#param.storeId} IS NULL OR c.storeId = :#{#param.storeId}) "
            + " ORDER BY c.tenNhomKhachHang desc"
    )
    Page<NhomKhachHangs> searchPage(@org.springframework.data.repository.query.Param("param") NhomKhachHangsReq param, Pageable pageable);


    @Query("SELECT c FROM NhomKhachHangs c " +
            "WHERE 1=1 "
            + " AND (:#{#param.tenNhomKhachHang} IS NULL OR lower(c.tenNhomKhachHang) LIKE lower(concat('%',CONCAT(:#{#param.tenNhomKhachHang},'%'))))"
            + " AND (:#{#param.ghiChu} IS NULL OR lower(c.ghiChu) LIKE lower(concat('%',CONCAT(:#{#param.ghiChu},'%'))))"
            + " AND (:#{#param.nhaThuocMaNhaThuoc} IS NULL OR lower(c.nhaThuocMaNhaThuoc) LIKE lower(concat('%',CONCAT(:#{#param.nhaThuocMaNhaThuoc},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " AND (:#{#param.groupTypeId} IS NULL OR c.groupTypeId = :#{#param.groupTypeId}) "
            + " AND (:#{#param.fullName} IS NULL OR lower(c.fullName) LIKE lower(concat('%',CONCAT(:#{#param.fullName},'%'))))"
            + " AND (:#{#param.idCard} IS NULL OR lower(c.idCard) LIKE lower(concat('%',CONCAT(:#{#param.idCard},'%'))))"
            + " AND (:#{#param.classId} IS NULL OR lower(c.classId) LIKE lower(concat('%',CONCAT(:#{#param.classId},'%'))))"
            + " AND (:#{#param.mobile} IS NULL OR lower(c.mobile) LIKE lower(concat('%',CONCAT(:#{#param.mobile},'%'))))"
            + " AND (:#{#param.archivedId} IS NULL OR c.archivedId = :#{#param.archivedId}) "
            + " AND (:#{#param.storeId} IS NULL OR c.storeId = :#{#param.storeId}) "
            + " ORDER BY c.tenNhomKhachHang desc"
    )
    List<NhomKhachHangs> searchList(@org.springframework.data.repository.query.Param("param") NhomKhachHangsReq param);



}
