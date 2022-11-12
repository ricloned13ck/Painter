package controller.mouse;

import controller.Application;
import controller.State;
import model.AbstractModel;
import model.svg.SvgModel;
import model.svg.SvgRect;

import java.awt.*;
import java.awt.event.MouseEvent;

import static model.svg.SvgModel.fill;
import static model.svg.SvgModel.stroke;

public class OnRectListener implements StatedMouseListener {
    private SvgRect rect;
    private int x, y;

    private void updateRect(MouseEvent e) {
        int x1 = this.x, x2 = e.getX();
        int y1 = this.y, y2 = e.getY();

        int x = Math.min(x1, x2);
        int w = Math.abs(x1 - x2);
        int y = Math.min(y1, y2);
        int h = Math.abs(y1 - y2);

        rect.setX(x);
        rect.setY(y);
        rect.setWidth(w);
        rect.setHeight(h);

        Application.getCanvas().repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Application.getState() != State.RECT)
            return;
        if (e.getButton() != MouseEvent.BUTTON1)
            return;
        x = e.getX();
        y = e.getY();
        rect = new SvgRect(
                e.getX(),
                e.getY(),
                0,
                0,
                fill,
                stroke,
                3
        );
        AbstractModel.getInstance().add(rect);
        SvgModel.isNeedSave = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Application.getState() != State.RECT)
            return;
        if (e.getButton() != MouseEvent.BUTTON1)
            return;
        updateRect(e);
        rect = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (rect == null)
            return;
        updateRect(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
