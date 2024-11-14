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

public class ConvidadosGUI extends JFrame implements ActionListener{
    private String[] listaConvidados = new String[10];
    private int numeroConvidados = 0;
    private JButton jbCadastrar;
    private JButton jbExcluir;
    private JButton jbVagas;

    private JTextField jtNome;
    private JTextArea jtaConvidados;
    
    JPanel jpSuperior;
    JLabel jlNome;
    JPanel jpInferior;

    public ConvidadosGUI() {
        super("Lista de Convidados");
        
        jpSuperior = new JPanel();
        jpSuperior.setLayout(new FlowLayout());
        
        jlNome = new JLabel("Nome do Convidado:");
        jtNome = new JTextField(20);
        
        jpSuperior.add(jlNome);
        jpSuperior.add(jtNome);
        
        jpInferior = new JPanel();
        jpInferior.setLayout(new GridLayout(1, 3, 10, 10));

        jbCadastrar = new JButton("Cadastrar");
        jbExcluir = new JButton("Excluir");
        jbVagas = new JButton("Vagas Restantes");

        jpInferior.add(jbCadastrar);
        jpInferior.add(jbExcluir);
        jpInferior.add(jbVagas);

        jtaConvidados = new JTextArea(10, 30);
        jtaConvidados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtaConvidados);

        add(jpSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(jpInferior, BorderLayout.SOUTH);
        
        jbCadastrar.addActionListener(this);
        jbExcluir.addActionListener(this);
        jbVagas.addActionListener(this);
    }

    private void cadastrarConvidado() {
        String nome = jtNome.getText();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um nome.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (numeroConvidados < 10) {
            listaConvidados[numeroConvidados] = nome;
            numeroConvidados++;
            atualizarListaConvidados();
            jtNome.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "A lista está cheia! Não é possível adicionar mais convidados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirConvidado() {
        String nome = jtNome.getText();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite o nome do convidado a ser excluído.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < numeroConvidados; i++) {
            if (listaConvidados[i].equals(nome)) {
                
                for (int j = i; j < numeroConvidados - 1; j++) {
                    listaConvidados[j] = listaConvidados[j + 1];
                }
                listaConvidados[numeroConvidados - 1] = null;
                numeroConvidados--;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            atualizarListaConvidados();
            jtNome.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Convidado não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarVagasRestantes() {
        JOptionPane.showMessageDialog(this, "Vagas restantes: " + (10 - numeroConvidados));
    }

    private void atualizarListaConvidados() {
        jtaConvidados.setText("");
        for (int i = 0; i < numeroConvidados; i++) {
            jtaConvidados.append((i + 1) + ". " + listaConvidados[i] + "\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cadastrar":
                cadastrarConvidado();
                break;
            case "Excluir":
                excluirConvidado();
                break;

            case "Vagas Restantes":
                mostrarVagasRestantes();
                break;
            default:
                break;
        }
    }
}
