package filter_criteria_pattern;

import java.util.List;

public interface Criteria {
	public List<Employee> meetCriteria(List<Employee> persons);
}
