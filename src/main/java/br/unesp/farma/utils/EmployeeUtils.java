package br.unesp.farma.utils;

import br.unesp.farma.models.Employee;
import br.unesp.farma.models.Role;

public class EmployeeUtils {

    public static void createEmployee(String name, Role role){
        Employee employee = new Employee(name, role);
    }

    public static void editEmployee(){

    }

    public static void deleteEmployee(){

    }
}
