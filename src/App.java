import javax.swing.JFrame;

public class App {
    public static void main(String[] args){
        ConvidadosGUI bin = new ConvidadosGUI();
        bin.setSize(400, 300);
        bin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bin.setLocationRelativeTo(null);
        bin.setResizable(false);
        bin.setVisible(true);
    }
}
