import java.awt.*;
import javax.swing.*;

public class Signaller {
    public static void main(String[] args) throws InterruptedException{
        JFrame frame = simulator();
        Light l1 = new Light();
        frame.add(l1);
        for (int i=0; i<1000; i++){
            l1.counter();
            l1.signaller();
            Thread.sleep(1000);
            }
    }
    private static JFrame simulator() {
        JFrame frame = new JFrame();
        frame.setTitle("Traffic Lights");
        frame.setSize(700,400);
        frame.setLocation(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }
    static class Light extends JPanel {
        private static final long serialVersionUID = 1L;
        private int time = 0;
        private int distance = 90;
        private int vertical = 50;
        private Color R1 = Color.red;
        private Color Y1 = Color.black;
        private Color G1 = Color.black;
        private Color R2 = Color.black;
        private Color Y2 = Color.black;
        private Color G2 = Color.green;
        Light() {
        }

        @Override
        public void paintComponent(Graphics g){
            Light_def(g);
        }
        public final int getTime() {
            return this.time;
        }
        public final void distance(int distance) {
            this.distance = distance;
        }
        public final void vertical(int vertical) { this.vertical = vertical; }
        public final void counter() {
            if(this.time == 33){
                this.time = -1;
            }
            this.time = this.time + 1;
        }
        public void signaller() {
            if (this.time == 0){
                this.R1 = Color.red;
                this.Y1 = Color.black;
                this.G1 = Color.black;
            }
            if (this.time == 14){
                this.R1 = Color.red;
                this.Y1 = Color.yellow;
                this.G1 = Color.black;
            }
            if (this.time == 20){
                this.R1 = Color.black;
                this.Y1 = Color.black;
                this.G1 = Color.green;
            }
            if (this.time == 31) {
                this.R1 = Color.black;
                this.Y1 = Color.yellow;
                this.G1 = Color.black;
            }
            if (this.time == 0){
                this.R2 = Color.black;
                this.Y2 = Color.black;
                this.G2 = Color.green;
            }
            if (this.time == 11){
                this.R2 = Color.black;
                this.Y2 = Color.yellow;
                this.G2 = Color.black;
            }
            if (this.time == 17){
                this.R2 = Color.red;
                this.Y2 = Color.black;
                this.G2 = Color.black;
            }
            if (this.time == 31) {
                this.R2 = Color.red;
                this.Y2 = Color.yellow;
                this.G2 = Color.black;
            }
            repaint();
        }
        public final void Light_def(Graphics g) {
            g.setColor(Color.black);
            g.drawString("East-West", 150,25);
            g.drawRect(95,40,90,280);
            g.setColor(this.R1);
            g.fillOval(100, this.vertical, 80, 80);
            g.setColor(this.Y1);
            g.fillOval(100, this.vertical+this.distance, 80, 80);
            g.setColor(this.G1);
            g.fillOval(100, this.vertical+2*this.distance, 80, 80);
            g.setColor(Color.black);
            g.drawRect(195,40,90,280);
            g.setColor(this.R1);
            g.fillOval(200, this.vertical, 80, 80);
            g.setColor(this.Y1);
            g.fillOval(200, this.vertical+this.distance, 80, 80);
            g.setColor(this.G1);
            g.fillOval(200, this.vertical+2*this.distance, 80, 80);
            g.setColor(Color.black);
            g.drawString("North-South", 465,25);
            g.drawRect(395,40,90,280);
            g.setColor(this.R2);
            g.fillOval(400, this.vertical, 80, 80);
            g.setColor(this.Y2);
            g.fillOval(400, this.vertical+this.distance, 80, 80);
            g.setColor(this.G2);
            g.fillOval(400, this.vertical+2*this.distance, 80, 80);
            g.setColor(Color.black);
            g.drawRect(495,40,90,280);
            g.setColor(this.R2);
            g.fillOval(500, this.vertical, 80, 80);
            g.setColor(this.Y2);
            g.fillOval(500, this.vertical+this.distance, 80, 80);
            g.setColor(this.G2);
            g.fillOval(500, this.vertical+2*this.distance, 80, 80);
        }
    }
}
