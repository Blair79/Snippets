package visitor_pattern;

class ConsoleVisitor implements NodeVisitor {

	@Override
	  public void visit(TreeNode n) {
	    System.out.println("console:" + n.getName());
	  }

}
