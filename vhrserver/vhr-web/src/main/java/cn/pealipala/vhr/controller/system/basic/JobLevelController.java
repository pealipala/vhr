package cn.pealipala.vhr.controller.system.basic;

import cn.pealipala.vhr.model.JobLevel;
import cn.pealipala.vhr.model.Position;
import cn.pealipala.vhr.model.RespBean;
import cn.pealipala.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/2 23:24
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    private JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.addJobLevel(jobLevel)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody  JobLevel jobLevel){
        if (jobLevelService.updateJobLevel(jobLevel) == 1){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelByIds(Integer[] ids){
        if (jobLevelService.deleteJobLevelByIds(ids) == ids.length){
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id){
        if (jobLevelService.deleteJobLevel(id) == 1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
