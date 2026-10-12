import java.awt.GridLayout;
import javax.swing.*;

class Main {
    static int sumar(int a, int b) { return a + b; }
    static int restar(int a, int b) { return a - b; }
    static int multiplicar(int a, int b) { return a * b; }
    static double dividir(int a, int b) {
        if (b == 0) throw new ArithmeticException("No se puede dividir entre cero.");
        return (double) a / b;
    }

    private static void crearVentana() {
        JFrame ventana = new JFrame("Calculadora");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        JTextField[] numeros = { new JTextField(), new JTextField() };
        JTextField[] resultados = {
            new JTextField(), new JTextField(), new JTextField(), new JTextField()
        };
        String[] etiquetas = {
            "Primer número entero:", "Segundo número entero:",
            "Suma:", "Resta:", "Multiplicación:", "División:"
        };

        for (int i = 0; i < etiquetas.length; i++) {
            panel.add(new JLabel(etiquetas[i]));
            JTextField campo = i < 2 ? numeros[i] : resultados[i - 2];
            if (i >= 2) campo.setEditable(false);
            panel.add(campo);
        }

        JButton calcular = new JButton("Calcular");
        calcular.addActionListener(e -> {
            try {
                int a = Integer.parseInt(numeros[0].getText().trim());
                int b = Integer.parseInt(numeros[1].getText().trim());
                resultados[0].setText("" + sumar(a, b));
                resultados[1].setText("" + restar(a, b));
                resultados[2].setText("" + multiplicar(a, b));
                resultados[3].setText("" + dividir(a, b));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Ingrese números enteros válidos.");
            } catch (ArithmeticException ex) {
                resultados[3].setText("Error");
                JOptionPane.showMessageDialog(ventana, ex.getMessage());
            }
        });

        panel.add(calcular);
        ventana.setContentPane(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::crearVentana);
    }
}
