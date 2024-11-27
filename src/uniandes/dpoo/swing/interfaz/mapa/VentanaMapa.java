package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener {
    private static final String VISITADOS = "VISITADOS";
    private static final String TODOS = "TODOS";

    private PanelMapaVisualizar panelMapa;
    private JRadioButton radioTodos;
    private JRadioButton radioVisitados;
    private VentanaPrincipal ventanaPrincipal;
    
    public VentanaMapa(VentanaPrincipal ventanaPrincipal, List<Restaurante> restaurantes){
        this.ventanaPrincipal = ventanaPrincipal;
        setLayout(new BorderLayout());

        // Panel donde se muestra el mapa
        panelMapa = new PanelMapaVisualizar();
        add(panelMapa, BorderLayout.CENTER);

        // Panel de filtros con los RadioButtons
        JPanel panelRadio = new JPanel();
        radioTodos = new JRadioButton("Todos");
        radioTodos.setActionCommand(TODOS);
        radioTodos.addActionListener(this);

        radioVisitados = new JRadioButton("Visitados");
        radioVisitados.setActionCommand(VISITADOS);
        radioVisitados.addActionListener(this);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioTodos);
        grupo.add(radioVisitados);
        panelRadio.add(radioTodos);
        panelRadio.add(radioVisitados);

        add(panelRadio, BorderLayout.NORTH);

        // Configuración final de la ventana
        pack();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (TODOS.equals(comando)) {
            panelMapa.actualizarMapa(ventanaPrincipal.getRestaurantes(true));
        } else if (VISITADOS.equals(comando)) {
            panelMapa.actualizarMapa(ventanaPrincipal.getRestaurantes(false));
        }
    }
    
    
}