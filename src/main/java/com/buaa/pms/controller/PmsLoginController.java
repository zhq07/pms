package com.buaa.pms.controller;

import com.buaa.pms.service.PmsLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/pms")
public class PmsLoginController {

    @Resource
    PmsLoginService pmsLoginService;

    @PostMapping("/login")
    public String Login(@RequestBody Map<String, String> pmsUser) {
        return pmsLoginService.pmsLogin(pmsUser);
    }
}
