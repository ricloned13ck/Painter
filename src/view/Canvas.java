package view;

import model.AbstractModel;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    public Canvas() {
        super(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        AbstractModel.getInstance().draw(graphics);
    }

}
