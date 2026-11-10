import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SistemaGUI extends JFrame {

    private final Registro registro = new Registro();

    private final DefaultTableModel modeloFiguras =
            new DefaultTableModel(new String[]{"Figura", "Lados", "Datos", "Area", "Perimetro"}, 0);

    private final JComboBox<String> cmbFigura = new JComboBox<>(new String[]{"Circulo", "Rectangulo", "Triangulo"});
    private final CardLayout cardCampos = new CardLayout();
    private final JPanel panelCampos = new JPanel(cardCampos);

    private final JTextField txtRadio = new JTextField(8);
    private final JTextField txtBase = new JTextField(8);
    private final JTextField txtAltura = new JTextField(8);
    private final JTextField txtLado1 = new JTextField(8);
    private final JTextField txtLado2 = new JTextField(8);
    private final JTextField txtLado3 = new JTextField(8);

    public SistemaGUI() {
        super("Figuras Geometricas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(crearPanelFormulario(), BorderLayout.WEST);
        add(crearPanelTabla(), BorderLayout.CENTER);

        setSize(850, 400);
        setLocationRelativeTo(null);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Figura:"));
        top.add(cmbFigura);
        panel.add(top, BorderLayout.NORTH);

        panelCampos.add(crearCampos(new String[]{"Radio:"}, new JTextField[]{txtRadio}), "Circulo");
        panelCampos.add(crearCampos(new String[]{"Base:", "Altura:"},
                new JTextField[]{txtBase, txtAltura}), "Rectangulo");
        panelCampos.add(crearCampos(new String[]{"Lado 1:", "Lado 2:", "Lado 3:"},
                new JTextField[]{txtLado1, txtLado2, txtLado3}), "Triangulo");

        JPanel centro = new JPanel(new BorderLayout(5, 5));
        centro.setBorder(BorderFactory.createTitledBorder("Nueva figura"));
        centro.add(panelCampos, BorderLayout.NORTH);

        JButton btn = new JButton("Crear figura");
        JPanel boton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        boton.add(btn);
        centro.add(boton, BorderLayout.CENTER);
        panel.add(centro, BorderLayout.CENTER);

        cmbFigura.addActionListener(e -> cardCampos.show(panelCampos, (String) cmbFigura.getSelectedItem()));
        btn.addActionListener(e -> crearFigura());
        return panel;
    }

    private JPanel crearCampos(String[] etiquetas, JTextField[] campos) {
        JPanel p = new JPanel(new GridLayout(etiquetas.length, 2, 5, 5));
        for (int i = 0; i < etiquetas.length; i++) {
            p.add(new JLabel(etiquetas[i]));
            p.add(campos[i]);
        }
        return p;
    }

    private JPanel crearPanelTabla() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JTable t = new JTable(modeloFiguras) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        t.setFillsViewportHeight(true);
        panel.add(new JScrollPane(t), BorderLayout.CENTER);
        return panel;
    }

    private void crearFigura() {
        String tipo = (String) cmbFigura.getSelectedItem();
        Figura figura;
        try {
            switch (tipo) {
                case "Circulo":
                    figura = new Circulo(leer(txtRadio));
                    break;
                case "Rectangulo":
                    figura = new Rectangulo(leer(txtBase), leer(txtAltura));
                    break;
                default:
                    double l1 = leer(txtLado1);
                    double l2 = leer(txtLado2);
                    double l3 = leer(txtLado3);
                    if (!Triangulo.esValido(l1, l2, l3)) {
                        error("Los lados ingresados no forman un triangulo.");
                        return;
                    }
                    figura = new Triangulo(l1, l2, l3);
                    break;
            }
        } catch (NumberFormatException ex) {
            error("Los campos de la figura deben ser valores positivos.");
            return;
        }
        registro.crearFigura(figura);
        refrescarFiguras();
        limpiar();
    }

    private double leer(JTextField campo) {
        double valor = Double.parseDouble(campo.getText().trim().replace(',', '.'));
        if (valor <= 0) throw new NumberFormatException();
        return valor;
    }

    private void limpiar() {
        for (JTextField t : new JTextField[]{txtRadio, txtBase, txtAltura, txtLado1, txtLado2, txtLado3}) {
            t.setText("");
        }
    }

    private void refrescarFiguras() {
        modeloFiguras.setRowCount(0);
        for (Figura f : registro.getFiguras()) {
            modeloFiguras.addRow(new Object[]{f.getNombre(), f.getLados(), f.getDatos(),
                    String.format("%.2f", f.getArea()), String.format("%.2f", f.getPerimetro())});
        }
    }

    private void error(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void iniciar() {
        SwingUtilities.invokeLater(() -> new SistemaGUI().setVisible(true));
    }
}
