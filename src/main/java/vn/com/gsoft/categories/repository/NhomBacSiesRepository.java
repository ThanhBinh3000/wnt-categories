package vn.com.gsoft.categories.repository;

import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;

import java.util.List;

@Repository
public interface NhomBacSiesRepository extends BaseRepository<NhomBacSies, NhomBacSiesReq, Long> {
//    List<NhaThuocs> findByUserId(Long id);

    @Query("SELECT c FROM NhomBacSies c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    Page<NhomBacSies> searchPage(@Param("param") NhomBacSiesReq param, Pageable pageable);

    @Query("SELECT c FROM NhomBacSies c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    List<NhomBacSies> searchList(@Param("param") NhomBacSiesReq param);

}
