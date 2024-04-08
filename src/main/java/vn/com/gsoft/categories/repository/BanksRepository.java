package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.Banks;
import vn.com.gsoft.categories.model.dto.BanksReq;

import java.util.List;

@Repository
public interface BanksRepository extends BaseRepository<Banks, BanksReq, Long> {
    @Query("SELECT c FROM Banks c " +
            "WHERE 1=1 "
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.id desc"
    )
    Page<Banks> searchPage(@Param("param") BanksReq param, Pageable pageable);


    @Query("SELECT c FROM Banks c " +
            "WHERE 1=1 "
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.id desc"
    )
    List<Banks> searchList(@Param("param") BanksReq param);
}
