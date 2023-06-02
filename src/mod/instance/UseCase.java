package mod.instance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JPanel;

import bgWork.handler.CanvasPanelHandler;
import mod.IClassPainter;
import mod.IFuncComponent;

public class UseCase extends JPanel implements IFuncComponent, IClassPainter
{
	Vector <String>		texts			= new Vector <>();
	Dimension			defSize			= new Dimension(150, 40);
	int					maxLength		= 20;
	boolean				isSelect		= false;
	int					selectBoxSize	= 8;
	protected Rectangle[] ports = new Rectangle[4];
	Point selectedPortPoint = null;
	CanvasPanelHandler	cph;

	public UseCase(CanvasPanelHandler cph)
	{
		texts.add("New Use Case");
		reSize();
		this.setVisible(true);
		this.setLocation(0, 0);
		this.setOpaque(true);
		this.cph = cph;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		reSize();
		for (int i = 0; i < texts.size(); i ++)
		{
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, defSize.width, defSize.height);
			g.setColor(Color.BLACK);
			g.drawOval(0, 0, defSize.width - 1, defSize.height - 1);
			if (texts.elementAt(i).length() > maxLength)
			{
				g.drawString(texts.elementAt(i).substring(0, maxLength) + "...",
						3, (int) (0 + (i + 0.8) * defSize.getHeight()));
			}
			else
			{
				g.drawString(texts.elementAt(i), (int) (defSize.width * 0.2),
						(int) (defSize.getHeight()) / 2);
			}
		}
		setPort();
		if (isSelect == true)
		{
			paintSelect(g);
		}
	}

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

	@Override
	public void reSize()
	{
		switch (texts.size())
		{
			case 0:
				this.setSize(defSize);
				break;
			default:
				this.setSize(defSize.width, defSize.height);
				break;
		}
	}

	@Override
	public void setText(String text)
	{
		texts.clear();
		texts.add(text);
		this.repaint();
	}

	@Override
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
//		System.out.println("Basic Class set selected side");
		for(int i = 0; i < ports.length; i++) {
//			System.out.print(i);
//			System.out.print(", ");
//			System.out.print(ports[i]);
//			System.out.print(", ");
//			System.out.print(p);
//			System.out.print(", ");
//			System.out.println(ports[i].contains(p));
			if (ports[i].contains(p)) {
				selectedPortPoint = point;	
			}			
		}
	}
}
