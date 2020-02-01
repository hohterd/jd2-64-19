package by.it.academy.foodorder.criteriaDAO;

import by.it.academy.foodorder.entity.EmployeeCriteria;

import java.util.List;

public interface EmployeeDao {

    List<EmployeeCriteria> getAll();

    List<EmployeeCriteria> getByName(String name);

    List<EmployeeCriteria> getAllWithNameNotNull();

    List<EmployeeCriteria> getSalaryGreaterThan(Double salary);

    List<EmployeeCriteria> getSalaryGreaterThanOrderDesc(Double salary);

    List<EmployeeCriteria> getSalaryLessOrEqual(Double salary);

    List<EmployeeCriteria> getByAgeBetween(Integer from, Integer to);

    List<EmployeeCriteria> getByAgeAndName(String name, Integer age);

    List<EmployeeCriteria> getByAgeOrName(String name, Integer age);

    long getEmployeeCount();

    Double getAverageSalary();

    Double getMaxSalary();

    Integer getMinAge();

    Double getAverageSalaryByDep(Long depId);

}
