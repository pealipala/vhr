package cn.pealipala.vhr.service;

import cn.pealipala.vhr.mapper.EmployeeMapper;
import cn.pealipala.vhr.model.Employee;
import cn.pealipala.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/12 19:25
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");


    public RespPageBean getEmployeeByPage(Integer page, Integer size,String keywords) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page,size,keywords);
        Long total = employeeMapper.getTotal(keywords);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal(total);
        respPageBean.setData(data);
        return respPageBean;
    }

    public Integer addEmployee(Employee employee) {
        Date begincontract = employee.getBegincontract();
        Date endcontract = employee.getEndcontract();
        double month = (Double.parseDouble(yearFormat.format(endcontract)) - Double.parseDouble(yearFormat.format(begincontract))) * 12
                + (Double.parseDouble(monthFormat.format(endcontract)) - Double.parseDouble(monthFormat.format(begincontract)));
        employee.setContractterm(Double.parseDouble(decimalFormat.format(month/12)));
        return employeeMapper.insertSelective(employee);
    }

    public Integer getMaxWorkID() {
        return employeeMapper.getMaxWorkID();
    }

    public Integer deleteEmployee(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }
}
