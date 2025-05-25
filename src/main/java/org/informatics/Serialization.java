package org.informatics;

import org.informatics.employee.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    public void serialize(List<Employee> employees){

        String fileName = "./employees/employees.ser";
        File file = new File(fileName);
        File parent = file.getParentFile();
        if(parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        try(FileOutputStream stream = new FileOutputStream(file);
            ObjectOutputStream ostream = new ObjectOutputStream(stream)) {
            ostream.writeObject(employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> deserialization() {
        File file = new File("./employees/employees.ser");
        List<Employee> employees = new ArrayList<>();
        if(file.exists()){
            try(FileInputStream stream = new FileInputStream(file);
                ObjectInputStream istream = new ObjectInputStream(stream)) {
                employees = (List<Employee>) istream.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return employees;
    }
}
