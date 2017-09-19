package prototype_pattern;

public class Main{
	   public static void main(String[] args) {
	      ShapeProtoType.loadCache();

	      Shape clonedShape = (Shape) ShapeProtoType.getShape("1");
	      System.out.println("Shape : " + clonedShape.getType());    

	      Shape clonedShape2 = (Shape) ShapeProtoType.getShape("2");
	      System.out.println("Shape : " + clonedShape2.getType());    

	      Shape clonedShape3 = (Shape) ShapeProtoType.getShape("3");
	      System.out.println("Shape : " + clonedShape3.getType());    
	   }
}