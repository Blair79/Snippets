package data_access_object_pattern;

public class Main {
	public static void main(String[] args) {
	    EmployeeDao empDao = new EmployeeDaoImpl();
	    for (Employee emp : empDao.getAll()) {
	      System.out.println("Emp: [No : " + emp.getId() + ", Name : "
	          + emp.getName() + " ]");
	    }
	    Employee emp = empDao.getAll().get(0);
	    emp.setName("Jane");
	    empDao.updateStudent(emp);

	    empDao.get(0);
	    System.out.println("Emp: [No : " + emp.getId() + ", Name : "
	        + emp.getName() + " ]");
	  }
}
