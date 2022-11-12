package model;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractModel extends ArrayList<AbstractFigure> {
    protected static AbstractModel instance = null;

    protected static void setInstance(AbstractModel instance) {
        AbstractModel.instance = instance;
    }

    public static AbstractModel getInstance() {
        return instance;
    }

    private Dimension size;
    private Color backgroundColor;

    public abstract void save(String filename);

    public abstract void open(String filename);

    public void draw(Graphics g) {
        g.setColor(getBackgroundColor());
        g.fillRect(0, 0, getSize().width, getSize().height);
        for (AbstractFigure figure : this){
            figure.draw(g);
        }
    }


    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

}
