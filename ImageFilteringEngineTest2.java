
import static org.junit.Assert.assertEquals;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;

public class ImageFilteringEngineTest2 {
  
  // Test applying GrayLevelFilter to a white rectangle
  @Test
  public void testGrayLevelFilterWhiteRectangle() throws Exception {
    // Create the input image
    BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < img.getWidth(); i++) {
      for (int j = 0; j < img.getHeight(); j++) {
        img.setRGB(i, j, Color.WHITE.getRGB());
      }
    }
    // Create the expected output image
    BufferedImage expectedImg = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < img.getWidth(); i++) {
      for (int j = 0; j < img.getHeight(); j++) {
        expectedImg.setRGB(i, j, Color.WHITE.getRGB());
      }
    }
    // Apply the filter and compare output to expected image
    SingleThreadedImageFilteringEngine engine = new SingleThreadedImageFilteringEngine();
    engine.setImg(img);
    engine.applyFilter(new GrayLevelFilter());
    BufferedImage outputImg = engine.getImg();
    for (int i = 0; i < img.getWidth(); i++) {
      for (int j = 0; j < img.getHeight(); j++) {
        assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
      }
    }
  }

  
//Test applying GrayLevelFilter to a white rectangle
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
   SingleThreadedImageFilteringEngine engine = new SingleThreadedImageFilteringEngine();
   engine.setImg(img);
   engine.applyFilter(new GrayLevelFilter());
   BufferedImage outputImg = engine.getImg();
   for (int i = 0; i < img.getWidth(); i++) {
     for (int j = 0; j < img.getHeight(); j++) {
       assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
     }
   }
 }
 
//Test applying GrayLevelFilter to a white rectangle
@Test
public void testGrayLevelFilterRedRectangle() throws Exception {
  // Create the input image
  BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
  for (int i = 0; i < img.getWidth(); i++) {
    for (int j = 0; j < img.getHeight(); j++) {
      img.setRGB(i, j, new Color(255, 0, 0).getRGB());
    }
  }
  // Create the expected output image
  BufferedImage expectedImg = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
  for (int i = 0; i < img.getWidth(); i++) {
    for (int j = 0; j < img.getHeight(); j++) {
    	
	    expectedImg.setRGB(i, j, new Color(85, 85, 85).getRGB());
    }
  }
  // Apply the filter and compare output to expected image
  SingleThreadedImageFilteringEngine engine = new SingleThreadedImageFilteringEngine();
  engine.setImg(img);
  engine.applyFilter(new GrayLevelFilter());
  BufferedImage outputImg = engine.getImg();
  for (int i = 0; i < img.getWidth(); i++) {
    for (int j = 0; j < img.getHeight(); j++) {
      assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
    }
  }
}

//Test applying GrayLevelFilter to a white rectangle
@Test
public void testGrayLevelFilterGreenRectangle() throws Exception {
 // Create the input image
 BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
 for (int i = 0; i < img.getWidth(); i++) {
   for (int j = 0; j < img.getHeight(); j++) {
     img.setRGB(i, j, new Color(0, 255, 0).getRGB());
   }
 }
 // Create the expected output image
 BufferedImage expectedImg = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
 for (int i = 0; i < img.getWidth(); i++) {
   for (int j = 0; j < img.getHeight(); j++) {
	   
	    expectedImg.setRGB(i, j, new Color(85, 85, 85).getRGB());
   }
 }
 // Apply the filter and compare output to expected image
 SingleThreadedImageFilteringEngine engine = new SingleThreadedImageFilteringEngine();
 engine.setImg(img);
 engine.applyFilter(new GrayLevelFilter());
 BufferedImage outputImg = engine.getImg();
 for (int i = 0; i < img.getWidth(); i++) {
   for (int j = 0; j < img.getHeight(); j++) {
     assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
   }
 }
}


