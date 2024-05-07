package vn.com.gsoft.categories.service;

import vn.com.gsoft.categories.entity.ESDiagnose;
import vn.com.gsoft.categories.model.dto.ESDiagnoseReq;

import java.util.List;

public interface ESDiagnoseService {
    List<ESDiagnose> searchList(ESDiagnoseReq objReq);
}
