import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.junit.Test;

public class MultiThreadedImageFilteringEngineTest {
    @Test
    public void testGrayLevelFilterBlackRectangle() throws Exception {
        // Create the input image
        BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                img.setRGB(i, j, Color.BLACK.getRGB());
            }
        }
    
        // Create the expected output image
        BufferedImage expectedImg = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                expectedImg.setRGB(i, j, Color.BLACK.getRGB());
            }
        }
    
        // Apply the filter and compare output to expected image
        MultiThreadedImageFilteringEngine engine = new MultiThreadedImageFilteringEngine(18);
        engine.setImg(img);
        engine.applyFilter(new GrayLevelFilter());
        BufferedImage outputImg = engine.getImg();
    
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
            }
        }
    }
}
