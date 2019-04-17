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
    private JButton btnAddBalls,btnClearAll,btnIncreaseGravity,btnStop,btnNonElasticCollisions;
    private Random randNum=new Random();
    private Timer tm;
    private double xSpeed;int ySpeed;
    private int width;
    private int height;
    private double gravity;
    private boolean nonStaticCollsions;
    Color color;

    public BallPanel(int height,int width) {
        this.setSize(height,width);
        this.gravity=0;
        balls = new ArrayList<>();
        btnAddBalls=new JButton("Add new balls!");
        btnNonElasticCollisions=new JButton("Only create non elastic collsions");
        btnClearAll=new JButton("Remove All Balls");
        btnIncreaseGravity=new JButton("Increase Gravity");
        btnStop=new JButton("Stop");

        initComponents();
        this.setBackground(Color.black);
        tm = new Timer(5,this);
        this.width=width;
        this.height=height;
    }

    private void initComponents(){
        this.add(btnAddBalls);
        this.add(btnClearAll);
        this.add(btnIncreaseGravity);
        this.add(btnStop);
        this.add(btnNonElasticCollisions);
        btnAddBalls.setBounds(this.width/2-btnAddBalls.getWidth(),this.height/10,50,50);
        btnAddBalls.setVisible(true);
        btnAddBalls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<10;i++) {
                    for (int j=0;j<10;j++) {
                    int ypos = randNum.nextInt(getHeight()-50);
                    int xpos = randNum.nextInt(getWidth()-50);
                    color= new Color(255,255,255);
                    Color colorPlane=new Color(255,0,0);
                    Ball ball = new Ball(xpos, ypos,20, color);

                   // Ball ball2 = new Ball(j*10, i*20,10, color);
                    //ball.xSpeed=randNum.nextInt(1);
                    //ball.ySpeed=randNum.nextInt(1);
                    int speeds[]={3,2,1,0,-1,-2,-3};
                    int mass[]={10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,95,96,97,98,99};
                    ball.setMass(mass[randNum.nextInt(mass.length)]);
                    if (ball.getMass()>=95){ball.setColour(colorPlane);}
                    ball.xSpeed=speeds[randNum.nextInt(speeds.length)];
                    ball.ySpeed=speeds[randNum.nextInt(speeds.length)];
                   /* ball2.setMass(0.5);
                    ball2.xSpeed=1;
                    ball2.ySpeed=1;*/
                    balls.add(ball);
                    //balls.add(ball2);
                }}
                tm.start();
                repaint();
            }
        });
        btnClearAll.setBounds(this.width/2,this.height/10,2,50);
        btnClearAll.setVisible(true);
        btnClearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent d) {
              balls.clear();
                repaint();
            }
        });
        btnIncreaseGravity.setBounds(this.width/2+btnIncreaseGravity.getWidth(),this.height/10,50,50);
        btnIncreaseGravity.setVisible(true);
        btnIncreaseGravity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravity+=5;
            }
        });
        btnStop.setBounds(this.width/2-50,this.height/10,50,50);
        btnStop.setVisible(true);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                tm.stop();
            }
        });
        btnNonElasticCollisions.setBounds(this.width/2+50,this.height/10,50,50);
        btnNonElasticCollisions.setVisible(true);
        btnNonElasticCollisions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                tm.stop();
            }
        });
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        for (Ball b:balls){
            b.draw(g2d);
        }
    }
    public int getWidth(){return this.width;}
    public int getHeight(){return this.height;}

    public double distance(Ball one, Ball two){
        double d = Math.pow(Math.pow(one.getX()-two.getX(),2)+Math.pow(one.getY()-two.getY(),2),0.5);
        return d;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        tm.stop();
        for (Ball b:balls){


            if (b.getX()+b.getWidth()>this.width){
                b.setxSpeed(-(b.getxSpeed()));
                //b.setX(b.getWidth());
            }
            if (b.getX()<0){
                    b.setxSpeed(-(b.getxSpeed()));
                //b.setX(this.width-b.getWidth());
            }
            if (b.getY()-b.getWidth()<0 && b.getySpeed()<0){
                    b.setySpeed(-(b.getySpeed()));

                System.out.println("X:"+b.getX()+" Y:"+b.getY());
                //b.setY(this.height-b.getWidth());
            }
            if (b.getY()+b.getWidth()>this.height){
               // b.setY(b.getWidth());
                if(gravity>3){
                    b.setySpeed(-(b.getySpeed()+gravity)/5);
                }
                else{ b.setySpeed(-(b.getySpeed()));
                    b.setxSpeed(b.getxSpeed());}

            }

            //b.xpos+=xSpeed;
           // b.ypos+=ySpeed;
            //b.setX(b.xpos);
            //b.setY(b.ypos);
            b.move(b.getxSpeed(),b.getySpeed()+gravity/5);
            repaint();

            for (Ball c:balls ){

                if (c!=b && distance(b,c)<b.getWidth()*4){
                    if(distance(c,b)<c.getWidth()+1){
                        /*double vx1=b.getxSpeed();
                        double vx2=c.getxSpeed();
                        double vy1=b.getySpeed();
                        double vy2=c.getySpeed();
                        double m1=b.getMass();
                        double m2=c.getMass();*/
                        double finalVelX1=((b.getxSpeed()*(b.getMass()-c.getMass())+2*(c.getMass()*c.getxSpeed()))/(b.getMass()+c.getMass()));
                        double finalVelX2=((c.getxSpeed()*(c.getMass()-b.getMass())+2*(b.getMass()*b.getxSpeed()))/(b.getMass()+c.getMass()));
                        double finalVelY1=((b.getySpeed()*(b.getMass()-c.getMass())+2*(c.getMass()*c.getySpeed()))/(b.getMass()+c.getMass()));
                        double finalVelY2=((c.getySpeed()*(c.getMass()-b.getMass())+2*(b.getMass()*b.getySpeed()))/(b.getMass()+c.getMass()));
                        b.setxSpeed(finalVelX1);
                        c.setxSpeed(finalVelX2);
                        b.setySpeed(finalVelY1);
                        c.setySpeed(finalVelY2);
                    /*    if (finalVelX1 == finalVelX2 && finalVelY1 == finalVelY2){
                            b.setxSpeed(-finalVelX2);
                            b.setX(b.getX()-b.getWidth()/2);
                        }*/

                        b.move(b.getxSpeed(),b.getySpeed());
                        c.move(c.getxSpeed(),c.getySpeed());
                        repaint();
                    }
                }
            }
        }
        tm.start();


    }
}
