package vn.com.gsoft.categories.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.ProcessDtl;

@Repository
public interface ProcessDtlRepository extends CrudRepository<ProcessDtl, Long> {

}
