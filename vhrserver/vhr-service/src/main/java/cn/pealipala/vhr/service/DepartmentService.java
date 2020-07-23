package cn.pealipala.vhr.service;

import cn.pealipala.vhr.mapper.DepartmentMapper;
import cn.pealipala.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/8 22:01
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }

    public void deleteDepById(Department dep) {
        departmentMapper.deleteDepById(dep);
    }

    public List<Department> getAllDepartmentsWithOutChildRen() {
        return departmentMapper.getAllDepartmentsWithOutChildRen();
    }
}
