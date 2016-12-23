package filter_criteria_pattern;

import java.util.List;

class AndCriteria implements Criteria {
	private Criteria criteria;
	  private Criteria otherCriteria;

	  public AndCriteria(Criteria criteria, Criteria otherCriteria) {
	    this.criteria = criteria;
	    this.otherCriteria = otherCriteria;
	  }

	  @Override
	  public List<Employee> meetCriteria(List<Employee> persons) {
	    List<Employee> firstCriteriaPersons = criteria.meetCriteria(persons);
	    return otherCriteria.meetCriteria(firstCriteriaPersons);
	  }
}
