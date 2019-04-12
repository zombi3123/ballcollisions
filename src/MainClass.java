public class MainClass {
    public static void main(String[] args){

        Window w=new Window(1000,1000);
        BallPanel bp=new BallPanel(w.getWidth()-50,w.getHeight()-50);
        w.add(bp);
    }
}
