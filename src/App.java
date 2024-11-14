import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        CadastrarNumerosGUI bin = new CadastrarNumerosGUI();
        bin.setSize(700, 350);
        bin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bin.setLocationRelativeTo(null);
        bin.setResizable(false);
        bin.setVisible(true);
    }
}
