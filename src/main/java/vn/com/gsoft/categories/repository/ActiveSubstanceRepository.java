package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.ActiveSubstance;
import vn.com.gsoft.categories.model.dto.ActiveSubstanceReq;

import java.util.List;

@Repository
public interface ActiveSubstanceRepository extends BaseRepository<ActiveSubstance, ActiveSubstanceReq, Long> {
    @Query("SELECT c FROM ActiveSubstance c " +
            "WHERE 1=1 "
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.id desc"
    )
    Page<ActiveSubstance> searchPage(@Param("param") ActiveSubstanceReq param, Pageable pageable);


    @Query("SELECT c FROM ActiveSubstance c " +
            "WHERE 1=1 "
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.id desc"
    )
    List<ActiveSubstance> searchList(@Param("param") ActiveSubstanceReq param);
}
