package mod.instance;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Shape extends JPanel {
	Point selectedPortPoint = null;
	Rectangle[] ports = new Rectangle[4];
	
	public void setSelectedSide(Point point) {
		Point p = new Point();
		p.x = point.x - this.getLocation().x;
		p.y = point.y - this.getLocation().y;
		System.out.println("Basic Class set selected side");
		for(int i = 0; i < ports.length; i++) {
			System.out.print(i);
			System.out.print(", ");
			System.out.print(ports[i]);
			System.out.print(", ");
			System.out.print(p);
			System.out.print(", ");
			System.out.println(ports[i].contains(p));
			if (ports[i].contains(p)) {
				selectedPortPoint = point;	
			}			
		}
	}
	
	public Point getSelectedPortPoint() {
		return this.selectedPortPoint;
	};
}
