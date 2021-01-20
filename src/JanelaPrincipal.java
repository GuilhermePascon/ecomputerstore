import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class JanelaPrincipal {
    JButton botaoAdicionarSaldo;
    JButton botaoVerCarrinho;
    JButton botaoCriarPedido;
    JButton botaoFinalizarPedido;
    JLabel clienteLabel;
    JTextField campoSaldo;
    JFrame janela;
    ArrayList<Produto> produtos;
    Cliente clienteAtual;
    Estoque estoque;

    public JanelaPrincipal(ArrayList<Produto> produtos, Cliente clienteAtual, Estoque estoque) {
        GridLayout layout = new GridLayout(4,0);

        this.clienteAtual = clienteAtual;
        this.estoque = estoque;

        botaoAdicionarSaldo = new JButton("Adicionar Saldo");
        botaoCriarPedido = new JButton("Criar pedido com itens do carrinho");
        botaoFinalizarPedido = new JButton("Finalizar pedido mais recente");
        botaoVerCarrinho = new JButton("Ver Carrinho");
        clienteLabel = new JLabel("Nome: " + clienteAtual.getNome() + "       Saldo: " + clienteAtual.getSaldo(), JLabel.CENTER);
        campoSaldo = new JTextField(10);
        janela = new JFrame("eComputerStore");
        janela.setLayout(layout);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(0, 2));
        painel.add(clienteLabel);
        painel.add(botaoVerCarrinho);

        JPanel painel3 = new JPanel();
        painel.setLayout(new GridLayout(0, 2));
        painel3.add(new JLabel("Digite o valor do saldo a ser adicionado na caixa ao lado"));
        painel3.add(campoSaldo);
        painel3.add(botaoAdicionarSaldo);

        JPanel painel4 = new JPanel();
        BoxLayout boxlayout = new BoxLayout(painel4, BoxLayout.Y_AXIS);
        painel4.setLayout(boxlayout);
        JLabel produtoLabel = new JLabel("Produtos disponiveis (clique para adicionar ao carrinho)");
        produtoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel4.add(produtoLabel);
        for (Produto p: estoque.getProdutos()) {
            JButton botaoProduto = new JButton(p.getDescricao());
            botaoProduto.setAlignmentX(Component.CENTER_ALIGNMENT);
            botaoProduto.addActionListener(new AdicionarProdutoAoCarrinho(clienteAtual, p));
            painel4.add(botaoProduto);
        }

        JPanel painel2 = new JPanel();
        painel2.setLayout(new GridLayout(1, 0));
        painel2.add(botaoCriarPedido);
        painel2.add(botaoFinalizarPedido);

        janela.getContentPane().add(painel);
        janela.getContentPane().add(painel3);
        janela.getContentPane().add(painel4);
        janela.getContentPane().add(painel2);
        janela.setSize(300,100);

        botaoAdicionarSaldo.addActionListener(new AdicionaSaldo(clienteAtual, clienteLabel, campoSaldo, janela));
        botaoVerCarrinho.addActionListener(new VerCarrinho(clienteAtual));
        botaoCriarPedido.addActionListener(new CriarPedidoAtual(clienteAtual));
        botaoFinalizarPedido.addActionListener(new FinalizarPedido(clienteAtual));
        janela.setVisible(true);
    }

    class AdicionaSaldo implements ActionListener {
        Cliente cliente;
        JLabel label;
        JTextField campoSaldo;
        JFrame janela;
        AdicionaSaldo(Cliente cliente, JLabel label, JTextField campoSaldo, JFrame janela) {
            this.cliente = cliente;
            this.label = label;
            this.campoSaldo = campoSaldo;
            this.janela = janela;
        }
        public void actionPerformed(ActionEvent e) {
            try {
                float saldo = Float.parseFloat(campoSaldo.getText());
                cliente.adicionarSaldo(saldo);
                label.setText("Nome: " + clienteAtual.getNome() + "       Saldo: " + clienteAtual.getSaldo());
                clienteLabel = new JLabel("Nome: " + clienteAtual.getNome() + "   Saldo: " + clienteAtual.getSaldo(), JLabel.CENTER);
                this.campoSaldo.setText("");
                JOptionPane.showMessageDialog(janela, "O valor " + saldo + " foi adicionado com sucesso!");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(janela, "O valor inserido deve conter somente numeros", "Erro", JOptionPane.ERROR_MESSAGE);
                this.campoSaldo.setText("");
            }
        }
    }

    class VerCarrinho implements ActionListener {
        Cliente cliente;
        VerCarrinho(Cliente cliente) {
            this.cliente = cliente;
        }
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(janela, cliente.toString());
        }
    }

    class AdicionarProdutoAoCarrinho implements ActionListener {
        Cliente cliente;
        Produto produto;
        AdicionarProdutoAoCarrinho(Cliente cliente, Produto produto) {
           this.cliente = cliente;
           this.produto = produto;
        }
        public void actionPerformed(ActionEvent e) {
            cliente.adicionarAoCarrinho(produto, 1);
            JOptionPane.showMessageDialog(janela, produto.getDescricao() + " adicionado ao carrinho");
        }
    }

    class CriarPedidoAtual implements ActionListener {
        Cliente cliente;
        CriarPedidoAtual(Cliente cliente) {
            this.cliente = cliente;
        }
        public void actionPerformed(ActionEvent e) {
            if (cliente.getCarrinho().size() > 0) {
                Pedido pedido = new Pedido(cliente, cliente.getCarrinho());
                cliente.adicionaPedido(pedido);
                cliente.esvaziarCarrinho();
                JOptionPane.showMessageDialog(janela, "Pedido realizado, itens do carrinho removidos");
            } else {
                JOptionPane.showMessageDialog(janela, "O carrinho nao tem itens", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class FinalizarPedido implements ActionListener {
        Cliente cliente;
        FinalizarPedido(Cliente cliente) {
            this.cliente = cliente;
        }
        public void actionPerformed(ActionEvent e) {
            try {
                if (cliente.finalizarCompra(cliente.getPedidos().get(0)) == false) {
                    JOptionPane.showMessageDialog(janela, "O cliente nao tem saldo suficiente para realizar o pedido", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    cliente.finalizarCompra(cliente.getPedidos().get(0));
                    // remove o pedido da lista de pedidos do cliente
                    int index = cliente.getPedidos().indexOf(cliente.getPedidos().get(0));
                    cliente.getPedidos().remove(index);
                    JOptionPane.showMessageDialog(janela, "Pedido mais recente finalizado");
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(janela, "O cliente nao tem pedidos", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}