package vn.com.gsoft.categories.repository;

import vn.com.gsoft.categories.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.gsoft.categories.model.dto.AreaReq;

import java.util.List;

@Repository
public interface AreaRepository extends BaseRepository<Area, AreaReq, Long> {
    @Query("SELECT c FROM Area c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.areaCode} IS NULL OR lower(c.areaCode) LIKE lower(concat('%',CONCAT(:#{#param.areaCode},'%'))))"
            + " AND (:#{#param.areaName} IS NULL OR lower(c.areaName) LIKE lower(concat('%',CONCAT(:#{#param.areaName},'%'))))"
            + " ORDER BY c.id desc"
    )
    Page<Area> searchPage(@Param("param") AreaReq param, Pageable pageable);


    @Query("SELECT c FROM Area c " +
            "WHERE 1=1 "
            + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
            + " AND (:#{#param.areaCode} IS NULL OR lower(c.areaCode) LIKE lower(concat('%',CONCAT(:#{#param.areaCode},'%'))))"
            + " AND (:#{#param.areaName} IS NULL OR lower(c.areaName) LIKE lower(concat('%',CONCAT(:#{#param.areaName},'%'))))"
            + " ORDER BY c.id desc"
    )
    List<Area> searchList(@Param("param") AreaReq param);

}
