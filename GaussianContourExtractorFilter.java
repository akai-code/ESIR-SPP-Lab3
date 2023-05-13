import java.awt.Color;
import java.awt.image.BufferedImage;

public class GaussianContourExtractorFilter implements IFilter {
    
    private static final double[][] GAUSSIAN_KERNEL = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}}; // Gaussian kernel
    
    private int margin; // Margin required for the filter
    
    public GaussianContourExtractorFilter() {
        this.margin = 1; // Margin required for the Gaussian kernel
    }
    
    public int getMargin() {
        return margin;
    }
    
    public void applyFilterAtPoint(int x, int y, BufferedImage imgIn, BufferedImage imgOut) {
        int width = imgIn.getWidth();
        int height = imgIn.getHeight();
        double gx = 0; // horizontal gradient
        double gy = 0; // vertical gradient
        
        // Compute horizontal gradient using the Gaussian kernel
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int pixelX = x + j;
                int pixelY = y + i;
                if (pixelX >= 0 && pixelX < width && pixelY >= 0 && pixelY < height) {
                    Color color = new Color(imgIn.getRGB(pixelX, pixelY));
                    double intensity = color.getBlue() / 255.0;
                    gx += intensity * GAUSSIAN_KERNEL[i + 1][j + 1];
                }
            }
        }
        
        // Compute vertical gradient using the Gaussian kernel
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int pixelX = x + j;
                int pixelY = y + i;
                if (pixelX >= 0 && pixelX < width && pixelY >= 0 && pixelY < height) {
                    Color color = new Color(imgIn.getRGB(pixelX, pixelY));
                    double intensity = color.getBlue() / 255.0;
                    gy += intensity * GAUSSIAN_KERNEL[j + 1][i + 1];
                }
            }
        }
        
        // Compute magnitude of gradient
        double gradient = Math.sqrt(gx * gx + gy * gy);
        
        // Set output pixel to black or white based on thresholding
        if (gradient > 0.1) { // adjust threshold as needed
            imgOut.setRGB(x - margin, y - margin, Color.BLACK.getRGB());
        } else {
            imgOut.setRGB(x - margin, y - margin, Color.WHITE.getRGB());
        }
    }
}
