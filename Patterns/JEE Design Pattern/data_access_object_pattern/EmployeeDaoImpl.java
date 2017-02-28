package data_access_object_pattern;

import java.util.ArrayList;
import java.util.List;

class EmployeeDaoImpl implements EmployeeDao {
	List<Employee> employeeList;

	public EmployeeDaoImpl() {
		employeeList = new ArrayList<Employee>();
		Employee emp1 = new Employee("Jack", 0);
		Employee emp2 = new Employee("Tom", 1);
		employeeList.add(emp1);
		employeeList.add(emp2);
	}

	@Override
	public void delete(Employee student) {
		employeeList.remove(student.getId());
		System.out.println("Employee: No " + student.getId() + ", deleted from database");
	}

	@Override
	public List<Employee> getAll() {
		return employeeList;
	}

	@Override
	public Employee get(int rollNo) {
		return employeeList.get(rollNo);
	}

	@Override
	public void updateStudent(Employee emp) {
		employeeList.get(emp.getId()).setName(emp.getName());
		System.out.println("Emp:No " + emp.getId() + ", updated in the database");
	}
}
