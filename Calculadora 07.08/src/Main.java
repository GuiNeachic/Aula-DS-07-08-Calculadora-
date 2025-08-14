import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Criando janela
        JFrame janela = new JFrame("Janela");
        janela.setSize(400, 350);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new FlowLayout());

        //Criando campos
        JLabel rotulo1 = new JLabel("Digite o primeiro valor:");
        JTextField campo1 = new JTextField(15);
        JLabel rotulo2 = new JLabel("Digite o segundo valor");
        JTextField campo2 = new JTextField(15);

        //Criando botões
        JButton soma = new JButton("+");
        JButton subtracao = new JButton("-");
        JButton multiplicacao = new JButton("X");
        JButton divisao = new JButton("/");

        //Criando rótulo para exibir o resultado
        JLabel campoResultado = new JLabel("Resultado: ");
        janela.add(campoResultado);

        //Exibindo a janela
        janela.setVisible(true);

        //adicionando botões
        janela.add(rotulo1);
        janela.add(campo1);
        janela.add(rotulo2);
        janela.add(campo2);
        janela.add(soma);
        janela.add(subtracao);
        janela.add(multiplicacao);
        janela.add(divisao);

        // Adicionando funções aos botões
        ActionListener calcular = e -> {
            try {
                // Obtendo os valores dos campos de texto
                double valor1 = Double.parseDouble(campo1.getText());
                double valor2 = Double.parseDouble(campo2.getText());

                // Realizando o cálculo dependendo do botão pressionado
                double resultado = 0;
                if (e.getSource() == soma) {
                    resultado = valor1 + valor2;
                } else if (e.getSource() == subtracao) {
                    resultado = valor1 - valor2;
                } else if (e.getSource() == multiplicacao) {
                    resultado = valor1 * valor2;
                } else if (e.getSource() == divisao) {
                    if (valor2 != 0) {
                        resultado = valor1 / valor2;
                    } else {
                        campoResultado.setText("Erro: Divisão por zero!");
                        return;
                    }
                }
                campoResultado.setText("Resultado: " + resultado);  //Atualizando o rótulo com o resultado
            } catch (NumberFormatException ex) {
                campoResultado.setText("Erro: Entrada inválida!");  //Caso os valores não sejam números válidos
            }
        };

        //Adicionando o ActionListener aos botões
        soma.addActionListener(calcular);
        subtracao.addActionListener(calcular);
        multiplicacao.addActionListener(calcular);
        divisao.addActionListener(calcular);
    }
}