package model;

import java.awt.*;

public abstract class AbstractFigure {
    private Color fill,stroke;
    private int strokeWidth;
    private boolean isNeedSave = false;

    public abstract void draw(Graphics g);

    public abstract String serialize();

    public Color getFill() {
        return fill;
    }

    public void setFill(Color fill) {
        this.fill = fill;
    }

    public Color getStroke() {
        return stroke;
    }

    public void setStroke(Color stroke) {
        this.stroke = stroke;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public boolean getNeedSave() {
        return isNeedSave;
    }

    public void setNeedSave(boolean needSave) {
        isNeedSave = needSave;
    }
}
