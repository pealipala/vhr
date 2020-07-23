package cn.pealipala.vhr.service;

import cn.pealipala.vhr.mapper.PoliticsstatusMapper;
import cn.pealipala.vhr.model.Nation;
import cn.pealipala.vhr.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/15 22:56
 */
@Service
public class PoliticsstatusService {

    @Autowired
    private PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
