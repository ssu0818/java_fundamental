package java_20210511;

public class ShapeDemo {
	public static void main(String[] args) {
		ShapeManager manager = ShapeManager.getInstance();
		Triangle t = new Triangle();
		manager.run(t);
		
		
		
		
		/*
		Shape s = new Rectangle();
		s.draw();
		 
		s = new Triangle();
		s.draw();
		
		s = new Circle();
		s.draw();
		*/
		
	
	}
}
