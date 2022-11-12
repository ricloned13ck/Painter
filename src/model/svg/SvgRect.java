package model.svg;

import model.AbstractFigure;

import java.awt.*;

public class SvgRect extends AbstractFigure {
    private int x, y, width, height;


    public SvgRect(int x, int y, int width, int height, Color fill, Color stroke, int strokeWidth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setFill(fill);
        this.setStroke(stroke);
        this.setStrokeWidth(strokeWidth);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(this.getFill());
        BasicStroke stroke = new BasicStroke(this.getStrokeWidth());
        g2.setStroke(stroke);
        g2.fillRect(this.x, this.y, this.width, this.height);
        g2.setPaint(this.getStroke());
        g2.drawRect(this.x, this.y, this.width, this.height);
    }

    @Override
    public String serialize() {
        StringBuilder builder = new StringBuilder();
        builder.append("<rect");
        builder.append(" id=\"").append(hashCode()).append("\"");
        builder.append(" x=\"").append(getX()).append("\"");
        builder.append(" y=\"").append(getY()).append("\"");
        builder.append(" width=\"").append(getWidth()).append("\"");
        builder.append(" height=\"").append(getHeight()).append("\"");
        builder.append(" fill=\"").append(SvgModel.colorToHex(getFill())).append("\"");
        builder.append(" stroke=\"").append(SvgModel.colorToHex(getStroke())).append("\"");
        builder.append(" fill-opacity=\"").append(SvgModel.colorOpacity(getFill())).append("\"");
        builder.append(" stroke-opacity=\"").append(SvgModel.colorOpacity(getStroke())).append("\"");
        builder.append(" stroke-width=\"").append(getStrokeWidth()).append("\"");
        builder.append(" />\n");
        return builder.toString();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
