package controller;

import model.AbstractModel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CanvasResizeListener extends ComponentAdapter {
    @Override
    public void componentResized(ComponentEvent e) {
        AbstractModel.getInstance().setSize(Application.getCanvas().getSize());
        super.componentResized(e);
        System.out.println(AbstractModel.getInstance().getSize().width);
    }
}
