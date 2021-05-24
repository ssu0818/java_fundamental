package java_20210511;

public class ShapeManager {
	
	private static ShapeManager single;

	private ShapeManager() {
	}

	public static ShapeManager getInstance() {
		if (single == null) {
			single = new ShapeManager();
		}
		return single;
	}
	
	
	public void run(Shape s) {
		s.draw();
	}
	
	/*
	public void run() {
		Rectangle r = new Rectangle();
		r.draw();
	}
	public void run2() {
		Triangle t = new Triangle();
		t.draw();
	}
	public void run3() {
		Circle c = new Circle();
		c.draw();
	}
	*/
	
}
