import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class SingleThreadedImageFilteringEngine implements IImageFilteringEngine {

    private BufferedImage outputImg;
    private BufferedImage inputImg;

    @Override
    public void loadImage(String inputImage) throws Exception {
        // Load the input image from a file
        File inputFile = new File(inputImage);
        if (!inputFile.exists()) {
            throw new Exception("Input file does not exist.");
        }
        inputImg = ImageIO.read(inputFile);
    }

    @Override
    public void writeOutPngImage(String outFile) throws Exception {
        // Save the output image to a file in PNG format 
        File outputFile = new File(outFile);
        ImageIO.write(outputImg, "png", outputFile);
    }

    @Override
    public void setImg(BufferedImage newImg) {
        // Set the input image to a new image.
        inputImg = newImg;
    }

    @Override
    public BufferedImage getImg() {
        // Return the output image
        return outputImg;
    }

    @Override
    public void applyFilter(IFilter someFilter) {
        // Get the margin of the filter
        int margin = someFilter.getMargin();

        // Create a new image for the output
        int w = inputImg.getWidth() - 2 * margin;
        int h = inputImg.getHeight() - 2 * margin;
        outputImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        // Apply the filter to each pixel of the output image
        for (int x = margin; x < inputImg.getWidth() - margin; x++) {
            for (int y = margin; y < inputImg.getHeight() - margin; y++) {
                someFilter.applyFilterAtPoint(x, y, inputImg, outputImg);
            }
        }
    } 
}
