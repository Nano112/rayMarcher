package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image
{
    private int width;
    private int height;
    private BufferedImage image;

    public Image(int width, int height)
    {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = 0x000000;
                this.image.setRGB(x, y, rgb);
            }
        }
    }
    public void setPixel(int x, int y, Color color)
    {
        this.image.setRGB(x, y, color.rgbToHex());

    }

    public void save(String name) throws IOException
    {
        File tmpDir = new File("outputFrames");
        boolean exists = tmpDir.exists();
        if (!exists)
        {
            File dir = new File("outputFrames");
            dir.mkdir();
        }

        File outputFile = new File("outputFrames/"+name+".bmp");
        ImageIO.write(this.image, "bmp", outputFile);
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public void setImage(BufferedImage image)
    {
        this.image = image;
    }
}
