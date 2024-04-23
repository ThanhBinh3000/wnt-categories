package vn.com.gsoft.categories.repository;

import org.springframework.data.repository.CrudRepository;
import vn.com.gsoft.categories.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.gsoft.categories.model.dto.PaymentTypeReq;

import java.util.List;

@Repository
public interface PaymentTypeRepository extends CrudRepository<PaymentType, Long> {


  @Query("SELECT c FROM PaymentType c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.name} IS NULL OR lower(c.name) LIKE lower(concat('%',CONCAT(:#{#param.name},'%'))))"
          + " AND (:#{#param.displayName} IS NULL OR lower(c.displayName) LIKE lower(concat('%',CONCAT(:#{#param.displayName},'%'))))"
          + " ORDER BY c.id desc"
  )
  List<PaymentType> searchList(@Param("param") PaymentTypeReq param);

}
