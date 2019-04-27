/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcam;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 *
 * @author giscard
 */
public class WebCam {

  
    public static void main(String[] args) throws IOException {
    Webcam webcam = Webcam.getDefault();
    webcam.setViewSize(WebcamResolution.VGA.getSize());
    webcam.open();
    
    JFrame window = new JFrame();
     
    WebcamPanel panel=new WebcamPanel(webcam);
    //panel.setFPSDisplayed(true);
    //panel.setDisplayDebugInfo(true);
    panel.setImageSizeDisplayed(true);
    
    panel.setMirrored(true);
    
    
    		JButton button = new JButton(new AbstractAction("capture") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					ImageIO.write(webcam.getImage(), "PNG", new File("capture.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
                
   
    window.setLayout(new FlowLayout(FlowLayout.CENTER));
    window.add(panel);
    window.add(button);
    window.setResizable(true);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
    
    
    }
    
}
