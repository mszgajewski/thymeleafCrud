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

    public Map<String,Employee> empMap = new HashMap<>();

    public EmployeeController() {
        empMap.put("E101", new Employee("E101", "Lukasz", "Lee", 32));
        empMap.put("E102", new Employee("E102", "Marcin", "Gayle", 33));
        empMap.put("E103", new Employee("E103", "Piotrek", "Lara", 23));
        empMap.put("E104", new Employee("E104", "Slawek", "Dhoni", 34));

    }

    @GetMapping("/employee")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", empMap.values());
        return "employee-list";
    }

    @GetMapping("/employee/add")
    public String addEmployee() {
        return "employee-form";
    }

    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute("addEmployee") Employee employee, Model model) {
        empMap.put(employee.getId(),employee);
        model.addAttribute("employees", empMap.values());
        return "employee-list";
    }

    @GetMapping("/employee/edit/{id}")
    public String getAllEmployees(Model model, @PathVariable("id") String empId) {
        model.addAttribute("editEmployee", empMap.get(empId));

        return "employee-edit";
    }

    @PostMapping("/employee/edit/{id}")
    public String updateEmployee(@ModelAttribute ("editEmployee") Employee employee, @PathVariable("id")
    String empId,Model model) {
        empMap.put(empId,employee);
        model.addAttribute("employees", empMap.values());
        return "employee-list";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(Model model, @PathVariable("'id") String empId) {
        empMap.remove(empId);
        model.addAttribute("employees",empMap.values());
        return "employee-list";
    }





}
