package null_object_pattern;

class NullCustomer extends AbstractEmployee {

	@Override
	public String getName() {
		return "Not Available";
	}

	@Override
	public boolean isNull() {
		return true;
	}
}
