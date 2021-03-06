package com.restwizard.core;

import com.restwizard.api.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeDAO {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeDAO.class);

    private static HashMap<Integer, Employee> employees = new HashMap<>();
        static {
            employees.put(101, new Employee(101, "ABC"));
            employees.put(102, new Employee(102, "XYZ"));
        }

    public static List<Employee> getEmployees () {
        return new ArrayList<>(employees.values());
    }

    public static Employee getEmployeeById (Integer id) {
        return employees.get(id);
    }

    public static void updateEmployee (Integer id, Employee newDetails) {
        employees.put (id, newDetails);
    }

    public static void removeEmployee (Integer id) {
        employees.remove(id);
    }
}
