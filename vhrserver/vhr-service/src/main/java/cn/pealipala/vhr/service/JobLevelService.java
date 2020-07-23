package cn.pealipala.vhr.service;

import cn.pealipala.vhr.mapper.JobLevelMapper;
import cn.pealipala.vhr.model.JobLevel;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/2 23:25
 */
@Service
public class JobLevelService {
    @Autowired
    private JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setEnabled(true);
        jobLevel.setCreatedate(new Date());
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevel(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelByIds(Integer[] ids) {
        return jobLevelMapper.deleteJobLevelByIds(ids);
    }
}
