package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.categories.entity.NhomNhaCungCaps;
import vn.com.gsoft.categories.entity.PhieuNhaps;
import vn.com.gsoft.categories.model.dto.NhomNhaCungCapsReq;

import java.util.List;

@Repository
public interface PhieuNhapsRepository extends CrudRepository<PhieuNhaps, Long> {
    PhieuNhaps findByNhaThuocMaNhaThuocAndNhaCungCapMaNhaCungCapAndLoaiXuatNhapMaLoaiXuatNhapAndRecordStatusId(
            String nhaThuocMaNhaThuoc,
            Long nhaCungCapMaNhaCungCap,
            Integer maLoaiXuatNhap,
            Integer recordStatusId);
}