import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarNumerosGUI  extends JFrame implements ActionListener{
    private int[] listaNumeros = new int[10];
    private int totalNumeros = 0;
    private JButton jbCadastrar;
    private JButton jbExcluir;
    private JButton jbInserirMeio ;

    private JTextField jtNumero;
    private JTextArea jtaNumeros;
    private JPanel jpSuperior;
    private JLabel jlNumero;
    private JPanel jpInferior;

    public CadastrarNumerosGUI() {

        super("Lista de Números");

        jpSuperior = new JPanel();
        jpSuperior.setLayout(new FlowLayout());
        
        jlNumero = new JLabel("Número:");
        jtNumero = new JTextField(20);
        
        jpSuperior.add(jlNumero);
        jpSuperior.add(jtNumero);

        jpInferior = new JPanel();
        jpInferior.setLayout(new GridLayout(1, 4, 10, 10));

        jbCadastrar = new JButton("Cadastrar");
        jbExcluir = new JButton("Excluir");
        jbInserirMeio = new JButton("Inserir no Meio");

        jpInferior.add(jbCadastrar);
        jpInferior.add(jbExcluir);
        jpInferior.add(jbInserirMeio);

        jtaNumeros = new JTextArea(10, 30);
        jtaNumeros.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtaNumeros);

        add(jpSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(jpInferior, BorderLayout.SOUTH);
        
        jbCadastrar.addActionListener(this);
        jbExcluir.addActionListener(this);
        jbInserirMeio.addActionListener(this);
    }

    private void cadastrarNumero() throws NumberFormatException{
        String texto = jtNumero.getText();
        int numero = Integer.parseInt(texto);
        if (totalNumeros < 10) {
            listaNumeros[totalNumeros] = numero;
            totalNumeros++;
            atualizarListaNumeros();
            jtNumero.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "A lista está cheia! Não é possível adicionar mais números.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirNumero() {
        if (totalNumeros == 0) {
            JOptionPane.showMessageDialog(this, "A lista está vazia. Não há nada para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        String[] opcoes = new String[totalNumeros];
        for (int i = 0; i < totalNumeros; i++) {
            opcoes[i] = "Posição " + (i + 1) + " (Número: " + listaNumeros[i] + ")";
        }
    
        String posicaoEscolhida = (String) JOptionPane.showInputDialog(this,"Escolha o número para excluir","Excluir Número",JOptionPane.QUESTION_MESSAGE,null,opcoes,opcoes[0]);
    
        if (posicaoEscolhida == null) return;
    
        int posicao = Integer.parseInt(posicaoEscolhida.split(" ")[1]) - 1; 
    
        for (int i = posicao; i < totalNumeros - 1; i++) {
            listaNumeros[i] = listaNumeros[i + 1];
        }
        totalNumeros--;
        atualizarListaNumeros();
    
        JOptionPane.showMessageDialog(this, "Número excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void inserirNoMeio() throws NumberFormatException{
        if (totalNumeros == 0 || totalNumeros == 10) {
            JOptionPane.showMessageDialog(this, "Não há espaço para inserção no meio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String texto = jtNumero.getText();
        int numero = Integer.parseInt(texto);
        

        String[] opcoes = new String[totalNumeros - 1];
        int count = 0;
        do  {
            opcoes[count] = "Posição " + (++count) + " (Número atual: " + listaNumeros[count] + ")";
        }while(count < totalNumeros - 1);
            
        String posicaoEscolhida = (String) JOptionPane.showInputDialog(this, "Escolha a posição para inserir", "Inserir no Meio", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (posicaoEscolhida == null) return;

        int posicao = Integer.parseInt(posicaoEscolhida.split(" ")[1]);

        for (int i = totalNumeros; i > posicao; i--) {
            listaNumeros[i] = listaNumeros[i - 1];
        }
        listaNumeros[posicao] = numero;
        totalNumeros++;

        atualizarListaNumeros();
        jtNumero.setText("");
    }

    private void atualizarListaNumeros() {
        jtaNumeros.setText("");
        for (int i = 0; i < totalNumeros; i++) {
            jtaNumeros.append(" - " + listaNumeros[i] + "\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cadastrar":
                try{
                    cadastrarNumero();
                } catch (NumberFormatException nf) {
                    JOptionPane.showMessageDialog(this, "Por favor, insira um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Excluir":
                excluirNumero();
                break;

            case "Inserir no Meio":
                try{
                    inserirNoMeio();
                } catch (NumberFormatException nf) {
                    JOptionPane.showMessageDialog(this, "Por favor, insira um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            default:
                break;
        }
    }

}
