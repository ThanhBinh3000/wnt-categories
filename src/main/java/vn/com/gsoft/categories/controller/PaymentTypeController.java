package vn.com.gsoft.categories.controller;

import vn.com.gsoft.categories.constant.PathContains;
import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.PaymentTypeReq;
import vn.com.gsoft.categories.model.system.BaseResponse;
import vn.com.gsoft.categories.repository.*;
import vn.com.gsoft.categories.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.gsoft.categories.util.system.ResponseUtils;

@Slf4j
@RestController
@RequestMapping("/payment-type")
public class PaymentTypeController {
	
  @Autowired
  PaymentTypeRepository service;


  @PostMapping(value = PathContains.URL_SEARCH_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> colectionList(@RequestBody PaymentTypeReq objReq) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.searchList(objReq)));
  }


}
