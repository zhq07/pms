package com.buaa.pms.controller;

import com.buaa.pms.model.OptResult;
import com.buaa.pms.service.opt.GaOpt;
import com.buaa.pms.service.opt.OptMain;
import com.buaa.pms.service.opt.WebOptMain;
import com.buaa.pms.util.TimestampMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("pms/projOpt")
public class PmsOptimizeController {
    @Resource
    OptMain optMain;
    @Resource
    WebOptMain webOptMain;
    @Resource
    GaOpt gaOpt;

    @PostMapping("/getOptResultGa")
    public OptResult getOptResultGa(@RequestBody List<String> procUidList) {
        return gaOpt.testWeb(procUidList);
    }

    @PostMapping("/getOptResult")
    public OptResult getOptResult(@RequestBody List<String> procUidList) {
        return optMain.testWeb(procUidList);
    }

    @RequestMapping("/testOptResult")
    public JSONObject testOptResult(@RequestBody JSONObject info) {
        JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher());     // 注册时间转换方式，Long转Timestamp
        return webOptMain.optResult(info);
    }

    @RequestMapping("/webOptResult")
    public JSONObject webOptResult(@RequestBody JSONObject info) {
        JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher());     // 注册时间转换方式，Long转Timestamp
        return webOptMain.optResult(info);
    }
}
