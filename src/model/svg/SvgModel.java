package model.svg;

import model.AbstractFigure;
import model.AbstractModel;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SvgModel extends AbstractModel {
    public static Color fill,stroke;
    public static boolean isNeedSave;
    public static String colorToHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
    public static void use() {
        AbstractModel.setInstance(new SvgModel());
        fill = new Color(255, 0, 0, 127);
        stroke = new Color(20, 0, 255, 127);
        isNeedSave = false;
    }

    public static double colorOpacity(Color color) {
        return color.getAlpha() / 255.;
    }

    @Override
    public void save(String filename) {
        StringBuilder data = new StringBuilder();
        data.append("<?xml version=\"1.0\"?>\n");
        data.append("<!-- Created by students and KA in TOFMAL -->\n");
        data.append("<svg data-name=\"").append(hashCode()).append("\"").append(" xmlns=\"http://www.w3.org/2000/svg\"").append(" viewBox=\"0 0 ");
        data.append(AbstractModel.getInstance().getSize().getWidth()).append(" ");
        data.append(AbstractModel.getInstance().getSize().getHeight()).append("\"");
        data.append(" id=\"").append(AbstractModel.getInstance().hashCode()).append("\"");
        data.append(" >\n");
        for (AbstractFigure figure : this)
            data.append(figure.serialize());
        data.append("</svg>");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(data.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void open(String filename) {

    }
}
