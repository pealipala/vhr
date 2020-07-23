package cn.pealipala.vhr.controller.emp;

import cn.pealipala.vhr.model.*;
import cn.pealipala.vhr.service.*;
import cn.pealipala.vhr.utils.POIUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/12 19:20
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private NationService nationService;

    @Autowired
    private PoliticsstatusService politicsstatusService;

    @Autowired
    private JobLevelService jobLevelService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, String keywords) {
        return employeeService.getEmployeeByPage(page, size, keywords);
    }

    @PostMapping("/")
    public RespBean addEmployee(@RequestBody Employee employee) {
        if (employeeService.addEmployee(employee) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmployee(@PathVariable Integer id) {
        if (employeeService.deleteEmployee(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("/")
    public RespBean updateEmployee(@RequestBody Employee employee) {
        if (employeeService.updateEmployee(employee) == 1) {
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/joblevels")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/maxworkid")
    public RespBean getMaxWorkID() {
        RespBean respBean = RespBean.build().
                setStatus(200).
                setObj(String.format("%08d", employeeService.getMaxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> list = (List<Employee>) employeeService.getEmployeeByPage(null,null,null).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file,nationService.getAllNations(),politicsstatusService.getAllPoliticsstatus(),departmentService.getAllDepartmentsWithOutChildRen(),positionService.getAllPositions(),jobLevelService.getAllJobLevels());
        if (employeeService.addEmps(list) == list.size()){
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }




}
