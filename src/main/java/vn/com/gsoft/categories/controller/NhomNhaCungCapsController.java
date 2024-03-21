package vn.com.gsoft.categories.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.gsoft.categories.enums.EnumResponse;
import vn.com.gsoft.categories.model.system.NhomBacSiesReq;
import vn.com.gsoft.categories.model.system.NhomNhaCungCapsReq;
import vn.com.gsoft.categories.response.BaseResponse;
import vn.com.gsoft.categories.service.NhomKhachHangsService;
import vn.com.gsoft.categories.service.NhomNhaCungCapsService;
import vn.com.gsoft.categories.util.system.PathContains;

import java.util.List;

@RestController
@RequestMapping(value = PathContains.URL_NHOM_NHA_CUNG_CAP)
@Slf4j
@Api(tags = "Nhóm nhà cung cấp")
public class NhomNhaCungCapsController {

  @Autowired
  NhomNhaCungCapsService service;

  @ApiOperation(value = "Tra cứu", response = List.class)
  @PostMapping(value = PathContains.URL_SEARCH_PAGE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> colection(@RequestBody NhomNhaCungCapsReq objReq) {
    BaseResponse resp = new BaseResponse();
    try {
      resp.setData(service.searchList(objReq));
      resp.setStatusCode(EnumResponse.RESP_SUCC.getValue());
      resp.setMsg(EnumResponse.RESP_SUCC.getDescription());
    } catch (Exception e) {
      resp.setStatusCode(EnumResponse.RESP_FAIL.getValue());
      resp.setMsg(e.getMessage());
      log.error("Tra cứu thông tin : {}", e);
    }
    return ResponseEntity.ok(resp);
  }


  @ApiOperation(value = "Tạo mới", response = List.class)
  @PostMapping(value = PathContains.URL_CREATE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<BaseResponse> insert(@Valid @RequestBody NhomNhaCungCapsReq objReq) {
    BaseResponse resp = new BaseResponse();
    try {
      resp.setData(service.create(objReq));
      resp.setStatusCode(EnumResponse.RESP_SUCC.getValue());
      resp.setMsg(EnumResponse.RESP_SUCC.getDescription());
    } catch (Exception e) {
      resp.setStatusCode(EnumResponse.RESP_FAIL.getValue());
      resp.setMsg(e.getMessage());
      log.error("Tạo mới thông tin  : {}", e);
    }
    return ResponseEntity.ok(resp);
  }

  @ApiOperation(value = "Lấy chi tiết", response = List.class)
  @GetMapping(value = PathContains.URL_DETAIL, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> detail(@ApiParam(value = "ID thông tin", example = "1", required = true) @PathVariable("id") Long id) {
    BaseResponse resp = new BaseResponse();
    try {
      resp.setData(service.detail(id));
      resp.setStatusCode(EnumResponse.RESP_SUCC.getValue());
      resp.setMsg(EnumResponse.RESP_SUCC.getDescription());
    } catch (Exception e) {
      resp.setStatusCode(EnumResponse.RESP_FAIL.getValue());
      resp.setMsg(e.getMessage());
      log.error("Lấy chi tiết thông tin : {}", e);
    }
    return ResponseEntity.ok(resp);
  }



  @ApiOperation(value = "Xoá thông tin", response = List.class, produces = MediaType.APPLICATION_JSON_VALUE)
  @PostMapping(value = PathContains.URL_DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<BaseResponse> delete(@Valid @RequestBody NhomNhaCungCapsReq idSearchReq) {
    BaseResponse resp = new BaseResponse();
    try {
      service.delete(idSearchReq.getRecordStatusID());
      resp.setStatusCode(EnumResponse.RESP_SUCC.getValue());
      resp.setMsg(EnumResponse.RESP_SUCC.getDescription());
    } catch (Exception e) {
      resp.setStatusCode(EnumResponse.RESP_FAIL.getValue());
      resp.setMsg(e.getMessage());
      log.error("Xoá thông tin : {}", e);
    }

    return ResponseEntity.ok(resp);
  }


}
