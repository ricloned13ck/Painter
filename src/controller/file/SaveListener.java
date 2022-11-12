package controller.file;

import controller.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Application.saveWithoutModal();
    }
}
