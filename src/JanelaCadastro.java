import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class JanelaCadastro {
    JButton botaoCadastrar;
    JTextField campoNome;
    JFrame janela;
    Estoque estoque;

    public JanelaCadastro(Estoque estoque) {
        this.estoque = estoque;
        botaoCadastrar = new JButton("Cadastrar");
        campoNome = new JTextField(10);
        janela = new JFrame("Cadastre-se");
        JLabel label1 = new JLabel("Digite o nome de usuario no campo abaixo", JLabel.CENTER);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        JPanel painel = new JPanel();
        painel.add(label1);
        painel.add (campoNome);
        painel.add (botaoCadastrar);
        painel.setLayout(new GridLayout(3, 0));
        janela.getContentPane().add(painel);
        janela.setSize(400,400);
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoNome.getText().length() == 0) {
                    JOptionPane.showMessageDialog(painel, "Por favor insira um nome", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Cliente clienteAtual = new Cliente(0, new ArrayList<>(), campoNome.getText(), new ArrayList<>());
                    JOptionPane.showMessageDialog(painel, "Cliente " + campoNome.getText() +  " criado com sucesso");
                    new JanelaPrincipal(new ArrayList<>(), clienteAtual, estoque);
                    janela.setVisible(false);
                }
            }
        });
        janela.setVisible(true);
    }
}
