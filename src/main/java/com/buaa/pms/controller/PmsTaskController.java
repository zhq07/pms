package com.buaa.pms.controller;

import com.buaa.pms.entity.PmsTask;
import com.buaa.pms.service.PmsTaskService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("pms/task")
public class PmsTaskController {
    @Resource
    PmsTaskService pmsTaskService;

    @GetMapping("/getAll")
    public List<PmsTask> getPmsTaskAll() {
        return pmsTaskService.selectAll();
    }

    @GetMapping("/getByProjUid/{taskProjUid}")
    public List<PmsTask> selectByProjUid(@PathVariable String taskProjUid) {
        return pmsTaskService.selectByProjUid(taskProjUid);
    }

    @GetMapping("/getByProcUid/{taskProcUid}")
    public List<PmsTask> selectByProcUid(@PathVariable String taskProcUid) {
        return pmsTaskService.selectByProcUid(taskProcUid);
    }

    @GetMapping("/getByParUid/{taskParUid}")
    public List<PmsTask> getPmsTaskByParUid(@PathVariable String taskParUid) {
        return pmsTaskService.selectByParUid(taskParUid);
    }

    @GetMapping("/getByUid/{taskUid}")
    public PmsTask getPmsTaskByUid(@PathVariable String taskUid) {
        return pmsTaskService.selectByUid(taskUid);
    }

    @PostMapping("/save")
    public void insert(@RequestBody PmsTask pmsTask){
        pmsTaskService.save(pmsTask);
    }

    @DeleteMapping("/deleteByUid/{taskUid}")
    public void deleteByUid(@PathVariable String taskUid) {
        pmsTaskService.deleteByUid(taskUid);
    }

    @DeleteMapping("/deleteByProjUid/{taskProjUid}")
    public void deleteByProjUid(@PathVariable String taskProjUid) {
        pmsTaskService.deleteByUid(taskProjUid);
    }

    @DeleteMapping("/deleteByProcUid/{taskProcUid}")
    public void deleteByProcUid(@PathVariable String taskProcUid) {
        pmsTaskService.deleteByUid(taskProcUid);
    }

    @DeleteMapping("/deleteByParUid/{taskParUid}")
    public void deleteByParUid(@PathVariable String taskParUid) {
        pmsTaskService.deleteByUid(taskParUid);
    }

    @PutMapping("/update")
    public void update(@RequestBody PmsTask pmsTask) {
        pmsTaskService.update(pmsTask);
    }

    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestBody PmsTask pmsTask){
        pmsTaskService.saveOrUpdate(pmsTask);
    }

}
