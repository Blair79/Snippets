package data_access_object_pattern;

import java.util.List;

interface EmployeeDao {
	public List<Employee> getAll();

	  public Employee get(int id);

	  public void updateStudent(Employee student);

	  public void delete(Employee student);
}
