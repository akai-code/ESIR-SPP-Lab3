import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

public class ImageFilteringEngineTest {

    private IImageFilteringEngine filterEngine;

    @Before
    public void setUp() throws Exception {
        // Replace this with your implementation class
        filterEngine = new SingleThreadedImageFilteringEngine();
    }

    @Test
    public void testGrayLevelFilter1() throws Exception {
        // Load the white rectangle image
        BufferedImage inputImage = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/FourCircles.png"));

        // Apply the gray level filter
        filterEngine.setImg(inputImage);
        filterEngine.applyFilter(new GrayLevelFilter());
        BufferedImage outputImage = filterEngine.getImg();

        // Load the expected output image
        BufferedImage expectedImage = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/FourCircles_gray.png"));

        // Compare the output image with the expected image
        assertEquals(expectedImage.getWidth(), outputImage.getWidth());
        assertEquals(expectedImage.getHeight(), outputImage.getHeight());
        for (int y = 0; y < expectedImage.getHeight(); y++) {
            for (int x = 0; x < expectedImage.getWidth(); x++) {
                int expectedRGB = expectedImage.getRGB(x, y);
                int outputRGB = outputImage.getRGB(x, y);
                assertEquals(expectedRGB, outputRGB);
            }
        }
    }

    @Test
    public void testGaussianContourExtractorFilter1() throws IOException {
        // Load the FourCircles_Gray.png
        BufferedImage inputImage = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/FourCircles.png"));

        // Apply the GaussianContourExtractorFilter
        filterEngine.setImg(inputImage);
        filterEngine.applyFilter(new GaussianContourExtractorFilter());
        BufferedImage outputImage = filterEngine.getImg();

        // Load the expected output image
        BufferedImage expectedImage = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/FourCircles_gaussian_contour.png"));

        // Compare the output image with the expected image
        assertEquals(expectedImage.getWidth(), outputImage.getWidth());
        assertEquals(expectedImage.getHeight(), outputImage.getHeight());
        for (int y = 0; y < expectedImage.getHeight(); y++) {
            for (int x = 0; x < expectedImage.getWidth(); x++) {
                int expectedRGB = expectedImage.getRGB(x, y);
                int outputRGB = outputImage.getRGB(x, y);
                assertEquals(expectedRGB, outputRGB);
            }
        }
    }

    @Test
    public void testGrayLevelFilter2() throws Exception {
        // Load the 15226222451_5fd668d81a_c.jpg
        BufferedImage inputImage = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/15226222451_5fd668d81a_c.jpg"));

        // Apply the gray level filter
        filterEngine.setImg(inputImage);
        filterEngine.applyFilter(new GrayLevelFilter());
        BufferedImage outputImage = filterEngine.getImg();

        // Load the expected output image
        BufferedImage expectedImage = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/15226222451_5fd668d81a_c_gray.png"));

        // Compare the output image with the expected image
        assertEquals(expectedImage.getWidth(), outputImage.getWidth());
        assertEquals(expectedImage.getHeight(), outputImage.getHeight());
        for (int y = 0; y < expectedImage.getHeight(); y++) {
            for (int x = 0; x < expectedImage.getWidth(); x++) {
                int expectedRGB = expectedImage.getRGB(x, y);
                int outputRGB = outputImage.getRGB(x, y);
                assertEquals(expectedRGB, outputRGB);
            }
        }
    }

    @Test
    public void testGaussianContourExtractorFilter2() throws IOException {
        // Load the 15226222451_5fd668d81a_c_Gray.png
        BufferedImage inputImage = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/15226222451_5fd668d81a_c.png"));

        // Apply the GaussianContourExtractorFilter
        filterEngine.setImg(inputImage);
        filterEngine.applyFilter(new GaussianContourExtractorFilter());
        BufferedImage outputImage = filterEngine.getImg();

        // Load the expected output image
        BufferedImage expectedImage = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/15226222451_5fd668d81a_c_gaussian_contour.png"));

        // Compare the output image with the expected image
        assertEquals(expectedImage.getWidth(), outputImage.getWidth());
        assertEquals(expectedImage.getHeight(), outputImage.getHeight());
        for (int y = 0; y < expectedImage.getHeight(); y++) {
            for (int x = 0; x < expectedImage.getWidth(); x++) {
                int expectedRGB = expectedImage.getRGB(x, y);
                int outputRGB = outputImage.getRGB(x, y);
                assertEquals(expectedRGB, outputRGB);
            }
        }
    }


}
