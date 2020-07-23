package cn.pealipala.vhr.service;

import cn.pealipala.vhr.mapper.PositionMapper;
import cn.pealipala.vhr.model.Position;
import cn.pealipala.vhr.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/1 23:47
 */
@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }


    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionByIds(Integer[] ids) {
        return positionMapper.deletePositionByIds(ids);
    }
}
