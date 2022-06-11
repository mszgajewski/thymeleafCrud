package com.example.thymeleafCrud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {

    public Map<String, Employee> empMap = new HashMap<>();

    public EmployeeController() {
        empMap.put("E101", new Employee("1", "Brett", "Lee", 23));
        empMap.put("E102", new Employee("2", "Chris", "Gayle", 23));
        empMap.put("E103", new Employee("3", "Brian", "Lara", 23));
        empMap.put("E104", new Employee("4", "MS", "Dhoni", 23));

    }

    @GetMapping("/employee")
    public String getAllEmployees(Model model) {

        model.addAttribute("employees", empMap.values());

        return "employee-list";
    }

    // to get employee form
    @GetMapping("/employee/add")
    public String addEmployee() {

        return "employee-form";
    }

    // to add new employee
    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute("addEmployee") Employee employee, Model model) {
        empMap.put(employee.getId(), employee);
        model.addAttribute("employees", empMap.values());
        return "employee-list";
    }

    // get employee to edit
    @GetMapping("/employee/edit/{id}")
    public String getAllEmployees(Model model, @PathVariable("id") String empId) {

        model.addAttribute("editEmployee", empMap.get(empId));

        return "employee-edit";
    }

    // to update edited employee
    @PostMapping("/employee/edit/{id}")
    public String updateEmployee(@ModelAttribute("editEmployee") Employee employee, @PathVariable("id") String empId,
                                 Model model) {

        empMap.put(empId, employee);

        model.addAttribute("employees", empMap.values());
        return "employee-list";
    }

    // to delete particular employee
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(Model model, @PathVariable("id") String empId) {
        empMap.remove(empId);
        model.addAttribute("employees", empMap.values());
        return "employee-list";
    }
}
