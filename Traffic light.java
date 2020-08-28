import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TrafficLight extends JFrame implements ActionListener {
    JButton buttonStop, buttonReady, buttonGo;

      Signal green = new Signal(Color.green);
      Signal yellow = new Signal(Color.yellow);
      Signal red = new Signal(Color.red);

    public TrafficLight(){
        super("Java Traffic Light Program");
        getContentPane().setLayout(new GridLayout(2, 1));
        buttonStop = new JButton("Stop");
        buttonReady = new JButton("Ready");
        buttonGo = new JButton("Go");
        buttonStop.addActionListener(this);
        buttonReady.addActionListener(this);
        buttonGo.addActionListener(this);      

        Go.turnOn(false);
        Ready.turnOn(false);
        Stop.turnOn(true);

        JPanel trafficPanel = new JPanel(new GridLayout(3,1));
        trafficPanel.add(Stop);
        trafficPanel.add(Ready);
        trafficPanel.add(Go);
        JPanel lightPanel = new JPanel(new FlowLayout());
        lightPanel.add(buttonStop);
        lightPanel.add(buttonReady);
        lightPanel.add(buttonGo);

        getContentPane().add(trafficPanel);
        getContentPane().add(lightPanel);
        pack();
        }


    public static void main(String[] args){
        TrafficLight trafficLight = new TrafficLight();      
        trafficLight.setVisible(true);
    }  
    public void actionPerformed(ActionEvent e){      
        if (e.getSource() == buttonStop){
            Go.turnOn(false);          
           Ready.turnOn(false);
            Stop.turnOn(true);
        } else if (e.getSource() == buttonYellow){
            Ready.turnOn(true);          
            Go.turnOn(false);
            Stop.turnOn(false);
        } else if (e.getSource() == buttonGreen){
            Stop.turnOn(false);          
            Ready.turnOn(false);
            Go.turnOn(true);
        }
    }
}  
class Signal extends JPanel{

    Color on;
    int radius = 40;
    int border = 10;
    boolean change;

    Signal(Color color){
        on = color;
        change = true;
    }

    public void turnOn(boolean a){
        change = a;
        repaint();      
    }

    public Dimension getPreferredSize(){
        int size = (radius+border)*2;
        return new Dimension( size, size );
    }

    public void paintComponent(Graphics graphics){
        graphics.setColor( Color.black );
        graphics.fillRect(0,0,getWidth(),getHeight());

        if (change){
            graphics.setColor( on );
        } else {
            graphics.setColor( on.darker().darker().darker() );
        }
        graphics.fillOval( border,border,2*radius,2*radius );
    }
}

