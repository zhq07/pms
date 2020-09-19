package com.buaa.pms.controller;

import com.buaa.pms.entity.PmsTask;
import com.buaa.pms.model.OptResult;
import com.buaa.pms.model.Task;
import com.buaa.pms.service.opt.OptMain;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public String testOptResult(@RequestBody JSONObject object) {
        System.out.println(object);
        return "连接成功";
    }
}
