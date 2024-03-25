package vn.com.gsoft.categories.repository;

import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.entity.Thuocs;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;
import vn.com.gsoft.categories.model.dto.ThuocsReq;

import java.util.List;

@Repository
public interface ThuocsRepository extends BaseRepository<Thuocs, ThuocsReq, Long> {
//    List<NhaThuocs> findByUserId(Long id);

    @Query("SELECT c FROM Thuocs c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    Page<Thuocs> searchPage(@Param("param") ThuocsReq param, Pageable pageable);

    @Query("SELECT c FROM Thuocs c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    List<Thuocs> searchList(@Param("param") ThuocsReq param);

}
