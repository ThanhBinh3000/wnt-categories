package vn.com.gsoft.categories.controller;

import jakarta.validation.Valid;
import vn.com.gsoft.categories.constant.PathContains;
import vn.com.gsoft.categories.entity.*;
import vn.com.gsoft.categories.model.dto.NhaCungCapsReq;
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
@RequestMapping(PathContains.URL_NHA_CUNG_CAP)
public class NhaCungCapsController {
	
  @Autowired
  NhaCungCapsService service;


  @PostMapping(value = PathContains.URL_SEARCH_PAGE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> colection(@RequestBody NhaCungCapsReq objReq) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.searchSupplierManagementPage(objReq)));
  }


  @PostMapping(value = PathContains.URL_SEARCH_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> colectionList(@RequestBody NhaCungCapsReq objReq) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.searchList(objReq)));
  }

  @PostMapping(value = PathContains.URL_CREATE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<BaseResponse> insert(@Valid @RequestBody NhaCungCapsReq objReq) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.create(objReq)));
  }


  @PostMapping(value = PathContains.URL_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<BaseResponse> update(@Valid @RequestBody NhaCungCapsReq objReq) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.update(objReq)));
  }


  @GetMapping(value = PathContains.URL_DETAIL, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> detail(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.detail(id)));
  }


  @PostMapping(value = PathContains.URL_DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> delete(@Valid @RequestBody NhaCungCapsReq idSearchReq) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.delete(idSearchReq.getId())));
  }
  @PostMapping(value = PathContains.URL_RESTORE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> restore(@Valid @RequestBody NhaCungCapsReq idSearchReq) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.restore(idSearchReq.getId())));
  }
  @PostMapping(value = PathContains.URL_DELETE+"-forever", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> deleteForever(@Valid @RequestBody NhaCungCapsReq idSearchReq) throws Exception {
    return ResponseEntity.ok(ResponseUtils.ok(service.deleteForever(idSearchReq.getId())));
  }
}
