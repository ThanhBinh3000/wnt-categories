package vn.com.gsoft.categories.repository;

import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.entity.WarehouseLocation;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.dto.WarehouseLocationReq;

import java.util.List;

@Repository
public interface WarehouseLocationRepository extends BaseRepository<WarehouseLocation, WarehouseLocationReq, Long> {
//    List<NhaThuocs> findByUserId(Long id);

    @Query("SELECT c FROM WarehouseLocation c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    Page<WarehouseLocation> searchPage(@Param("param") WarehouseLocationReq param, Pageable pageable);

    @Query("SELECT c FROM WarehouseLocation c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    List<WarehouseLocation> searchList(@Param("param") WarehouseLocationReq param);

}
