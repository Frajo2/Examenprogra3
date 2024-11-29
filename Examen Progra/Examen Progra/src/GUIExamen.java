import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIExamen {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField codigo;
    private JTextField nombre;
    private JComboBox poderEspecial;
    private JComboBox nivelHabilidad;
    private JComboBox misionActiva;
    private JTable table1;
    private JComboBox comboBox4;
    private JTextArea textArea1;
    private JComboBox comboBox5;
    private JTable table2;
    private JTable table3;
    private JButton agregarButton;
    private JButton limpiarButton;
    private JButton generarButton;
    private JButton filtrarButton;
    private JButton ordenarButton;
    private JButton buscarButton;
    private JButton contarButton;
    private Lista listaSimple = new Lista();
    private Lista listaFiltrada = new Lista();
    private Lista listaCom = new Lista();
    private Lista listaTiro = new Lista();
    private Lista listaTec = new Lista();
    private Lista listaSig = new Lista();
    private Lista listaSup = new Lista();
    private Thunderbolts thunderbolt = null;

    public GUIExamen() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(listaSimple.busquedaLineal(Integer.parseInt(codigo.getText())) != -1) {

                    JOptionPane.showMessageDialog(null, "Ya hay un Thunderbolt con este ID ");
                }else{
                    //int codigo, String nombre, String poderEspecial, String nivelHabilidad, int misionActiva
                    thunderbolt = new Thunderbolts(Integer.parseInt(codigo.getText()), nombre.getText(), poderEspecial.getSelectedItem().toString(), Integer.parseInt(nivelHabilidad.getSelectedItem().toString()), misionActiva.getSelectedItem().toString());
                    listaSimple.agregarThunderbolth(thunderbolt);
                    JOptionPane.showMessageDialog(null, "Avenger agregado con exito");
                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                codigo.setText("");
                nombre.setText("");
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int codigoIngresado = Integer.parseInt(codigo.getText());


                Thunderbolts thunderboltEncontrado = listaSimple.buscarPorCodigo(codigoIngresado);

                if (thunderboltEncontrado != null) {

                    nombre.setText(thunderboltEncontrado.getNombre());
                    poderEspecial.setSelectedItem(thunderboltEncontrado.getPoderEspecial());
                    nivelHabilidad.setSelectedItem(String.valueOf(thunderboltEncontrado.getNivelHabilidad()));
                    misionActiva.setSelectedItem(thunderboltEncontrado.getMisionActiva());
                } else {
                    JOptionPane.showMessageDialog(null, "Thunderbolt con código " + codigoIngresado + " no encontrado.");
                }
            }
        });

        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaSimple.mostrar(table1, 1, true);
            }
        });

        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String habilidadSeleccionada = poderEspecial.getSelectedItem().toString();

                Lista listaFiltrada = listaSimple.filtrar(habilidadSeleccionada, false);

                listaFiltrada.ordenarPorNivelRedencion();

                listaFiltrada.mostrar(table3, 0, true);
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaFiltrada.ordenar();
                listaFiltrada.mostrar(table3, 0, true);
            }
        });
        contarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lista de habilidades principales
                String[] habilidades = {"Combate cuerpo a cuerpo", "Tiro Preciso", "Tecnologia Avanzada", "Sigilo", "Supervelocidad"};
                StringBuilder resultados = new StringBuilder();

                for (String habilidad : habilidades) {
                    int conteo = listaSimple.contarMisionesPorHabilidad(habilidad, listaSimple.getNodo());
                    resultados.append(habilidad).append(": ").append(conteo).append(" misiones\n");
                }

                textArea1.setText(resultados.toString());
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIPrueba");
        frame.setContentPane(new GUIExamen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

