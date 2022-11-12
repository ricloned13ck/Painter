package controller.file;

import controller.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Application.open();
    }
}
