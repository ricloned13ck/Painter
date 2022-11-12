package controller;

import com.sun.tools.javac.Main;
import controller.mouse.OnEllipseListener;
import controller.mouse.OnRectListener;
import controller.mouse.StatedMouseListener;
import model.AbstractFigure;
import model.AbstractModel;
import model.svg.SvgEllipse;
import model.svg.SvgModel;
import model.svg.SvgRect;
import view.Canvas;
import view.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public abstract class Application {
    private static State state;
    private static HashMap<State, StatedMouseListener> statedMouseListeners;
    private static MainWindow mainWindow;


    public static State getState() {
        return state;
    }

    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    public static void setState(State state) {
        if (statedMouseListeners.containsKey(Application.state)) {
            Application.getCanvas().removeMouseListener(statedMouseListeners.get(Application.state));
            Application.getCanvas().removeMouseMotionListener(statedMouseListeners.get(Application.state));
        }
        Application.state = state;
        if (statedMouseListeners.containsKey(Application.state)) {
            Application.getCanvas().addMouseListener(statedMouseListeners.get(Application.state));
            Application.getCanvas().addMouseMotionListener(statedMouseListeners.get(Application.state));
        }
    }

    private static Canvas canvas;

    public static Canvas getCanvas() {
        return canvas;
    }

    public static void run() {
        SvgModel.use();
        statedMouseListeners = new HashMap<>();
        statedMouseListeners.put(State.RECT, new OnRectListener());
        statedMouseListeners.put(State.ELLIPSE, new OnEllipseListener());
        canvas = new Canvas();
        canvas.addComponentListener(new CanvasResizeListener());
        Application.setState(State.RECT);
        mainWindow = new MainWindow();
        AbstractModel.getInstance().setSize(canvas.getSize());
        AbstractModel.getInstance().setBackgroundColor(Color.WHITE);
        mainWindow.setVisible(true);
    }

    public static void save() {
        System.out.println();
        if (SvgModel.isNeedSave) {
            int result = JOptionPane.showConfirmDialog(mainWindow, "Сохранить изменения?", "Новый файл", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                AbstractModel.getInstance().save("untitled.svg");
            }
        }
    }

    public static void saveWithoutModal() {
        AbstractModel.getInstance().save("untitled.svg");
    }

    public static void saveAs() throws IOException {
        String m = JOptionPane.showInputDialog(mainWindow, "Введите имя файла без .txt", "Сохранить как", JOptionPane.INFORMATION_MESSAGE);
        File f = new File(m + ".svg");

        File file = new File(m + ".svg");
        if (isFileExists(file)) {
            int result = JOptionPane.showConfirmDialog(mainWindow, "Файл уже существует, заменить его?", "Файл существует", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                AbstractModel.getInstance().save(m + ".svg");
            }
        } else {
            AbstractModel.getInstance().save(m + ".svg");
        }
    }

    //todo: open
    public static void open() {
    }

    ;

    public static void exit() {
        save();
        System.exit(1);
    }

    public static void colorChoose() {
        String m = JOptionPane.showInputDialog(mainWindow, "Введите 1 - если хотите сменить цвет заливки\nВведите 2 - если хотите сменить цвет обводки", "Что меняем?", JOptionPane.INFORMATION_MESSAGE);
        if (Objects.equals(m, "1")) {
            SvgModel.fill = JColorChooser.showDialog(null, "Выберите цвет заливки", SvgModel.fill);
        }
        if (Objects.equals(m, "2")) {
            SvgModel.stroke = JColorChooser.showDialog(null, "Выберите цвет обводки", SvgModel.stroke);
        }
    }
}