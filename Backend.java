package implementation;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Backend {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// Recuperer les images
		Mat c = Imgcodecs.imread("C:\\Users\\hp\\eclipse-workspace\\implementation\\images\\c1.jpeg");
		Mat p = Imgcodecs.imread("C:\\Users\\hp\\eclipse-workspace\\implementation\\images\\p1.jpeg");
		Mat n = Imgcodecs.imread("C:\\Users\\hp\\eclipse-workspace\\implementation\\images\\n1.jpeg");
		// Remove noise by blurring with a Gaussian filter ( kernel size = 3 )
        Imgproc.GaussianBlur( n, n, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT );
        Imgproc.GaussianBlur( p, p, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT );
        Imgproc.GaussianBlur( c, c, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT );
		// Montrer les images
		displayImage(Mat2BufferedImage(resize(p)));
		displayImage(Mat2BufferedImage(resize(c)));
		displayImage(Mat2BufferedImage(resize(n)));
		
		// Convertir au niveaux de gris
		Mat gc=rgb2gray(c), gp=rgb2gray(p), gn=rgb2gray(n);
		//displayImage(Mat2BufferedImage(resize(gp)));
		//displayImage(Mat2BufferedImage(resize(gc)));
		//displayImage(Mat2BufferedImage(resize(gn)));
		
		orkisz(gp, gc, gn);
		//vieren(gp, gc, gn);
	}
	*/
	
	
	/**************** méthodes  **********************************/
	public static Image[] vieren(String pathP, String pathC, String pathN) {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		long start = System.currentTimeMillis();
		

		
		// Recuperer les images
		Mat c = Imgcodecs.imread(pathC);
		Mat p = Imgcodecs.imread(pathP);
		Mat n = Imgcodecs.imread(pathN);
		// Remove noise by blurring with a Gaussian filter ( kernel size = 3 )
        Imgproc.GaussianBlur( n, n, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT );
        Imgproc.GaussianBlur( p, p, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT );
        Imgproc.GaussianBlur( c, c, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT );
		// Montrer les images
		// displayImage(Mat2BufferedImage(resize(p)));
		// displayImage(Mat2BufferedImage(resize(c)));
		// displayImage(Mat2BufferedImage(resize(n)));
		
		// Convertir au niveaux de gris
		Mat gc=rgb2gray(c), gp=rgb2gray(p), gn=rgb2gray(n);
		//displayImage(Mat2BufferedImage(resize(gp)));
		//displayImage(Mat2BufferedImage(resize(gc)));
		//displayImage(Mat2BufferedImage(resize(gn)));
		
		        Image[] resultas = new Image[6];
				// Calculer la difference
				Mat dcp = new Mat(), dnc = new Mat();
				Core.absdiff(gc, gp, dcp); Core.absdiff(gn, gc, dnc);
				
				resultas[0] = Mat2BufferedImage(resize(dcp));
				resultas[1] = Mat2BufferedImage(resize(dnc));
				
				// Recupere la magnitude de gradient de Sobel
				Sobel sob = new Sobel();
				dcp  = sob.run(resize(dcp));
				dnc  = sob.run(resize(dnc));
				
				resultas[2] = Mat2BufferedImage(resize(dcp));
				resultas[3] = Mat2BufferedImage(resize(dnc));
		        
				//Convert to double pour faire la miltiplication
				Mat  fdcp = new Mat(), fdnc = new Mat();
				dcp.convertTo(fdcp, CvType.CV_32F);
				dnc.convertTo(fdnc, CvType.CV_32F);
				
				
				// Multiplication
				Mat prod = new Mat(new Size(300, 200), CvType.CV_32F), fin = new Mat();
				Core.normalize(fdcp, fdcp, 0.0, 1.0, Core.NORM_MINMAX);
				Core.normalize(fdnc, fdnc, 0.0, 1.0, Core.NORM_MINMAX);
				Core.multiply(fdcp, fdnc, prod);
				Scalar s = new Scalar(255);
				Core.multiply(prod, s, prod);
				prod.convertTo(prod, CvType.CV_8UC1);
				
				resultas[4] = Mat2BufferedImage(resize(prod));
				
				Imgproc.threshold(prod, fin, 20,255, 0);
				long end = System.currentTimeMillis();
				System.out.println("Took : " + ((end - start) / 1000.));
				
				resultas[5] = Mat2BufferedImage(resize(fin));
				
				return resultas;
	}
	
	public static Image[] orkisz(String pathP, String pathC, String pathN) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		// Recuperer les images
		long start = System.currentTimeMillis();
		
		Mat c = Imgcodecs.imread(pathC);
		Mat p = Imgcodecs.imread(pathP);
		Mat n = Imgcodecs.imread(pathN);
		// Remove noise by blurring with a Gaussian filter ( kernel size = 3 )
        Imgproc.GaussianBlur( n, n, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT );
        Imgproc.GaussianBlur( p, p, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT );
        Imgproc.GaussianBlur( c, c, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT );
		// Montrer les images
		// displayImage(Mat2BufferedImage(resize(p)));
		// displayImage(Mat2BufferedImage(resize(c)));
		// displayImage(Mat2BufferedImage(resize(n)));
		
		// Convertir les images au niveaux de gris
		Mat gc=rgb2gray(c), gp=rgb2gray(p), gn=rgb2gray(n);
		//displayImage(Mat2BufferedImage(resize(gp)));
		//displayImage(Mat2BufferedImage(resize(gc)));
		//displayImage(Mat2BufferedImage(resize(gn)));
		
		Image[] resultas = new Image[7];
		// Calculer la difference
		Mat grad_p = new Mat(), grad_c = new Mat(), grad_n = new Mat();

		Sobel sob = new Sobel();
	
		grad_p  = sob.run(resize(gp));
		grad_c  = sob.run(resize(gc));
		grad_n  = sob.run(resize(gn));
		
		resultas[0] = Mat2BufferedImage(resize(grad_p));
		resultas[1] = Mat2BufferedImage(resize(grad_c));
		resultas[2] = Mat2BufferedImage(resize(grad_n));
		
		// max
		Mat  svn = new Mat(), stn = new Mat();
		Core.max(grad_p, grad_n, svn); Core.max(grad_c, svn, stn);
		resultas[3] = Mat2BufferedImage(resize(svn));
		resultas[4] = Mat2BufferedImage(resize(stn));
		
		// Différence entre svn stn
		Mat diff = new Mat(), fin = new Mat();
		Core.absdiff(svn, stn, diff);  
		
		resultas[5] = Mat2BufferedImage(resize(diff));
		
		Imgproc.threshold(diff, fin, 35,255, 0);
		
		long end = System.currentTimeMillis();

		System.out.println("Took : " + ((end - start) / 1000.));
		resultas[6] = Mat2BufferedImage(resize(fin));
		
		return resultas;
		
}
	
    public static Mat rgb2gray(Mat im) {
		Mat n = new Mat();
	    Imgproc.cvtColor(im, n, Imgproc.COLOR_RGB2GRAY);
		return n;
	}
	public static Mat resize(Mat c) {
		Mat nc = new Mat();
		Size sz = new Size(200,300); 
		Imgproc.resize( c, nc, sz );
		return nc;
	}
	public static BufferedImage Mat2BufferedImage(Mat m){
		// source: http://answers.opencv.org/question/10344/opencv-java-load-image-to-gui/
		// Fastest code
		// The output can be assigned either to a BufferedImage or to an Image
            
		    int type = BufferedImage.TYPE_BYTE_GRAY;
		    if ( m.channels() > 1 ) {
		        type = BufferedImage.TYPE_3BYTE_BGR;
		    }
		    int bufferSize = m.channels()*m.cols()*m.rows();
		    byte [] b = new byte[bufferSize];
		    m.get(0,0,b); // get all the pixels
		    BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
		    final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		    System.arraycopy(b, 0, targetPixels, 0, b.length);  
		    return image;

		}
	
	public static void displayImage(Image img2)
	{   
	    //BufferedImage img=ImageIO.read(new File("/HelloOpenCV/lena.png"));
		
	    ImageIcon icon=new ImageIcon(img2);
	    JFrame frame=new JFrame();
	    frame.setLayout(new FlowLayout());        
	    frame.setSize(img2.getWidth(null)+50, img2.getHeight(null)+50);     
	    JLabel lbl=new JLabel();
	    lbl.setIcon(icon);
	    frame.add(lbl);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	

}

