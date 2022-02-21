package implementation;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PageAccueil implements ActionListener {

    JFrame window;
    JButton ConnexionDB,AjouterClient,ModifierClient,AfficherClient;
    JLabel img1,img2,img3;
    private String pathP, pathC, pathN;
    private JRadioButton orkisz, vieren;

    public PageAccueil(){
        homePage();
    }
    public JFrame homePage(){
        window = new JFrame();
        window.setResizable(false);
        window.setTitle("Home page");
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        int longueur = 1200;
        int largeur = 800;
        ////////////////////////////////////////////////////////////////
        JPanel pann = new JPanel();
        pann.setBounds(0,0,longueur,720);
        pann.setBackground(new Color(224, 224, 224));
        pann.setLayout(null); 
        //////////////////////////////////////////////////
        JPanel pann2 = new JPanel();
        pann2.setBounds(0,0,longueur,120);
        pann2.setBackground(new Color(255, 255, 255));
        pann2.setLayout(null); 
        ////////////////////////////////////
        ImageIcon img = new ImageIcon("images/aa.jpeg");
        JLabel photo = new JLabel(img);
        photo.setBounds(0,0,longueur,80);
        photo.setHorizontalAlignment(JLabel.CENTER);
        ////////////////////////////////////////////////////////////////
        JLabel projet = new JLabel("Projet de fin d'études : ");
        projet.setFont(new Font("serif", Font.BOLD, 20));
        projet.setBounds(0,85,longueur,35);
        projet.setOpaque(true);
        projet.setBackground(new Color(0, 102, 204));
        projet.setForeground(Color.white);
        projet.setHorizontalAlignment(JLabel.CENTER);
        
        /////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
        JLabel titre = new JLabel("Détection des objets en mouvement par les methodes VIEREN & ORKISZ");
        titre.setFont(new Font("serif", Font.BOLD, 20));
        titre.setOpaque(true);
        titre.setBounds(0,110,longueur,50);
        titre.setBackground(new Color(0, 76, 153));
        titre.setForeground(Color.white);
        titre.setHorizontalAlignment(JLabel.CENTER);
        /////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(250,170,700,40);
        JLabel choisir = new JLabel("choisir la méthode :");
        choisir.setBounds(50,0,200,40);
        choisir.setFont(new Font("sans-serif", Font.BOLD, 16));
        choisir.setBackground(new Color(79, 83, 78));
        p.add(choisir);
        choisir.setHorizontalAlignment(JLabel.CENTER);
        //checkbox num
        vieren = new JRadioButton("VIEREN", true);
        vieren.setBounds(300,3,200,40);

        p.add(vieren);
        //checkbox nom
        orkisz = new JRadioButton("ORKISZ");
        orkisz.setBounds(500,3,200,40);
        p.add(orkisz);
        //////////////////////
        ButtonGroup methode = new ButtonGroup();
        methode.add(vieren);methode.add(orkisz);
        ///////////////////////////////////////
        /*ImageIcon image = new ImageIcon("F://ng.png");
        JLabel photo1 = new JLabel(image);
        photo1.setBounds(200,400,400,350);*/
        //////////////////////////////////////////////////////
        ////////// Les titres des images
        JLabel pred = new JLabel("L'image précédente :");
        pred.setBounds(30,220,360,30);
        pred.setOpaque(true);
        pred.setFont(new Font("sans-serif", Font.BOLD, 16));
        pred.setBackground(new Color(0, 102, 102));
        pred.setForeground(Color.white);
        pred.setHorizontalAlignment(JLabel.CENTER);
        /////////////////////////////////////////
        JLabel cour = new JLabel("L'image courante :");
        cour.setBounds(415,220,360,30);
        cour.setOpaque(true);
        cour.setFont(new Font("sans-serif", Font.BOLD, 16));
        cour.setBackground(new Color(0, 102, 102));
        cour.setForeground(Color.white);
        cour.setHorizontalAlignment(JLabel.CENTER);
        ////////////////////////////////////////////
        JLabel suiv = new JLabel("L'image suivante :");
        suiv.setBounds(800,220,360,30);
        suiv.setOpaque(true);
        suiv.setFont(new Font("sans-serif", Font.BOLD, 16));
        suiv.setBackground(new Color(0, 102, 102));
        suiv.setHorizontalAlignment(JLabel.CENTER);
        suiv.setForeground(Color.white);
        //////////////////////////////////////
         
        
        //////////////////////  Emplacement d'image 1
        
       
       
        img1 = new JLabel("Ajouter une photo ...");
        img1.setBounds(30,255,360,315);
        img1.setOpaque(true);
        img1.setFont(new Font("sans-serif", Font.BOLD, 16));
        img1.setBackground(new Color(79, 83, 78));
        img1.setHorizontalAlignment(JLabel.CENTER);
        img1.setForeground(Color.white);
        
        //////////////////////  Emplacement d'image 2
        img2 = new JLabel("Ajouter une photo ...");
        img2.setBounds(415,255,360,315);
        img2.setOpaque(true);
        img2.setFont(new Font("sans-serif", Font.BOLD, 16));
        img2.setBackground(new Color(79, 83, 78));
        img2.setHorizontalAlignment(JLabel.CENTER);
        img2.setForeground(Color.white);
        ///////////////////////////////// Emplacement d'image 3
         img3 = new JLabel("Ajouter une photo ...");
        img3.setBounds(800,255,360,315);
        img3.setOpaque(true);
        img3.setFont(new Font("sans-serif", Font.BOLD, 16));
        img3.setBackground(new Color(79, 83, 78));
        img3.setHorizontalAlignment(JLabel.CENTER);
        img3.setForeground(Color.white);
        
        //////////// les btns d'importation
        JButton btn2 = new JButton("importerC");
        btn2.setBounds(540, 573, 100, 40);
        btn2.setBackground(new Color(0, 102, 102));
        btn2.setForeground(Color.white);
        btn2.addActionListener(this);
        ////////////////////////
        JButton btn3 = new JButton("importerS");
        btn3.setBounds(930, 573, 100, 40);
        btn3.setBackground(new Color(0, 102, 102));
        btn3.setForeground(Color.white);
        btn3.addActionListener(this);
        /////////////////////////
        JButton btn = new JButton("importerP");
        btn.setBounds(155, 573, 100, 40);
        btn.setBackground(new Color(0, 102, 102));
        btn.setForeground(Color.white);
        btn.addActionListener(this);
        //////////////////////
        JButton valider = new JButton("DEMARER");
        valider.setBounds(490, 635, 200, 45);
        valider.setBackground(new Color(0, 102, 204));
        valider.setForeground(Color.white);
        valider.addActionListener(this);
        
        JSeparator jsep = new JSeparator(SwingConstants.HORIZONTAL);
        jsep.setBounds(100, 625, 1000, 10);


        pann2.add(photo);pann2.add(projet);pann.add(titre);pann.add(p);
        pann.add(pred);pann.add(cour);pann.add(suiv);pann.add(img1);
        pann.add(img2);pann.add(img3);pann.add(btn);pann.add(btn2);pann.add(btn3);pann.add(jsep);pann.add(valider);
        //pann.add(ConnexionDB);pann.add(AjouterClient);
        //pann.add(ModifierClient);
        //pann.add(AfficherClient);//pann.add(photo1);pann.add(dev);
        window.add(pann2);
        window.add(pann);
        
        
        window.setSize(1200, 725);
        window.setLayout(null);
        window.setVisible(true);
        return window;
    }
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(img1.getWidth(), img1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("importerP")){
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            //filter the files
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
             //if the user click on save in Jfilechooser
            if(result == JFileChooser.APPROVE_OPTION){
            	img1.setText("");
                File selectedFile = file.getSelectedFile();
                String path = pathP = selectedFile.getAbsolutePath();
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
                	img2.setText("");
                    File selectedFile = file1.getSelectedFile();
                    String path = pathC = selectedFile.getAbsolutePath();
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
                	img3.setText("");
                    File selectedFile = file2.getSelectedFile();
                    String path = pathN = selectedFile.getAbsolutePath();
                    img3.setIcon(ResizeImage(path));
                }
                 


                else if(result2 == JFileChooser.CANCEL_OPTION){
                    System.out.println("No File Select");
                }
        }
            
            if (e.getActionCommand().equals("DEMARER")){
            	if(img1.getText()=="Ajouter une photo ..." || img2.getText()=="Ajouter une photo ..." || img3.getText()=="Ajouter une photo ...") {
            		   JOptionPane.showMessageDialog(null,"veuillez importer les trois images !!!","info",JOptionPane.WARNING_MESSAGE);
            	}else {
            	Image[] resultats = null;
            	if(vieren.isSelected()) {
            		resultats = Backend.vieren(pathP, pathC, pathN);
                	new FrontendVieren(resultats);
            	}else{
            		resultats = Backend.orkisz(pathP, pathC, pathN);
                	new FrontendOrkisz(resultats);
            	}
            }
            }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         new PageAccueil();
         

    }
    
}
