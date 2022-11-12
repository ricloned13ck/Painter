package controller.tools;

import controller.Application;
import controller.State;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetRectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Application.setState(State.RECT);
    }
}
