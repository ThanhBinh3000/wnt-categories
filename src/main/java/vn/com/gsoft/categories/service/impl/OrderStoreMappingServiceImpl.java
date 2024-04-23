package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.OrderStoreMappingConstant;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.OrderStoreMapping;
import vn.com.gsoft.categories.model.dto.OrderStoreMappingReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.OrderStoreMappingRepository;
import vn.com.gsoft.categories.service.OrderStoreMappingService;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class OrderStoreMappingServiceImpl extends BaseServiceImpl<OrderStoreMapping, OrderStoreMappingReq, Long> implements OrderStoreMappingService {

    private OrderStoreMappingRepository hdrRepo;

    @Autowired
    public OrderStoreMappingServiceImpl(OrderStoreMappingRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

    @Override
    public OrderStoreMapping create(OrderStoreMappingReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null) throw new Exception("Bad request.");

        OrderStoreMapping e = hdrRepo.findByStoreCodeAndTargetStoreCode(req.getStoreCode(), req.getTargetStoreCode())
                .orElseGet(() -> {
                    OrderStoreMapping newEntity = new OrderStoreMapping();
                    newEntity.setStoreCode(req.getStoreCode());
                    newEntity.setTargetStoreCode(req.getTargetStoreCode());
                    return newEntity;
                });

        if (req.getUpdateTypeId() == OrderStoreMappingConstant.Active) {
            e.setRecordStatusId(req.getUpdateValue() ? RecordStatusContains.ACTIVE : RecordStatusContains.DELETED);
            if (!req.getUpdateValue()) e.setIsDefault(true);
        } else if (req.getUpdateTypeId() == OrderStoreMappingConstant.SetDefault) {
            e.setIsDefault(req.getUpdateValue());
            if (req.getUpdateValue()) {
                e.setRecordStatusId(RecordStatusContains.ACTIVE);
                List<OrderStoreMapping> byStoreCode = hdrRepo.findAllByStoreCode(req.getStoreCode());
                byStoreCode.stream()
                        .filter(orderStoreMapping -> !orderStoreMapping.getStoreCode().equals(e.getStoreCode()))
                        .forEach(orderStoreMapping -> orderStoreMapping.setIsDefault(false));
                hdrRepo.saveAll(byStoreCode);
            }
        }
        hdrRepo.save(e);
        return e;
    }
}
