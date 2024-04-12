package vn.com.gsoft.categories.repository;

import vn.com.gsoft.categories.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.gsoft.categories.model.dto.AreaProvinceReq;

import java.util.List;

@Repository
public interface AreaProvinceRepository extends BaseRepository<AreaProvince, AreaProvinceReq, Long> {
  @Query("SELECT c FROM AreaProvince c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.areaId} IS NULL OR c.areaId = :#{#param.areaId}) "
          + " AND (:#{#param.provinceId} IS NULL OR c.provinceId = :#{#param.provinceId}) "
          + " ORDER BY c.id desc"
  )
  Page<AreaProvince> searchPage(@Param("param") AreaProvinceReq param, Pageable pageable);
  
  
  @Query("SELECT c FROM AreaProvince c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.areaId} IS NULL OR c.areaId = :#{#param.areaId}) "
          + " AND (:#{#param.provinceId} IS NULL OR c.provinceId = :#{#param.provinceId}) "
          + " ORDER BY c.id desc"
  )
  List<AreaProvince> searchList(@Param("param") AreaProvinceReq param);

}
