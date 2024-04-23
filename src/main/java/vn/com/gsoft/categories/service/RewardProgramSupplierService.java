package vn.com.gsoft.categories.service;
import vn.com.gsoft.categories.entity.RewardProgramSupplier;
import vn.com.gsoft.categories.model.dto.RewardProgramSupplierReq;
import vn.com.gsoft.categories.model.dto.RewardProgramSupplierRes;

import java.util.List;

public interface RewardProgramSupplierService extends BaseService<RewardProgramSupplier, RewardProgramSupplierReq, Long> {
    List<RewardProgramSupplierRes> searchManagementList(RewardProgramSupplierReq req) throws Exception;
}