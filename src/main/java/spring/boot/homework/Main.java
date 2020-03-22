package spring.boot.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.boot.homework.entity.Department;
import spring.boot.homework.entity.Employee;
import spring.boot.homework.entity.EmployeeDetail;
import spring.boot.homework.entity.Meeting;
import spring.boot.homework.service.spring_hibernate.DepartmentService;
import spring.boot.homework.service.spring_hibernate.EmployeeDetailService;
import spring.boot.homework.service.spring_hibernate.EmployeeService;
import spring.boot.homework.service.spring_hibernate.MeetingService;

public class Main {

    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-data-and-hibernate-config.xml");
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        EmployeeDetailService detailService = context.getBean(EmployeeDetailService.class);
        DepartmentService departmentService = context.getBean(DepartmentService.class);
        MeetingService meetingService = context.getBean(MeetingService.class);


        Employee employee = new Employee(null, "Serg", "Kor", null, null, null, null);
        employeeService.add(employee);

        EmployeeDetail employeeDetail = new EmployeeDetail(null, "Borisov", "Gagarina", employee);
        detailService.add(employeeDetail);

        Department department = new Department(null, "Development", null);
        departmentService.add(department);

        Meeting meeting = new Meeting(null, "meeting", null);
        Meeting meeting2 = new Meeting(null, "meeting2", null);
        meetingService.add(meeting);
        meetingService.add(meeting2);
        meetingService.remove(1L);

        employee.setDepartment(department);
        employeeService.update(employee);
        System.err.println(employee);

        departmentService.update(new Department(null, "DevOps", null));
        employee.setName("Sergey");
        employee.setSurname("Korolyov");
        employee.setDepartment(department);
        employeeService.update(employee);

        System.err.println(employee);


    }


}
