package interfaz;

import javax.swing.*;

import hilos.HiloParques;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.*;

public class PanelInicio extends JPanel implements ActionListener, MouseListener {

	public static final Image ALBUM = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/album.png");
	public static final Image LAMINA = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/lamina.jpeg");
	public static final Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoInicio.png");
	public static final Image LOGO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/logoPro.png");

	public static final String JUGAR = "jugar";

	private PanelParques parques;
	private PanelEscogerEquipo escoger;
	private PanelIniciarSesion sesion;
	private JLabel labUsuario;
	private JButton butJugar;
	private JLabel labLaminas;
	private JLabel labAlbum;
	private JLabel labTituloAlbum;
	private JLabel labTituloLaminas;
	private PanelPanini panini;
	private PanelTienda tienda;
	private JLabel usuario;
	private Equipo actual;
	private Parques p;
	private Equipo e1 = new Equipo("Archivos/imagenes/banderas/colombia.png", "Colombia", 1);
	private Equipo e2 = new Equipo("Archivos/imagenes/banderas/brasil.png", "Brasil", 2);
	private Equipo e3 = new Equipo("Archivos/imagenes/banderas/argentina.png", "Argentina", 3);
	private Equipo e4 = new Equipo("Archivos/imagenes/banderas/espa�a.png", "Espa�a", 4);
	private HiloParques hilo;
	
	
	public PanelInicio(PanelIniciarSesion sesion) {

		this.sesion = sesion;
		setLayout(null);
		// ajustarComponentes();
		addMouseListener(this);
		panini = new PanelPanini(this);
		tienda = new PanelTienda(this);
		parques = null;
		actual = null;
		p = null;
		hilo = null;

	}

	public VentanaPrincipal getVentana() {

		return sesion.getVentana();

	}
	
	public HiloParques getHiloParques() {
		
	return hilo;	
		
	}

	public void ajustarComponentes() {

		butJugar = new JButton("JUGAR");
		butJugar.setFont(new Font("Garamond", 1, 40));
		butJugar.setBounds(530, 480, 235, 95);
		butJugar.setActionCommand(JUGAR);
		butJugar.addActionListener(this);
		add(butJugar);

		labTituloAlbum = new JLabel(" Completa el album! ");
		labTituloAlbum.setBounds(50, 80, 500, 80);
		labTituloAlbum.setFont(new Font(" Garamond ", 1, 35));
		labTituloAlbum.setForeground(Color.BLACK);
		add(labTituloAlbum);

		labTituloLaminas = new JLabel(" Consigue laminas! ");
		labTituloLaminas.setBounds(920, 80, 500, 80);
		labTituloLaminas.setFont(new Font(" Garamond ", 1, 35));
		labTituloLaminas.setForeground(Color.BLACK);
		add(labTituloLaminas);

		usuario = new JLabel("Bienvenido" + " " + sesion.getVentana().getSesionActiva().getNickName());
		usuario.setFont(new Font("Garamond", 1, 60));
		usuario.setBounds(300, 580, 800, 95);
		add(usuario);

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(FONDO, 0, 0, null);
		g.drawImage(LOGO, 450, 10, null);
		g.drawImage(ALBUM, 95, 175, null);
		g.drawImage(LAMINA, 1000, 230, null);
		g.drawImage(LAMINA, 975, 245, null);
		g.drawImage(LAMINA, 1065, 245, null);
		g.drawImage(LAMINA, 1035, 285, null);

		repaint();

	}

	public void setActual(Equipo actual) {

		this.actual = actual;

	}

	public Equipo getActual() {

		return actual;

	}

	public Equipo getE1() {

		return e1;

	}

	public Equipo getE2() {

		return e2;

	}

	public Equipo getE3() {

		return e3;
	}

	public Equipo getE4() {
		return e4;

	}

