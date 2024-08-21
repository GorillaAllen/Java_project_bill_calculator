package bill_calculator;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class RoundButton extends JButton {
    private static final long serialVersionUID = 1L;

    public RoundButton() {
//        super(label);
        setContentAreaFilled(false);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fill(new Ellipse2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No border
    }

    @Override
    public boolean contains(int x, int y) {
        return new Ellipse2D.Double(0, 0, getWidth(), getHeight()).contains(x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }
}