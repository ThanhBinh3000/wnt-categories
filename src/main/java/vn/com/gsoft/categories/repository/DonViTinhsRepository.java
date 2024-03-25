package vn.com.gsoft.categories.repository;

import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.DonViTinhs;
import vn.com.gsoft.categories.entity.NhomBacSies;
import vn.com.gsoft.categories.model.dto.DonViTinhsReq;
import vn.com.gsoft.categories.model.dto.NhomBacSiesReq;

import java.util.List;

@Repository
public interface DonViTinhsRepository extends CrudRepository<DonViTinhs, Long> {
//    List<NhaThuocs> findByUserId(Long id);

    @Query("SELECT c FROM DonViTinhs c " +
            " WHERE 1=1 " +
            "ORDER BY c.maDonViTinh desc "
    )
    Page<DonViTinhs> searchPage(@Param("param") DonViTinhsReq param, Pageable pageable);

    @Query("SELECT c FROM DonViTinhs c " +
            " WHERE 1=1 " +
            "ORDER BY c.maDonViTinh desc "
    )
    List<DonViTinhs> searchList(@Param("param") DonViTinhsReq param);

}
