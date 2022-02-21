package implementation;


import javax.swing.*;

import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrontendVieren  {

    JFrame window;
    JLabel img1,img2,img3,img4,img5,img6;

    public FrontendVieren(Image[] resultas){
    	results(resultas);
    }
    public JFrame results(Image[] resultas){
        window = new JFrame();
        window.setResizable(false);
        window.setTitle("La méthode de VIEREN");
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        int longueur = tailleMoniteur.width;
        int largeur = tailleMoniteur.height;
        int imgWidth = 200, imgHeight=300;
        ////////////////////////////////////////////////////////////////
        JPanel pann = new JPanel();
        pann.setBounds(0,0,longueur,820);
        pann.setBackground(new Color(204, 209, 255));
        pann.setLayout(null); 
        //////////////////////////////////////////////////
        
        
        JLabel pred = new JLabel("Différence IP-IC :");
        pred.setBounds(5,5,360,30);
        pred.setOpaque(true);
        pred.setFont(new Font("sans-serif", Font.BOLD, 16));
        pred.setBackground(new Color(0, 102, 102));
        pred.setForeground(Color.white);
        pred.setHorizontalAlignment(JLabel.CENTER);
        /////////////////////////////////////////
        JLabel cour = new JLabel("Différence IC-IS :");
        cour.setBounds(370,5,360,30);
        cour.setOpaque(true);
        cour.setFont(new Font("sans-serif", Font.BOLD, 16));
        cour.setBackground(new Color(0, 102, 102));
        cour.setForeground(Color.white);
        cour.setHorizontalAlignment(JLabel.CENTER);

        ////////// Deuxieme ligne des images
        JLabel max1 = new JLabel("Gradient(Différence (IC-IS) :");
        max1.setBounds(5,345,360,30);
        max1.setOpaque(true);
        max1.setFont(new Font("sans-serif", Font.BOLD, 16));
        max1.setBackground(new Color(0, 102, 102));
        max1.setForeground(Color.white);
        max1.setHorizontalAlignment(JLabel.CENTER);
        ////////////////////////////////////////////
        JLabel suiv = new JLabel("Gradient(Différence (IP-IC):");
        suiv.setBounds(735,5,360,30);
        suiv.setOpaque(true);
        suiv.setFont(new Font("sans-serif", Font.BOLD, 16));
        suiv.setBackground(new Color(0, 102, 102));
        suiv.setHorizontalAlignment(JLabel.CENTER);
        suiv.setForeground(Color.white);
        
        //////// Emplacement d'image 1
        img1 = new JLabel();
        img1.setBounds(85,40,imgWidth,imgHeight);
        img1.setOpaque(true);
        img1.setFont(new Font("sans-serif", Font.BOLD, 16));
        img1.setBackground(new Color(79, 83, 78));
        img1.setHorizontalAlignment(JLabel.CENTER);
        img1.setForeground(Color.white);
        img1.setIcon(ResizeImage(resultas[0]));
        ////////////////////////

        ///////// Emplacement d'image 2
         img2 = new JLabel();
        img2.setBounds(370+80,40,imgWidth,imgHeight);
        img2.setOpaque(true);
        img2.setFont(new Font("sans-serif", Font.BOLD, 16));
        img2.setBackground(new Color(79, 83, 78));
        img2.setHorizontalAlignment(JLabel.CENTER);
        img2.setForeground(Color.white);
        img2.setIcon(ResizeImage(resultas[1]));
        
        /////////// Emplacement d'image 3
         img3 = new JLabel();
        img3.setBounds(735+80,40,imgWidth,imgHeight);
        img3.setOpaque(true);
        img3.setFont(new Font("sans-serif", Font.BOLD, 16));
        img3.setBackground(new Color(79, 83, 78));
        img3.setHorizontalAlignment(JLabel.CENTER);
        img3.setForeground(Color.white);
        img3.setIcon(ResizeImage(resultas[2]));
        
        /////////////////////////////////////////
        JLabel max2 = new JLabel("Multiplication des grad :");
        max2.setBounds(370,345,360,30);
        max2.setOpaque(true);
        max2.setFont(new Font("sans-serif", Font.BOLD, 16));
        max2.setBackground(new Color(0, 102, 102));
        max2.setForeground(Color.white);
        max2.setHorizontalAlignment(JLabel.CENTER);
        ////////////////////////////////////////////
        JLabel max3 = new JLabel("image final après seuillage:");
        max3.setBounds(735,345,360,30);
        max3.setOpaque(true);
        max3.setFont(new Font("sans-serif", Font.BOLD, 16));
        max3.setBackground(new Color(0, 102, 102));
        max3.setForeground(Color.white);
        max3.setHorizontalAlignment(JLabel.CENTER);
        
        ////////// Emplacement d'image 4
         img4 = new JLabel();
         img4.setBounds(5+80,380,imgWidth,imgHeight);
         img4.setOpaque(true);
         img4.setFont(new Font("sans-serif", Font.BOLD, 16));
         img4.setBackground(new Color(79, 83, 78));
         img4.setHorizontalAlignment(JLabel.CENTER);
         img4.setForeground(Color.white);
         img4.setIcon(ResizeImage(resultas[3]));
        ////////////////////////

        /////// Emplacement d'image 5
         img5 = new JLabel();
         img5.setBounds(370+80,380,imgWidth,imgHeight);
         img5.setOpaque(true);
         img5.setFont(new Font("sans-serif", Font.BOLD, 16));
         img5.setBackground(new Color(79, 83, 78));
         img5.setHorizontalAlignment(JLabel.CENTER);
         img5.setForeground(Color.white);
         img5.setIcon(ResizeImage(resultas[4]));
        ////////// Emplacement d'image 6
         img6 = new JLabel();
         img6.setBounds(735+80,380,imgWidth,imgHeight);
         img6.setOpaque(true);
         img6.setFont(new Font("sans-serif", Font.BOLD, 16));
         img6.setBackground(new Color(79, 83, 78));
         img6.setHorizontalAlignment(JLabel.CENTER);
         img6.setForeground(Color.white);
         img6.setIcon(ResizeImage(resultas[5]));
        ////////////////////////////////////////
        
        pann.add(pred);pann.add(cour);pann.add(suiv);pann.add(img1);
        pann.add(img2);pann.add(img3);pann.add(max1);pann.add(max2);pann.add(max3);
        pann.add(img4);
        pann.add(img5);pann.add(img6);
        //pann.add(ConnexionDB);pann.add(AjouterClient);
        //pann.add(ModifierClient);
        //pann.add(AfficherClient);//pann.add(photo1);pann.add(dev);
  
        window.add(pann);
        
        
        window.setSize(1114, 724);
        window.setLayout(null);
        window.setVisible(true);
        return window;
    }
   public ImageIcon ResizeImage(Image im)
    {
        ImageIcon MyImage = new ImageIcon(im);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(img1.getWidth(), img1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }


  /*  public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("importerP")){
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            //filter the files
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
             //if the user click on save in Jfilechooser
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = file.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                img1.setIcon(ResizeImage(path));
            }
             //if the user click on save in Jfilechooser


            else if(result == JFileChooser.CANCEL_OPTION){
                System.out.println("No File Select");
            }
        }
            if (e.getActionCommand().equals("importerC")){
                JFileChooser file1 = new JFileChooser();
                file1.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filter the files
                FileNameExtensionFilter filter1 = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                file1.addChoosableFileFilter(filter1);
                int result1 = file1.showSaveDialog(null);
                 //if the user click on save in Jfilechooser
                if(result1 == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file1.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    img2.setIcon(ResizeImage(path));
                }
                 //if the user click on save in Jfilechooser


                else if(result1 == JFileChooser.CANCEL_OPTION){
                    System.out.println("No File Select");
                }
        }
            if (e.getActionCommand().equals("importerS")){
                JFileChooser file2 = new JFileChooser();
                file2.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filtrer les fichier à ajouter
                FileNameExtensionFilter filter2 = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                file2.addChoosableFileFilter(filter2);
                int result2 = file2.showSaveDialog(null);
                 //si on clique sur save en Jfilechooser
                if(result2 == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file2.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    img3.setIcon(ResizeImage(path));
                }
                 


                else if(result2 == JFileChooser.CANCEL_OPTION){
                    System.out.println("No File Select");
                }
        }
        
    }*/
   
}

