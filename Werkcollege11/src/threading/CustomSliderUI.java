package threading;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class CustomSliderUI extends BasicSliderUI {

	
	
    public CustomSliderUI(JSlider b) {
        super(b);
    }


    public Dimension getThumbSize()
    {
    	return new Dimension(25,25);
    }
    
    
    @Override
    public void paintThumb(Graphics g)  {         

    	Image image= null;
		try {
			image = ImageIO.read( new File("horse.jpg") );
		} catch (IOException e) {
			e.printStackTrace();
		}
        g.drawImage(image, thumbRect.x, thumbRect.y, 25, 25, null );

    }

    public static Image makeColorTransparent(BufferedImage im, final Color color) {
        ImageFilter filter = new RGBImageFilter() {

            // the color we are looking for... Alpha bits are set to opaque
            public int markerRGB = color.getRGB() | 0xFF000000;

            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JSlider slider = new JSlider(0, 100);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(25);
        slider.setUI(new CustomSliderUI(slider));
        frame.add(slider);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}