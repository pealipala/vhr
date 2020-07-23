package cn.pealipala.vhr.service;

import cn.pealipala.vhr.mapper.NationMapper;
import cn.pealipala.vhr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/15 22:55
 */
@Service
public class NationService {
    @Autowired
    private NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
