package spring.boot.homework.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.boot.homework.entity.Department;
import spring.boot.homework.service.interfaces.DepartmentService;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value="/createDepartment", method = RequestMethod.GET)
    public String getDepartment(Model model){
        model.addAttribute("department", new Department());
        return "createDepartment";
    }

    @RequestMapping(value="/createDepartment", method = RequestMethod.POST)
    public String createEmployee(@ModelAttribute Department department){
        departmentService.save(department);
        return "redirect:/departmentList";
    }

    @RequestMapping(value = "/departmentList", method = RequestMethod.GET)
    public String employeeList(Model model){
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("list", departments);
        return "departmentList";
    }

    @RequestMapping(value = "/deleteDepartment/{id}")
    public String deleteEmployee(@PathVariable String id){
        departmentService.deleteDepartmentById(Long.valueOf(id));
        return "redirect:/departmentList";
    }

    @RequestMapping(value = "updateDepartment/{id}", method = RequestMethod.GET)
    public String getUpdate(Model model, @PathVariable("id") String id){
        model.addAttribute("department", departmentService.getDepartmentById(Long.valueOf(id)));
        return "updateDepartment";
    }

    @RequestMapping(value = "updateDepartment", method = RequestMethod.POST)
    public String update(@ModelAttribute Department department){

        departmentService.save(department);
        return "redirect:/departmentList";
    }

}
