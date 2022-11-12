package view;

import controller.Application;
import controller.color.ColorChooserListener;
import controller.file.ExitListener;
import controller.file.OpenListener;
import controller.file.SaveAsListener;
import controller.file.SaveListener;
import controller.tools.SetCursorListener;
import controller.tools.SetEllipseListener;
import controller.tools.SetRectListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException {
        super();

        setTitle("Painter v0.1");
        addWindowListener(new ExitListener());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = new Dimension(
                screenSize.width / 2,
                screenSize.height / 2
        );
        Point windowLocation = new Point(
                screenSize.width / 4,
                screenSize.height / 4
        );
        setSize(windowSize);
        setLocation(windowLocation);

        setLayout(new BorderLayout());
        add(Application.getCanvas(), BorderLayout.CENTER);

        setJMenuBar(new JMenuBar());

        initFileMenu();
        initToolBar();
    }

    public void initFileMenu(){
        JMenu menu = new JMenu("Файл");

        JMenuItem open = new JMenuItem("Открыть");
        open.addActionListener(new OpenListener());
        menu.add(open);


        JMenuItem save = new JMenuItem("Сохранить");
        save.addActionListener(new SaveListener());
        menu.add(save);


        JMenuItem saveAs = new JMenuItem("Сохранить как");
        saveAs.addActionListener(new SaveAsListener());
        menu.add(saveAs);

        menu.addSeparator();

        JMenuItem exit = new JMenuItem("Выйти");
        exit.addActionListener(new ExitListener());
        menu.add(exit);

        getJMenuBar().setBorder(BorderFactory.createEmptyBorder(0, 28, 0, 0));
        getJMenuBar().add(menu);
    }

    public void initToolBar() {
        JToolBar toolBar = new JToolBar();

        String icons[] = {"cursor", "rect", "ellipse"};
        ActionListener listeners[] = {
                new SetCursorListener(),
                new SetRectListener(),
                new SetEllipseListener()
        };

        for (int i = 0; i < icons.length; ++i) {
            BufferedImage icon = null;
            try {
                icon = ImageIO.read(
                        getClass().getResource("/icons/" + icons[i] + ".png")
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            JButton btn = new JButton(new ImageIcon(icon.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
            btn.addActionListener(listeners[i]);
            btn.setPreferredSize(new Dimension(24, 24));
            btn.setMargin(new Insets(0, 0, 0, 0));
            toolBar.add(btn);
        }
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(
                    getClass().getResource("/icons/colorChooser.png")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JButton btn = new JButton(new ImageIcon(icon.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        btn.addActionListener(new ColorChooserListener());
        btn.setPreferredSize(new Dimension(24, 24));
        btn.setMargin(new Insets(0, 0, 0, 0));
        toolBar.add(btn);

        toolBar.setOrientation(SwingConstants.VERTICAL);
        add(toolBar, BorderLayout.WEST);
    }
}
