package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.BankAccount;
import vn.com.gsoft.categories.model.dto.BankAccountReq;

import java.util.List;

@Repository
public interface BankAccountRepository extends BaseRepository<BankAccount, BankAccountReq, Long> {
    @Query("SELECT c FROM BankAccount c " +
            "WHERE 1=1 "
            + " AND (:#{#param.storeCode} IS NULL OR c.storeCode = :#{#param.storeCode}) "
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.id desc"
    )
    Page<BankAccount> searchPage(@Param("param") BankAccountReq param, Pageable pageable);


    @Query("SELECT c FROM BankAccount c " +
            "WHERE 1=1 "
            + " AND (:#{#param.storeCode} IS NULL OR c.storeCode = :#{#param.storeCode}) "
            + " AND (:#{#param.recordStatusId} IS NULL OR c.recordStatusId = :#{#param.recordStatusId}) "
            + " ORDER BY c.id desc"
    )
    List<BankAccount> searchList(@Param("param") BankAccountReq param);
}
