package interfaz;

import javax.swing.*;

import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioNoRegistradoException;
import modelo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PanelIniciarSesion extends JPanel implements ActionListener, MouseListener {

	public final static Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoDos.png");
	public final static Image COPA = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/copaMundo.png");
	public final static String INICIAR = "iniciar";
	public final static String CANCELAR = "cancelar";

	private PanelInicial inicial;
	private PanelInicio inicio;
	private JLabel labUsuario;
	private JLabel contrasena;
	private JTextField txtUsuario;
	private JPasswordField pass;
	private JButton butIniciar;
	private JButton butCancelar;
	private JLabel usuarios;

	public PanelIniciarSesion(PanelInicial inicial) {

		this.inicial = inicial;

		inicio = new PanelInicio(this);

		setLayout(null);

		ajustarComponentes();

		addMouseListener(this);

	}

	public void ajustarComponentes() {

		Font fuente = new Font("Garamond", 1, 30);
		Font fuenteBoton = new Font("Garamond", 1, 24);

		ImageIcon icono = new ImageIcon("Archivos/imagenes/recursos/usuarios.png");
		usuarios = new JLabel(icono);
		usuarios.setBounds(600, 570, 150, 150);
		add(usuarios);

		labUsuario = new JLabel("Usuario");
		labUsuario.setFont(fuente);
		labUsuario.setForeground(Color.WHITE);
		labUsuario.setBounds(125, 265, 400, 40);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(125, 300, 400, 40);
		txtUsuario.setFont(fuente);

		contrasena = new JLabel("Contraseņa");
		contrasena.setFont(fuente);
		contrasena.setForeground(Color.WHITE);
		contrasena.setBounds(125, 365, 400, 40);

		pass = new JPasswordField();
		pass.setFont(fuente);
		pass.setBounds(125, 400, 400, 40);

		butIniciar = new JButton("Iniciar");
		butIniciar.setActionCommand(INICIAR);
		butIniciar.addActionListener(this);
		butIniciar.setFont(fuenteBoton);
		butIniciar.setBounds(125, 480, 180, 40);

		butCancelar = new JButton("Cancelar");
		butCancelar.setFont(fuenteBoton);
		butCancelar.setActionCommand(CANCELAR);
		butCancelar.addActionListener(this);
		butCancelar.setBounds(340, 480, 180, 40);

		add(labUsuario);
		add(txtUsuario);
		add(contrasena);
		add(pass);
		add(butIniciar);
		add(butCancelar);

	}

	public void listaUsuarios() {

		inicio.getVentana().getParquesMundial().ordenarUsuarios();
		ArrayList<Jugador> laminas = inicio.getVentana().getParquesMundial().getUsuarios();

		int numero = 1;

		String[] columnas = { "#", "Nombre" };
		Object[][] data = new Object[1000][1000];

		for (int i = 0; i < laminas.size(); i++) {

			data[i][0] = numero;
			data[i][1] = laminas.get(i).getNickName();

			numero++;
		}

		JTable tabla = new JTable(data, columnas);
		tabla.setEnabled(false);
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setFont(new Font("Garamond", 1, 16));
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setPreferredSize(new Dimension(400, 300));

		JOptionPane.showMessageDialog(null, scroll, "Lista de usuarios", 1, null);
	}

	public VentanaPrincipal getVentana() {

		return inicial.getVentana();

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(FONDO, 0, 0, null);
		g.drawImage(COPA, 800, 35, null);

		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(CANCELAR)) {

			inicial.getVentana().remove(this);
			inicial.getVentana().add(inicial);
			inicial.getVentana().refresh();

		}

		if (comando.equals(INICIAR)) {

			if (inicial.getVentana().getParquesMundial().yaExiste(txtUsuario.getText())) {

				Jugador actual = null;

				try {
					actual = inicial.getVentana().buscarUsuario(txtUsuario.getText());
					String contra = String.valueOf(pass.getPassword());

					if (actual.getContrasena().equalsIgnoreCase(contra)) {

						inicial.getVentana().setSesionActiva(actual);
						inicial.getVentana().remove(this);
						inicial.getVentana().add(inicio);
						inicial.getVentana().refresh();
						inicio.ajustarComponentes();

						txtUsuario.setText("");
						pass.setText("");

					} else {

						try {
							throw new ContrasenaIncorrectaException();
						} catch (ContrasenaIncorrectaException ex) {

							JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}

					}

				} catch (UsuarioNoRegistradoException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			} else {

				try {
					throw new UsuarioNoRegistradoException(txtUsuario.getText());
				} catch (UsuarioNoRegistradoException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println(e.getX());
		System.out.println(e.getY());

		if (e.getX() > 600 && e.getX() < 750 && e.getY() > 570 && e.getY() < 720) {
			listaUsuarios();

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
