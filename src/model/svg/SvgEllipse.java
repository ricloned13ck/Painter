package model.svg;

import model.AbstractFigure;

import java.awt.*;

public class SvgEllipse extends AbstractFigure {
    private int cx, cy;
    private int rx, ry;

    public SvgEllipse(int cx, int cy, int rx, int ry, Color fill, Color stroke, int strokeWidth) {
        this.cx = cx;
        this.cy = cy;
        this.rx = rx;
        this.ry = ry;
        setFill(fill);
        setStroke(stroke);
        setStrokeWidth(strokeWidth);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(this.getFill());
        BasicStroke stroke = new BasicStroke(this.getStrokeWidth());
        g2.setStroke(stroke);
        g2.fillOval(
                this.cx - this.rx,
                this.cy - this.ry,
                this.rx * 2,
                this.ry * 2
        );
        g2.setPaint(this.getStroke());
        g2.drawOval(
                this.cx - this.rx,
                this.cy - this.ry,
                this.rx * 2,
                this.ry * 2
        );
    }

    @Override
    public String serialize() {
        StringBuilder builder = new StringBuilder();
        builder.append("<ellipse");
        builder.append(" id=\"").append(hashCode()).append("\"");
        builder.append(" cx=\"").append(getCx()).append("\"");
        builder.append(" cy=\"").append(getCy()).append("\"");
        builder.append(" rx=\"").append(getRx()).append("\"");
        builder.append(" ry=\"").append(getRy()).append("\"");
        builder.append(" fill=\"").append(SvgModel.colorToHex(getFill())).append("\"");
        builder.append(" stroke=\"").append(SvgModel.colorToHex(getStroke())).append("\"");
        builder.append(" fill-opacity=\"").append(SvgModel.colorOpacity(getFill())).append("\"");
        builder.append(" stroke-opacity=\"").append(SvgModel.colorOpacity(getStroke())).append("\"");
        builder.append(" stroke-width=\"").append(getStrokeWidth()).append("\"");
        builder.append(" />\n");
        return builder.toString();
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public int getRx() {
        return rx;
    }

    public void setRx(int rx) {
        this.rx = rx;
    }

    public int getRy() {
        return ry;
    }

    public void setRy(int ry) {
        this.ry = ry;
    }


}
