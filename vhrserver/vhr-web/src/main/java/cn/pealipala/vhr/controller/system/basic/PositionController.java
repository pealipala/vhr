package cn.pealipala.vhr.controller.system.basic;

import cn.pealipala.vhr.model.Position;
import cn.pealipala.vhr.model.RespBean;
import cn.pealipala.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/1 23:45
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if (positionService.addPosition(position) == 1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if (positionService.updatePosition(position) == 1){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids){
        if (positionService.deletePositionByIds(ids) == ids.length){
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id){
        if (positionService.deletePosition(id) == 1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
