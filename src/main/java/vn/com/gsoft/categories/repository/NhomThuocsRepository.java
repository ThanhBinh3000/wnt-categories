package vn.com.gsoft.categories.repository;

import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomThuocs;
import vn.com.gsoft.categories.model.system.NhomThuocsReq;


import java.util.List;

@Repository
public interface NhomThuocsRepository extends CrudRepository<NhomThuocs, Long> {
//    List<NhaThuocs> findByUserId(Long id);

    @Query("SELECT c FROM NhomThuocs c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    Page<NhomThuocs> searchPage(@Param("param") NhomThuocsReq param, Pageable pageable);

    @Query("SELECT c FROM NhomThuocs c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    List<NhomThuocs> searchList(@Param("param") NhomThuocsReq param);

}
