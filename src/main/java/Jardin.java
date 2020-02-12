import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Scanner;

public class Jardin extends JFrame {

    private int temperature = 26;
    private int luminosity = 100;
    private float PH = 100;
    private int humidity1 = 21;
    private int humidity2 = 22;
    private int humidity3 = 23;




    private JFrame jFrame;
    private JPanel jPanel, panelWelcome1, panelWelcome2, panelWelcome3, panelWelcomeInfo;
    private JLabel label2, label3, labelTemperature, labelLuminosity, labelPH, labelHelp;

    private JPanel panelWater, panelHelp;
    private JLabel jLabelWaterTitle, jLabelWaterSubTitle, jLabelHumidity1, jLabelHumidity2, jLabelHumidity3, jLabelHelpTitle, jLabelHelp1, jLabelHelp2, jLabelHelp3;

    public void laucheInterface(){

        this.jFrame = new JFrame("Jardin Vertical");

        // -- Setting the width and height of frame --
        // Setting the width and height of frame
        // 1.get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // 2.get 2/3 of the height, and 2/3 of the width
        int height = screenSize.height * 2 / 5;
        int width = screenSize.width * 2 / 5;
        // 3.set the jframe height and width
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -- panelWelcome1 : 4 Components --
        // camera 1
        this.panelWelcome1 = new WebcamPanel(Webcam.getDefault());
        this.panelWelcome1.setBorder(new LineBorder(Color.gray));
        // camera 2
        this.panelWelcome2 = new JPanel();
        this.panelWelcome2.setBorder(new LineBorder(Color.gray));
        label2 = new JLabel("Caméra 2");
        // camera 3
        this.panelWelcome3 = new JPanel();
        this.panelWelcome3.setBorder(new LineBorder(Color.gray));
        label3 = new JLabel("Caméra 3");
        panelWelcome3.add(label3);
        // panelWelcomeInfo
        this.panelWelcomeInfo = new JPanel();
        this.panelWelcomeInfo.setBorder(new LineBorder(Color.gray));
        labelTemperature = new JLabel("Temperature : " + temperature + " °C", SwingConstants.CENTER);
        labelLuminosity = new JLabel("Luminosité : " + luminosity, SwingConstants.CENTER);
        labelPH = new JLabel("PH : " + PH, SwingConstants.CENTER);
        labelTemperature.setFont(new Font( "Serif", Font.BOLD, 12));
        labelLuminosity.setFont(new Font( "Serif", Font.BOLD, 12));
        labelPH.setFont(new Font( "Serif", Font.BOLD, 12));
        labelHelp = new JLabel("Dites \"Aide\" pour afficher la liste des commandes disponibles", SwingConstants.CENTER);
        panelWelcomeInfo.add(labelTemperature);
        panelWelcomeInfo.add(labelLuminosity);
        panelWelcomeInfo.add(labelPH);
        panelWelcomeInfo.add(labelHelp);
        panelWelcomeInfo.setLayout(new GridLayout(5, 0));

        // add components
        jPanel = new JPanel();
        jFrame.add(jPanel);

        // loading Page d'acceuil
        activeAcceuil();


        // Panels ou Labels qui sont constants
        // Panel Help
        panelHelp = new JPanel();
        jLabelHelpTitle = new JLabel("------ Aide ------", SwingConstants.CENTER);
        jLabelHelpTitle.setFont(new Font( "Serif", Font.BOLD, 20));
        jLabelHelp1 = new JLabel("1. temperature [chiffre]", SwingConstants.CENTER);
        jLabelHelp1.setFont(new Font( "Serif", Font.BOLD, 15));
        jLabelHelp2 = new JLabel("2. arroser tout / arroser 1/2/3 / arreter arrosage", SwingConstants.CENTER);
        jLabelHelp2.setFont(new Font( "Serif", Font.BOLD, 15));
        jLabelHelp3 = new JLabel("3. acceuil", SwingConstants.CENTER);
        jLabelHelp3.setFont(new Font( "Serif", Font.BOLD, 15));
        panelHelp.add(jLabelHelpTitle);
        panelHelp.add(jLabelHelp1);
        panelHelp.add(jLabelHelp2);
        panelHelp.add(jLabelHelp3);
        panelHelp.setLayout(new GridLayout(5, 0));

        // Panel Water
        panelWater = new JPanel();
        panelWater.setLayout(new GridLayout(5,0));
        jLabelWaterSubTitle = new JLabel("Taux de humidite : \n");
        jLabelHumidity1 = new JLabel("    Etage 1 : " + humidity1 + "%");
        jLabelHumidity2 = new JLabel("    Etage 2 : " + humidity2 + "%");
        jLabelHumidity3 = new JLabel("    Etage 3 : " + humidity3 + "%");


        // set window visible and center
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void uploadTemperature(int temperature){
        this.temperature = temperature;
        labelTemperature.setText("Temperature : " + temperature + " °C");
        System.out.println(">>> temperature uploaded : " + temperature);
    }

    public void uploadHumidity1(int humidity1){
        this.humidity1 = humidity1;
        jLabelHumidity1.setText("    Etage 1 : " + humidity1 + "%");
        System.out.println(">>> humidity1 uploaded : " + humidity1);
    }

    public void uploadHumidity2(int humidity2){
        this.humidity2 = humidity2;
        jLabelHumidity2.setText("    Etage 2 : " + humidity2 + "%");
        System.out.println(">>> humidity2 uploaded : " + humidity2);
    }

    public void uploadHumidity3(int humidity3){
        this.humidity3 = humidity3;
        jLabelHumidity3.setText("    Etage 3 : " + humidity3 + "%");
        System.out.println(">>> humidity3 uploaded : " + humidity3);
    }

    public void uploadLuminosity(int luminosity){
        this.luminosity = luminosity;
        labelLuminosity.setText("Luminosité : " + luminosity);
    }

    public void uploadPH(float PH){
        this.PH = PH;
        labelPH.setText("PH : " + PH);
    }

    public void waterAll(){
        this.jPanel.removeAll();
        this.jPanel.setLayout(new GridLayout(2,2));
        this.jPanel.add(panelWelcome1);
        this.jPanel.add(panelWelcome2);
        this.jPanel.add(panelWelcome3);

        panelWater = new JPanel();
        jLabelWaterTitle = new JLabel("Arrosage tout les étages en cours");
        jLabelWaterTitle.setFont(new Font( "Serif", Font.BOLD, 20));

        panelWater.add(jLabelWaterTitle);
        panelWater.add(jLabelWaterSubTitle);
        panelWater.add(jLabelHumidity1);
        panelWater.add(jLabelHumidity2);
        panelWater.add(jLabelHumidity3);
        panelWater.setLayout(new GridLayout(5,0));
        this.jPanel.add(panelWater);
        this.jPanel.repaint();
        this.jFrame.validate();
    }
    public void waterFirst(){

        panelWater.removeAll();
        jLabelWaterTitle = new JLabel(" Arrosage de premier étage en cours");
        jLabelWaterTitle.setFont(new Font( "Serif", Font.BOLD, 20));
        panelWater.add(jLabelWaterTitle);
        panelWater.add(jLabelWaterSubTitle);
        panelWater.add(jLabelHumidity1);

        this.jPanel.removeAll();
        this.jPanel.setLayout(new GridLayout(0,2));
        this.jPanel.add(panelWelcome1);
        this.jPanel.add(panelWater);
        this.jPanel.repaint();
        this.jFrame.validate();
    }
    public void waterSecond(){
        panelWater.removeAll();
        jLabelWaterTitle = new JLabel(" Arrosage de deuxieme étage en cours");
        jLabelWaterTitle.setFont(new Font( "Serif", Font.BOLD, 20));
        panelWater.add(jLabelWaterTitle);
        panelWater.add(jLabelWaterSubTitle);
        panelWater.add(jLabelHumidity2);

        this.jPanel.removeAll();
        this.jPanel.setLayout(new GridLayout(0,2));
        this.jPanel.add(panelWelcome2);
        this.jPanel.add(panelWater);
        this.jPanel.repaint();
        this.jFrame.validate();
    }
    public void waterThird(){
        panelWater.removeAll();
        jLabelWaterTitle = new JLabel(" Arrosage de troisieme étage en cours");
        jLabelWaterTitle.setFont(new Font( "Serif", Font.BOLD, 20));
        panelWater.add(jLabelWaterTitle);
        panelWater.add(jLabelWaterSubTitle);
        panelWater.add(jLabelHumidity3);

        this.jPanel.removeAll();
        this.jPanel.setLayout(new GridLayout(0,2));
        this.jPanel.add(panelWelcome3);
        this.jPanel.add(panelWater);
        this.jPanel.repaint();
        this.jFrame.validate();
    }

    public void stopWater(){
        activeAcceuil();
    }


    public void activeAcceuil(){
        this.jPanel.removeAll();
        //this.jFrame.validate();
        //this.jFrame.removeAll();
        //jPanel = new JPanel();
        jPanel.add(panelWelcome1);
        jPanel.add(panelWelcome2);
        jPanel.add(panelWelcome3);
        jPanel.add(panelWelcomeInfo);
        jPanel.setLayout(new GridLayout(2,2));
        jPanel.repaint();
        this.jFrame.validate();
    }

    public void launchHelp(){
        this.jPanel.removeAll();
        jPanel.add(panelHelp);
        jPanel.setLayout(new GridLayout(1,0));
        jPanel.repaint();
        jFrame.validate();
    }

    // -- TEST a l'aide console --
    public void getCommande(){
        Scanner scanner = new Scanner( System.in );
        String input = "";
        while(!input.equals("exit")){
            System.out.print("Dit-moi, qu'est-ce que tu veux hen ???(\"help\" if u need help O.O) : ");
            input = scanner.nextLine();
            traiterCommande(input);
        }
        System.out.println("Bye, a plus ^^");
        System.exit(0);
    }

    public void traiterCommande(String c){
        String[] list = c.split(" ");

        if (list.length == 2 && list[0].toLowerCase().equals("temperature"))
            uploadTemperature(Integer.valueOf(list[1]));
        else if(list.length == 2 && list[0].toLowerCase().equals("humidity1"))
            uploadHumidity1(Integer.valueOf(list[1]));
        else if(list.length == 2 && list[0].toLowerCase().equals("humidity2"))
            uploadHumidity2(Integer.valueOf(list[1]));
        else if(list.length == 2 && list[0].toLowerCase().equals("humidity3"))
            uploadHumidity3(Integer.valueOf(list[1]));
        else if(list.length == 2 && list[0].toLowerCase().equals("ph"))
            uploadPH(Float.valueOf(list[1]));
        else if(list.length == 2 && list[0].toLowerCase().equals("luminosity"))
            uploadLuminosity(Integer.valueOf(list[1]));
        else if(list.length == 1 && list[0].toLowerCase().equals("aide"))
            launchHelp();
        else if (list.length == 2 && list[0].toLowerCase().equals("arreter") && list[1].toLowerCase().equals("arrosage"))
            stopWater();
        else if (list.length == 2 && list[0].toLowerCase().equals("arroser")){
            if(list[1].toLowerCase().equals("tout"))
                waterAll();
            else if(list[1].toLowerCase().equals("1"))
                waterFirst();
            else if(list[1].toLowerCase().equals("2"))
                waterSecond();
            else if(list[1].toLowerCase().equals("3"))
                waterThird();
        }
        else if (list.length == 1 && list[0].toLowerCase().equals("acceuil"))
            activeAcceuil();
        else
            System.out.println("C'est vraiment trop difficile à comprendre votre commande -> " + c);

    }

    public static void main(String[] args) {
        Jardin myJardin = new Jardin();
        myJardin.laucheInterface();
        myJardin.getCommande();
    }
};
