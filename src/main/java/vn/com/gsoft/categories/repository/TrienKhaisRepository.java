package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.TrienKhais;
import vn.com.gsoft.categories.model.dto.TrienKhaisReq;

import java.util.List;

@Repository
public interface TrienKhaisRepository extends BaseRepository<TrienKhais, TrienKhaisReq, Long> {
  @Query("SELECT c FROM TrienKhais c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.maNhaThuoc} IS NULL OR c.maNhaThuoc = :#{#param.maNhaThuoc}) "
          + " AND (:#{#param.tieuChiTrienKhaiId} IS NULL OR c.tieuChiTrienKhaiId = :#{#param.tieuChiTrienKhaiId}) "
          + " AND (:#{#param.active} IS NULL OR c.active = :#{#param.active}) "
          + " ORDER BY c.id asc"
  )
  Page<TrienKhais> searchPage(@Param("param") TrienKhaisReq param, Pageable pageable);
  
  
  @Query("SELECT c FROM TrienKhais c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.maNhaThuoc} IS NULL OR c.maNhaThuoc = :#{#param.maNhaThuoc}) "
          + " AND (:#{#param.tieuChiTrienKhaiId} IS NULL OR c.tieuChiTrienKhaiId = :#{#param.tieuChiTrienKhaiId}) "
          + " AND (:#{#param.active} IS NULL OR c.active = :#{#param.active}) "
          + " ORDER BY c.id asc"
  )
  List<TrienKhais> searchList(@Param("param") TrienKhaisReq param);

}
