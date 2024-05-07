package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;

public class BmpPrinter {

    public void print(ArgumentsParser arguments) throws Exception {
        BufferedImage image = ImageIO.read(arguments.getPath().toFile());

        for (int y = 0; y < image.getHeight(); ++y) {
            for (int x = 0; x < image.getWidth(); ++x) {
                if (image.getRGB(x, y) == Color.BLACK.getRGB()) {
                    System.out.print(arguments.getBlack());
                } else if (image.getRGB(x, y) == Color.WHITE.getRGB()) {
                    System.out.print(arguments.getWhite());
                }
            }
            System.out.println();
        }
    }

}
