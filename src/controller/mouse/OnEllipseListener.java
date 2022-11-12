package controller.mouse;

import controller.Application;
import controller.State;
import model.AbstractModel;
import model.svg.SvgEllipse;
import model.svg.SvgModel;
import model.svg.SvgRect;

import java.awt.*;
import java.awt.event.MouseEvent;

import static model.svg.SvgModel.fill;
import static model.svg.SvgModel.stroke;

public class OnEllipseListener implements StatedMouseListener {
    private SvgEllipse ellipse;
    private int cx, cy;

    private void updateEllipse(MouseEvent e) {
        int rx = Math.abs(cx - e.getX());
        int ry = Math.abs(cy - e.getY());
        ellipse.setRx(rx);
        ellipse.setRy(ry);
        Application.getCanvas().repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Application.getState() != State.ELLIPSE)
            return;
        if (e.getButton() != MouseEvent.BUTTON1)
            return;
        cx = e.getX();
        cy = e.getY();
        ellipse = new SvgEllipse(
                cx,
                cy,
                0,
                0,
                fill,
                stroke,
                3
        );
        AbstractModel.getInstance().add(ellipse);
        SvgModel.isNeedSave = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Application.getState() != State.ELLIPSE)
            return;
        if (e.getButton() != MouseEvent.BUTTON1)
            return;
        updateEllipse(e);
        ellipse = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (ellipse == null)
            return;
        updateEllipse(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
