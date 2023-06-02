package mod.instance;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Shape extends JPanel {
	Point selectedPortPoint = null;
	Rectangle[] ports = new Rectangle[4];
	boolean isSelect = false;
	int	selectBoxSize = 8;
	
	public boolean isSelect()
	{
		return isSelect;
	}

	public void setSelect(boolean isSelect)
	{
		this.isSelect = isSelect;
		if (!isSelect) {
			selectedPortPoint = null;
		}
	}

	public void paintSelect(Graphics gra)
	{
		for(int i = 0; i < ports.length; i++) {
			gra.fillRect(ports[i].x, ports[i].y, ports[i].width, ports[i].height);
		}
	}
	
	public void setPort() {
		int[] x_point = {this.getWidth() / 2 - selectBoxSize, this.getWidth() / 2 - selectBoxSize, 0, this.getWidth() - selectBoxSize};
		int[] y_point = {0, this.getHeight() - selectBoxSize, this.getHeight() / 2 - selectBoxSize, this.getHeight() / 2 - selectBoxSize};
		int[] width = {selectBoxSize * 2, selectBoxSize * 2, selectBoxSize, selectBoxSize};
		int[] height = {selectBoxSize, selectBoxSize, selectBoxSize * 2, selectBoxSize * 2};
		for(int i = 0; i < ports.length; i++) {
			ports[i] = new Rectangle(x_point[i], y_point[i], width[i], height[i]);
		}
	}
	
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
