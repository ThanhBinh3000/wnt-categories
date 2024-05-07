package vn.com.gsoft.categories.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import vn.com.gsoft.categories.entity.ESDiagnose;
import vn.com.gsoft.categories.model.dto.ESDiagnoseReq;
import vn.com.gsoft.categories.model.system.PaggingReq;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.service.ESDiagnoseService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ESDiagnoseServiceImplTest {
    @Autowired
    private ESDiagnoseService esdiagnoseService;
    @BeforeAll
    static void beforeAll() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Profile p = new Profile();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(p, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Test
    void searchList() throws Exception {
        ESDiagnoseReq noteMedicalsReq = new ESDiagnoseReq();
        PaggingReq paggingReq = new PaggingReq();
        paggingReq.setPage(0);
        paggingReq.setLimit(10);
        noteMedicalsReq.setPaggingReq(paggingReq);
        List<ESDiagnose> sampleNotes = esdiagnoseService.searchList(noteMedicalsReq);
        assert sampleNotes != null;
    }
    @Test
    void searchPage() throws Exception {
        ESDiagnoseReq noteMedicalsReq = new ESDiagnoseReq();
        PaggingReq paggingReq = new PaggingReq();
        paggingReq.setPage(0);
        paggingReq.setLimit(10);
        noteMedicalsReq.setPaggingReq(paggingReq);
        Page<ESDiagnose> sampleNotes = esdiagnoseService.searchPage(noteMedicalsReq);
        assert sampleNotes != null;
    }
}