	public void personalizarParques() {

		parques = new PanelParques(this);

		// Se agregan las banderas de los equipos que representa cada jugador
		parques.getCarcelUno().setLayout(new BorderLayout());

		parques.getCarcelUno().add(new JLabel(new ImageIcon(e1.getRutaBandera())), BorderLayout.CENTER);

		parques.getCarcelDos().setLayout(new BorderLayout());

		parques.getCarcelDos().add(new JLabel(new ImageIcon(e2.getRutaBandera())), BorderLayout.CENTER);

		parques.getCarcelTres().setLayout(new BorderLayout());

		parques.getCarcelTres().add(new JLabel(new ImageIcon(e3.getRutaBandera())), BorderLayout.CENTER);

		parques.getCarcelCuatro().setLayout(new BorderLayout());

		parques.getCarcelCuatro().add(new JLabel(new ImageIcon(e4.getRutaBandera())), BorderLayout.CENTER);

		parques.getElCentro().setLayout(new BorderLayout());

		parques.getElCentro().add(new JLabel(new ImageIcon("./Archivos/imagenes/recursos/centroParques.png")),
				BorderLayout.CENTER);

		// Se pintan las casillas casa para cada equipo
		for (int k = 0; k < parques.getZonaUnoBut()[0].length; k++) {
			parques.getZonaUnoBut()[1][k].setBackground(Color.YELLOW);
		}

		for (int k = 0; k < parques.getZonaDosBut().length; k++) {
			parques.getZonaDosBut()[k][1].setBackground(Color.GREEN);
		}

		for (int k = 0; k < parques.getZonaTresBut()[0].length; k++) {
			parques.getZonaTresBut()[1][k].setBackground(Color.CYAN);
		}

		for (int k = 0; k < parques.getZonaCuatroBut().length; k++) {
			parques.getZonaCuatroBut()[k][1].setBackground(Color.RED);
		}

		// Casillas Seguro
		parques.getZonaUnoBut()[1][0].setBackground(Color.DARK_GRAY);
		parques.getZonaUnoBut()[0][4].setBackground(Color.DARK_GRAY);

		parques.getZonaDosBut()[3][0].setBackground(Color.DARK_GRAY);
		parques.getZonaDosBut()[7][1].setBackground(Color.DARK_GRAY);

		parques.getZonaTresBut()[1][7].setBackground(Color.DARK_GRAY);
		parques.getZonaTresBut()[2][3].setBackground(Color.DARK_GRAY);

		parques.getZonaCuatroBut()[0][1].setBackground(Color.DARK_GRAY);
		parques.getZonaCuatroBut()[4][2].setBackground(Color.DARK_GRAY);
		// Fin Casillas Seguro

		// Se pintan las casillas salida de los equipos
		parques.getZonaUnoBut()[2][4].setBackground(Color.YELLOW);
		parques.getZonaDosBut()[3][2].setBackground(Color.GREEN);
		parques.getZonaTresBut()[0][3].setBackground(Color.CYAN);
		parques.getZonaCuatroBut()[4][0].setBackground(Color.RED);

	}
	
	public Parques getParques() {
		
	return p;	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(JUGAR)) {

			JOptionPane.showMessageDialog(null, "Esta seccion se encuentra en fase BETA");

			VentanaPrincipal vent = sesion.getVentana();

			sesion.getVentana().remove(this);

			// Se crean los jugadores
			Jugador j2 = new Jugador("Jugador 2");
			Jugador j3 = new Jugador("Jugador 3");
			Jugador j4 = new Jugador("Jugador 4");

			// Se asignan los equipos a los jugadores
			vent.getSesionActiva().setEquipo(e1);
			j2.setEquipo(e2);
			j3.setEquipo(e3);
			j4.setEquipo(e4);

			Equipo[] equipos = { vent.getSesionActiva().getEquipo(), j2.getEquipo(), j3.getEquipo(), j4.getEquipo() };

			Partida laPartida = new Partida();

			laPartida.getParques().setEquipos(equipos);

			vent.getSesionActiva().setPartida(laPartida);

			// Equipos y colores
			personalizarParques();

			p = laPartida.getParques();

			hilo = new HiloParques(p, parques);
			
			sesion.getVentana().add(parques);
			sesion.getVentana().setSize(1400, 1000);
			sesion.getVentana().refresh();
			
			Thread proceso = new Thread(hilo);
			
			proceso.start();
			
//			p.sacarFichasDeLaCarcel(e1.getFichas());
			
			
//			p.sacarFichasDeLaCarcel(e2.getFichas());
//			p.sacarFichasDeLaCarcel(e3.getFichas());
//			p.sacarFichasDeLaCarcel(e4.getFichas());
//			p.moverFichaNew(e1.getFichas()[0], 12);
//			p.moverFichaNew(e1.getFichas()[1], 10);
//			p.moverFichaNew(e2.getFichas()[0], 7);
//			p.moverFichaNew(e3.getFichas()[0], 10);
//			p.moverFichaNew(e4.getFichas()[0], 5);

//			parques.actualizarTablero();


//			parques.actualizarFichas();

//			parques.actualizarTablero();

	

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// System.out.println("x = "+e.getX()+" y = "+ e.getY());

		// Condicion para entrar al album panini
		if ((e.getX() >= 100 && e.getX() <= 310) && (e.getY() >= 185 && e.getY() <= 485)) {

			// System.out.println("hola");
			sesion.getVentana().remove(this);
			panini.inicializar();
			sesion.getVentana().add(panini);
			sesion.getVentana().refresh();

		}

		if ((e.getX() >= 950 && e.getX() <= 1180) && (e.getY() >= 230 && e.getY() <= 445)) {

			tienda.componentes();
			// System.out.println("bye");
			sesion.getVentana().remove(this);
			sesion.getVentana().add(tienda);
			sesion.getVentana().refresh();

		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
