package spring.boot.homework.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.boot.homework.entity.Employee;
import spring.boot.homework.service.interfaces.DepartmentService;
import spring.boot.homework.service.interfaces.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value="/createEmployee", method = RequestMethod.GET)
    public String getEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "createEmployee";
    }

    @RequestMapping(value="/createEmployee", method = RequestMethod.POST)
    public String createEmployee(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/employeeList";
    }

    @RequestMapping(value = "/employeeList", method = RequestMethod.GET)
    public String employeeList(Model model){
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("list", employeeList);
        return "employeeList";
    }

    @RequestMapping(value = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployeeById(Long.valueOf(id));
        return "redirect:/employeeList";
    }

    @RequestMapping(value = "updateEmployee/{id}", method = RequestMethod.GET)
    public String getUpdate(Model model, @PathVariable("id") String id){
        model.addAttribute("employee", employeeService.getEmployeeById(Long.valueOf(id)));
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "updateEmployee";
    }

    @RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
    public String update(@ModelAttribute Employee employee){

        employeeService.save(employee);
        return "redirect:/employeeList";
    }

}

