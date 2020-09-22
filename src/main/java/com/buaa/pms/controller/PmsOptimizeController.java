package com.buaa.pms.controller;

import com.buaa.pms.entity.PmsProject;
import com.buaa.pms.entity.PmsTask;
import com.buaa.pms.model.OptResult;
import com.buaa.pms.model.Task;
import com.buaa.pms.service.opt.OptMain;
import com.buaa.pms.util.JsonUtil;
import com.buaa.pms.util.TimestampMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("pms/projOpt")
public class PmsOptimizeController {
    @Resource
    OptMain optMain;

    @PostMapping("/getOptResult")
    public OptResult getOptResult(@RequestBody List<String> procUidList) {
        return optMain.testWeb(procUidList);
    }

    @RequestMapping("/testOptResult")
    public JSONObject testOptResult(@RequestBody JSONObject info) {
        JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher());     // 注册时间转换方式，Long转Timestamp
        return optMain.testWebLink(info);
    }
}
