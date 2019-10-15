public class MainClass {
    public static void main(String[] args){

        Window w=new Window(1000,1000);
        BallPanel bp=new BallPanel(900,900);
        //bp.setLocation(w.getWidth()/2,w.getHeight()/2);
        w.setLayout(null);
        w.add(bp);
    }
}
