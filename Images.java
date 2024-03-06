package galeria;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {

    private String paths[] = {"1.png", "2.png", "3.png", "4.png", "5.png",
        "1a.png", "2a.png", "3a.png", "4a.png", "5a.png",
        "1b.png", "2b.png", "3b.png", "4b.png", "5b.png",
        "1c.png", "2c.png", "3c.png", "4c.png", "5c.png"};

    private ImageIcon imgs[];
    //TODO: Mire mijo lo que tiene que hacer es cliquear derecho a cualquie imagen de su carpeta -> propiedades
    //y de ahi sacar la ruta
    //y pegarla aca, sustituyendo \ por \\ o puede probar suerte y eliminar fullPath antes de + paths[i]
    private String fullPath = "/home/ruben/NetBeansProjects/Galeria/src/galeria/";

    private int index = 0;

    public Images() {
        imgs = new ImageIcon[20];
        for (int i = 0; i < 20; i++) {
            try {
                Image img = ImageIO.read(new File(fullPath + paths[i]));
                imgs[i] = new ImageIcon(img.getScaledInstance(300, 300, Image.SCALE_SMOOTH));
            } catch (IOException e) {
                System.out.println("Fallo" + paths[i]);
            }
        }
    }

    public ImageIcon back() {
        if (index == 0) {
            return imgs[0];
        }
        return imgs[--index];
    }

    public ImageIcon next() {
        if (index == imgs.length - 1) {
            return imgs[imgs.length - 1];
        }
        return imgs[++index];
    }

    public ImageIcon start() {
        return imgs[index];
    }
}
