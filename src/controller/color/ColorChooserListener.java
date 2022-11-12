package controller.color;

import controller.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Application.colorChoose();
    }
}
