import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import javax.imageio.ImageIO;

public class MultiThreadedImageFilteringEngine implements IImageFilteringEngine {
    private final int numThreads;
    private final Thread[] workerThreads;
    private final CyclicBarrier barrier;

    private BufferedImage outputImg;
    private BufferedImage inputImg;

    private class FilterWorker implements Runnable {
        private int startX, endX, startY, endY;
        private final IFilter filter;

        public FilterWorker(IFilter filter) {
            this.filter = filter;
        }

        public void setRange(int startX, int endX, int startY, int endY) {
            this.startX = startX;
            this.endX = endX;
            this.startY = startY;
            this.endY = endY;
        }

        @Override
        public void run() {
            try {
                // Wait for all worker threads to be ready
                barrier.await();

                // Apply the filter to each pixel in the assigned range
                for (int x = startX; x < endX; x++) {
                    for (int y = startY; y < endY; y++) {
                        filter.applyFilterAtPoint(x, y, inputImg, outputImg);
                    }
                }

                // Wait for all worker threads to finish
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                // Exit early if thread is interrupted
                Thread.currentThread().interrupt();
            }
        }
    }


    public MultiThreadedImageFilteringEngine(int numThreads) {
        this.numThreads = numThreads;
        this.workerThreads = new Thread[numThreads];
        this.barrier = new CyclicBarrier(numThreads + 1);
    }

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

        // Divide image into horizontal strips for each worker thread
        int stripHeight = (inputImg.getHeight() - 2 * margin) / numThreads;
        int remainingHeight = (inputImg.getHeight() - 2 * margin) % numThreads;
        int currentY = margin;

        for (int i = 0; i < numThreads; i++) {
            int startY = currentY;
            int endY = currentY + stripHeight;

            if (i == numThreads - 1) {
                // Last worker thread gets remaining height
                endY += remainingHeight;
            }

            // Create and start worker thread
            FilterWorker worker = new FilterWorker(someFilter);
            worker.setRange(margin, inputImg.getWidth() - margin, startY, endY);
            workerThreads[i] = new Thread(worker);
            workerThreads[i].start();

            currentY = endY;
        }

        try {
            // Wait for worker threads to be ready
            barrier.await();

            // Wait for worker threads to finish
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            // Exit early if main thread is interrupted
            Thread.currentThread().interrupt();
        }

    }

    public void close() {
        // Interrupt all worker threads to exit gracefully
        for (Thread thread : workerThreads) {
            thread.interrupt();
        }
    } 
}
