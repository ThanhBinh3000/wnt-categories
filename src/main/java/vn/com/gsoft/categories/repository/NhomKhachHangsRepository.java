package vn.com.gsoft.categories.repository;

import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomKhachHangs;
import vn.com.gsoft.categories.model.dto.NhomKhachHangsReq;

import java.util.List;

@Repository
public interface NhomKhachHangsRepository extends BaseRepository<NhomKhachHangs, NhomKhachHangsReq, Long> {
//    List<NhaThuocs> findByUserId(Long id);

    @Query("SELECT c FROM NhomKhachHangs c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    Page<NhomKhachHangs> searchPage(@Param("param") NhomKhachHangsReq param, Pageable pageable);

    @Query("SELECT c FROM NhomKhachHangs c " +
            " WHERE 1=1 " +
            "ORDER BY c.modified desc , c.created desc"
    )
    List<NhomKhachHangs> searchList(@Param("param") NhomKhachHangsReq param);

}
