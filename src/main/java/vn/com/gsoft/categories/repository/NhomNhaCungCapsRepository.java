package vn.com.gsoft.categories.repository;

import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomNhaCungCaps;
import vn.com.gsoft.categories.model.dto.NhomNhaCungCapsReq;

import java.util.List;

@Repository
public interface NhomNhaCungCapsRepository extends BaseRepository<NhomNhaCungCaps, NhomNhaCungCapsReq, Long> {
//    List<NhaThuocs> findByUserId(Long id);

    @Query("SELECT c FROM NhomNhaCungCaps c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    Page<NhomNhaCungCaps> searchPage(@Param("param") NhomNhaCungCapsReq param, Pageable pageable);

    @Query("SELECT c FROM NhomNhaCungCaps c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    List<NhomNhaCungCaps> searchList(@Param("param") NhomNhaCungCapsReq param);

}
