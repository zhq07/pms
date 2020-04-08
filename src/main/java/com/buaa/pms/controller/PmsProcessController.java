package com.buaa.pms.controller;

import com.buaa.pms.entity.PmsProcess;
import com.buaa.pms.service.PmsProcessService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("pms/proc")
public class PmsProcessController {
    @Resource
    PmsProcessService pmsProcessService;

    @GetMapping("/getAll")
    public List<PmsProcess> getPmsProcessAll() {
        return pmsProcessService.selectAll();
    }

    @GetMapping("/getPublished")
    public List<PmsProcess> getPmsProcessPublished() {
        return pmsProcessService.selectPublished();
    }

    @GetMapping("/getByProjUid/{procProjUid}")
    public List<PmsProcess> getPmsProcessByProjUid(@PathVariable String procProjUid) {
        return pmsProcessService.selectByProjUid(procProjUid);
    }

    @GetMapping("/getByUid/{procUid}")
    public PmsProcess getPmsProcessByUid(@PathVariable String procUid) {
        return pmsProcessService.selectByUid(procUid);
    }

    @PostMapping("/save")
    public void insert(@RequestBody PmsProcess pmsProcess){
        pmsProcessService.save(pmsProcess);
    }

    @DeleteMapping("/deleteByUid/{procUid}")
    public void deleteByUid(@PathVariable String procUid) {
        pmsProcessService.deleteByUid(procUid);
    }

    @DeleteMapping("/deleteByProjUid/{procProjUid}")
    public void deleteByProjUid(@PathVariable String procProjUid) {
        pmsProcessService.deleteByUid(procProjUid);
    }

    @PutMapping("/update")
    public void update(@RequestBody PmsProcess pmsProcess) {
        pmsProcessService.update(pmsProcess);
    }

    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestBody PmsProcess pmsProcess){
        pmsProcessService.saveOrUpdate(pmsProcess);
    }

}