//Test applying GrayLevelFilter to a white rectangle
@Test
public void testGrayLevelFilterBlueRectangle() throws Exception {
// Create the input image
BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
for (int i = 0; i < img.getWidth(); i++) {
 for (int j = 0; j < img.getHeight(); j++) {
   img.setRGB(i, j, Color.BLUE.getRGB());
 }
}
// Create the expected output image
BufferedImage expectedImg = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
for (int i = 0; i < img.getWidth(); i++) {
 for (int j = 0; j < img.getHeight(); j++) {
	 
	    expectedImg.setRGB(i, j, new Color(85, 85, 85).getRGB());
 }
}

// Apply the filter and compare output to expected image
SingleThreadedImageFilteringEngine engine = new SingleThreadedImageFilteringEngine();
engine.setImg(img);
engine.applyFilter(new GrayLevelFilter());
BufferedImage outputImg = engine.getImg();
for (int i = 0; i < img.getWidth(); i++) {
 for (int j = 0; j < img.getHeight(); j++) {
   assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
 }
}
}
  
  // Test applying GaussianContourExtractorFilter to FourCircles.png
  @Test
  public void testGrayLevelFilterFourCircles() throws Exception {
    // Load the input image
    BufferedImage img = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/FourCircles.png"));
    // Load the expected output image
    BufferedImage expectedImg = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/FourCircles_gray.png"));
    // Apply the filter and compare output to expected image
    SingleThreadedImageFilteringEngine engine = new SingleThreadedImageFilteringEngine();
    engine.setImg(img);
    engine.applyFilter(new GrayLevelFilter());
    //engine.applyFilter(new GaussianContourExtractorFilter());
    BufferedImage outputImg = engine.getImg();
    for (int i = 0; i < img.getWidth(); i++) {
      for (int j = 0; j < img.getHeight(); j++) {
        assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
      }
    }
  }
  
//Test applying GaussianContourExtractorFilter to FourCircles.png
 @Test
 public void testGaussianContourExtractorFilterFourCircles() throws Exception {
   // Load the input image
   BufferedImage img = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/FourCircles.png"));
   // Load the expected output image
   BufferedImage expectedImg = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/FourCircles_gaussian_contour.png"));
   // Apply the filter and compare output to expected image
   SingleThreadedImageFilteringEngine engine = new SingleThreadedImageFilteringEngine();
   engine.setImg(img);
   engine.applyFilter(new GrayLevelFilter());
   engine.applyFilter(new GaussianContourExtractorFilter());
// writing out new image
   BufferedImage outputImg = engine.getImg();
   File f = new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/tmp1.png");
   ImageIO.write(outputImg, "png", f);
   for (int i = 0; i < img.getWidth(); i++) {
     for (int j = 0; j < img.getHeight(); j++) {
       assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
     }
   }
 }
 
//Test applying GaussianContourExtractorFilter to FourCircles.png
 @Test
 public void testGrayLevelFiltera_c() throws Exception {
   // Load the input image
   BufferedImage img = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/15226222451_5fd668d81a_c.jpg"));
   // Load the expected output image
   BufferedImage expectedImg = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/15226222451_5fd668d81a_c_gray.png"));
   // Apply the filter and compare output to expected image
   SingleThreadedImageFilteringEngine engine = new SingleThreadedImageFilteringEngine();
   engine.setImg(img);
   engine.applyFilter(new GrayLevelFilter());
   //engine.applyFilter(new GaussianContourExtractorFilter());
   BufferedImage outputImg = engine.getImg();
   for (int i = 0; i < img.getWidth(); i++) {
     for (int j = 0; j < img.getHeight(); j++) {
       assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
     }
   }
 }

//Test applying GaussianContourExtractorFilter to FourCircles.png
@Test
public void testGaussianContourExtractorFiltera_c() throws Exception {
	SingleThreadedImageFilteringEngine engine = new SingleThreadedImageFilteringEngine();
 // Load the input image
	engine.loadImage("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/15226222451_5fd668d81a_c.jpg");
 BufferedImage img = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/15226222451_5fd668d81a_c.jpg"));
 // Load the expected output image
 BufferedImage expectedImg = ImageIO.read(new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/15226222451_5fd668d81a_c_gaussian_contour.png"));
 // Apply the filter and compare output to expected image
 engine.setImg(img);
 engine.applyFilter(new GrayLevelFilter());
 engine.applyFilter(new GaussianContourExtractorFilter());
 BufferedImage outputImg = engine.getImg();
 File f = new File("/home/istic/Documents/Projet_en_cours/SPP/Lab_3_4_LabFiles_2023/Lab_3_4_LabFiles_2023/TEST_IMAGES/tmp2.png");
 ImageIO.write(outputImg, "png", f);
 for (int i = 0; i < img.getWidth(); i++) {
   for (int j = 0; j < img.getHeight(); j++) {
     assertEquals(expectedImg.getRGB(i, j), outputImg.getRGB(i, j));
   }
 }
}
  
  // Add more tests for the other images and filters...
  
}