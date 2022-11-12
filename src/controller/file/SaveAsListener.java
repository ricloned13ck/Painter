package controller.file;

import controller.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveAsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Application.saveAs();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
