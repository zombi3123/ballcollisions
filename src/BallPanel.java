import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

public class BallPanel extends JPanel implements ActionListener {
    private ArrayList<Ball> balls;
    private JButton btnAddBalls,btnClearAll;
    private Random randNum=new Random();
    private Timer tm;
    private double xSpeed;int ySpeed;
    private int width;int height;
    Color color;

    public BallPanel(int height,int width) {
        this.setSize(height,width);
        balls = new ArrayList<>();
        btnAddBalls=new JButton("Add new balls!");
        btnClearAll=new JButton("Remove All Balls");
        initComponents();
        this.setBackground(Color.cyan);
        tm = new Timer(1,this);
        this.width=width;
        this.height=height;
    }

    private void initComponents(){
        this.add(btnAddBalls);
        this.add(btnClearAll);
        btnAddBalls.setBounds(this.width/2-100,this.height/10,50,50);
        btnAddBalls.setVisible(true);
        btnAddBalls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<2;i++) { //Make this range higher to porduce more balls per button click
                    int ypos = randNum.nextInt(getHeight() - 50);
                    int xpos = randNum.nextInt(getWidth() - 50);
                    color=new  Color(randNum.nextInt(256),randNum.nextInt(256),randNum.nextInt(256));
                    Ball ball = new Ball(xpos, ypos,50, color);
                    //ball.xSpeed=randNum.nextInt(1);
                    //ball.ySpeed=randNum.nextInt(1);
                    double n = 1; //Speed
                    ball.setMass(0.5);
                    ball.xSpeed=n;
                    ball.ySpeed=n;
                    balls.add(ball);
                }
                tm.start();
                repaint();
            }
        });
        btnClearAll.setBounds(this.width/2,this.height/10,50,50);
        btnClearAll.setVisible(true);
        btnClearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent d) {

              balls.clear();

                repaint();
            }
        });

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        BasicStroke s=new BasicStroke(1);
        g2d.setColor(Color.CYAN);
        g2d.setStroke(s);
        for (Ball b:balls){
            b.draw(g2d);
        }
    }

    public double distance(Ball one, Ball two){
        double d = Math.pow(Math.pow(one.getX()-two.getX(),2)+Math.pow(one.getY()-two.getY(),2),0.5);
        return d;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ball b:balls){
            if (b.getX()+b.getWidth()>this.width || b.getX()<0){b.setxSpeed(-(b.getxSpeed()));}
            else if (b.getY()<0 || b.getY()+b.getWidth()>this.height){b.setySpeed(-(b.getySpeed()));}
            b.xpos+=xSpeed;
            b.ypos+=ySpeed;
            b.setX(b.xpos);
            b.setY(b.ypos);
            b.move(b.getxSpeed(),b.getySpeed());
            repaint();

            for (Ball c:balls){

                if (c!=b){ //We don't want the ball detecting a collsision with itself
                    if(distance(c,b)<c.getWidth()){
                        double vx1=b.getxSpeed();
                        double vx2=c.getxSpeed();
                        double vy1=b.getySpeed();
                        double vy2=c.getySpeed();
                        double m1=b.getMass();
                        double m2=b.getMass();
                        double finalVelX1=((vx1*(m1-m2)+2*(m2*vx2))/(m1+m2));
                        double finalVelX2=((vx2*(m2-m1)+2*(m1*vx1))/(m1+m2));
                        double finalVelY1=((vy1*(m1-m2)+2*(m2*vy2))/(m1+m2));
                        double finalVelY2=((vy2*(m2-m1)+2*(m1*vy1))/(m1+m2));
                        b.setxSpeed(finalVelX1);
                        c.setxSpeed(finalVelX2);
                        b.setySpeed(finalVelY1);
                        c.setySpeed(finalVelY2);
                        b.move(b.getxSpeed(),b.getySpeed());
                        repaint();
                    }
                }
            }
        }


    }
}

