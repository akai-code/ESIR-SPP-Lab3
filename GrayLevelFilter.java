import java.awt.image.BufferedImage;

public class GrayLevelFilter implements IFilter {

    @Override
    public int getMargin() {
        // GrayLevelFilter does not need any margin
        return 0;
    }

    @Override
    public void applyFilterAtPoint(int x, int y, BufferedImage imgIn, BufferedImage imgOut) {
        // Get the RGB values of the pixel in the input image
        int rgb = imgIn.getRGB(x, y);
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;

        // Calculate the average of the RGB values and set the output pixel to the gray level value
        int gray = (r + g + b) / 3;
        int grayPixel = (gray << 16) + (gray << 8) + gray;
        imgOut.setRGB(x, y, grayPixel);
    }   
}
