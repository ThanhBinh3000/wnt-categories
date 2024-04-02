package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;

import java.util.List;

@Repository
public interface NhomBacSiesRepository extends BaseRepository<NhomBacSies, NhomBacSiesReq, Long> {

    @Query("SELECT c FROM NhomBacSies c " +
            "WHERE 1=1 "
            + " AND (:#{#param.tenNhomBacSy} IS NULL OR lower(c.tenNhomBacSy) LIKE lower(concat('%',CONCAT(:#{#param.tenNhomBacSy},'%'))))"
            + " AND (:#{#param.ghiChu} IS NULL OR lower(c.ghiChu) LIKE lower(concat('%',CONCAT(:#{#param.ghiChu},'%'))))"
            + " AND (:#{#param.maNhaThuoc} IS NULL OR lower(c.maNhaThuoc) LIKE lower(concat('%',CONCAT(:#{#param.maNhaThuoc},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.tenNhomBacSy desc"
    )
    Page<NhomBacSies> searchPage(@org.springframework.data.repository.query.Param("param") NhomBacSiesReq param, Pageable pageable);


    @Query("SELECT c FROM NhomBacSies c " +
            "WHERE 1=1 "
            + " AND (:#{#param.tenNhomBacSy} IS NULL OR lower(c.tenNhomBacSy) LIKE lower(concat('%',CONCAT(:#{#param.tenNhomBacSy},'%'))))"
            + " AND (:#{#param.ghiChu} IS NULL OR lower(c.ghiChu) LIKE lower(concat('%',CONCAT(:#{#param.ghiChu},'%'))))"
            + " AND (:#{#param.maNhaThuoc} IS NULL OR lower(c.maNhaThuoc) LIKE lower(concat('%',CONCAT(:#{#param.maNhaThuoc},'%'))))"
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.tenNhomBacSy desc"
    )
    List<NhomBacSies> searchList(@Param("param") NhomBacSiesReq param);

}
