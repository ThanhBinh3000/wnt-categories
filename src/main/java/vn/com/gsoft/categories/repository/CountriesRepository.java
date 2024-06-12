package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.Countries;
import vn.com.gsoft.categories.model.dto.CountriesReq;

import java.util.List;

@Repository
public interface CountriesRepository extends BaseRepository<Countries, CountriesReq, Long> {
  @Query("SELECT c FROM Countries c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.iso} IS NULL OR lower(c.iso) LIKE lower(concat('%',CONCAT(:#{#param.iso},'%'))))"
          + " AND (:#{#param.iso3} IS NULL OR lower(c.iso3) LIKE lower(concat('%',CONCAT(:#{#param.iso3},'%'))))"
          + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
          + " AND (:#{#param.numCode} IS NULL OR c.numCode = :#{#param.numCode}) "
          + " AND (:#{#param.phoneCode} IS NULL OR c.phoneCode = :#{#param.phoneCode}) "
          + " ORDER BY c.name asc"
  )
  Page<Countries> searchPage(@Param("param") CountriesReq param, Pageable pageable);
  
  
  @Query("SELECT c FROM Countries c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.iso} IS NULL OR lower(c.iso) LIKE lower(concat('%',CONCAT(:#{#param.iso},'%'))))"
          + " AND (:#{#param.iso3} IS NULL OR lower(c.iso3) LIKE lower(concat('%',CONCAT(:#{#param.iso3},'%'))))"
          + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
          + " AND (:#{#param.numCode} IS NULL OR c.numCode = :#{#param.numCode}) "
          + " AND (:#{#param.phoneCode} IS NULL OR c.phoneCode = :#{#param.phoneCode}) "
          + " ORDER BY c.name asc"
  )
  List<Countries> searchList(@Param("param") CountriesReq param);

}
