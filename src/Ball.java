import java.awt.*;

public class Ball {
    Color color;
    int xpos;int ypos;
    int width;
    double xSpeed;
    double mass;
    double ySpeed;

    public Ball(int xpos,int ypos,int width,Color color){
        this.xpos=xpos;
        this.ypos=ypos;
        this.width=width;
        this.color=color;
    }

    public double getMass(){return this.mass;}
    public void setMass(int mass){this.mass=mass;}
    public void move(double xSpeed,double ySpeed){
        this.xpos+=xSpeed;
        this.ypos+=ySpeed;
    }
    public void setxSpeed(double xSpeed){this.xSpeed=xSpeed;}

    public void setySpeed(double ySpeed){this.ySpeed=ySpeed;}

    public double getxSpeed(){return this.xSpeed;}

    public double getySpeed(){return this.ySpeed;}

    public int getX(){return xpos;}

    public void setX(int x){this.xpos=x;}

    public int getY(){return ypos;}

    public void setY(int y){this.ypos=ypos;}

    public int getWidth(){return this.width;}
    public void setColour(Color newColor){this.color=newColor;}
    public void draw(Graphics g){
        BasicStroke s = new BasicStroke(10);
        g.setColor(color);
        g.fillOval(xpos,ypos,width,width);
    }
}
