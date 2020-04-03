package com.buaa.pms.service;

import org.springframework.stereotype.Service;

import java.util.Map;

public interface PmsLoginService {

    public String pmsLogin(Map<String, String> pmsUser);
}
