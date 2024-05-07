package vn.com.gsoft.categories.service;

import org.springframework.data.domain.Page;
import vn.com.gsoft.categories.entity.ESDiagnose;
import vn.com.gsoft.categories.model.dto.ESDiagnoseReq;

import java.util.List;

public interface ESDiagnoseService {
    List<ESDiagnose> searchList(ESDiagnoseReq objReq);

    Page<ESDiagnose> searchPage(ESDiagnoseReq noteMedicalsReq);
}
