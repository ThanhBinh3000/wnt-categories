package vn.com.gsoft.categories.repository;

import vn.com.gsoft.categories.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.gsoft.categories.model.dto.CitiesReq;

import java.util.List;

@Repository
public interface CitiesRepository extends BaseRepository<Cities, CitiesReq, Long> {
  @Query("SELECT c FROM Cities c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.regionId} IS NULL OR c.regionId = :#{#param.regionId}) "
          + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
          + " ORDER BY c.id desc"
  )
  Page<Cities> searchPage(@Param("param") CitiesReq param, Pageable pageable);
  
  
  @Query("SELECT c FROM Cities c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.regionId} IS NULL OR c.regionId = :#{#param.regionId}) "
          + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
          + " ORDER BY c.id desc"
  )
  List<Cities> searchList(@Param("param") CitiesReq param);

}
