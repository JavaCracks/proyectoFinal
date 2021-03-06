package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEscogerTipoDeJuego extends JPanel implements ActionListener{
	public static final Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoDos.png");
	public final static String SOLITARIO = "Solitario";
	public final static String MULTIJUGADOR = "Multijugador";
	public final static String REGRESAR = "Regresar";


	private JLabel lbEscoger;
	private JButton btMultijugador;
	private JButton btSolitario;
	private JButton btRegresar;
	private PanelEscogerEquipo pEscogerEquipo;
	private PanelInicial panelInicial;
	

	  public PanelEscogerTipoDeJuego(PanelInicial p) {
		  
		  
		  this.panelInicial = p;
			setPreferredSize(new Dimension(300,400));
			setLayout(null);
			
			
			inicializarComponentes();
	  }
	  
	public void inicializarComponentes() {
		
		lbEscoger = new JLabel(" Escoge el tipo de partida ");
		lbEscoger.setBounds(390, 260, 500, 80);
		lbEscoger.setFont(new Font(" Garamond ", 1, 35));
		lbEscoger.setForeground(Color.WHITE);
		add(lbEscoger);
		
		btMultijugador = new JButton(MULTIJUGADOR);
		btMultijugador.setBounds(450, 370, 330, 40);
		btMultijugador.setFont(new Font(" Garamond ", 1, 30));
		btMultijugador.addActionListener(this);
		btMultijugador.setActionCommand(MULTIJUGADOR);
		add(btMultijugador);
		

		// 136 330

		btSolitario = new JButton(SOLITARIO);
		btSolitario.setBounds(450, 470, 330, 40);
		btSolitario.setFont(new Font(" Garamond ", 1, 30));
		btSolitario.addActionListener(this);
		btSolitario.setActionCommand(SOLITARIO);
		add(btSolitario);
		
		btRegresar = new JButton(REGRESAR);
		btRegresar.setBounds(1050, 650, 150, 40);
		btRegresar.setFont(new Font(" Garamond ", 1, 25));
		btRegresar.addActionListener(this);
		btRegresar.setActionCommand(REGRESAR);
		add(btRegresar);
	}
	  
	
	public void paintComponent(Graphics g) {
		paintBackGround(g);
		
	}
	
	public void paintBackGround(Graphics g) {
		
		g.drawImage(FONDO,0,0,this);
	}
	  
	  
	  
	  
	  
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();

		if (comando.equals(SOLITARIO)) {
			
			
			
//			btMultijugador.setVisible(false);
//			btSolitario.setVisible(false);
//			lbEscoger.setVisible(false);
			panelInicial.getVentana().remove(this);
			panelInicial.getVentana().add(panelInicial.getpEscogerEquipo());
			panelInicial.getVentana().refresh();
		}
		
		if (comando.equals(MULTIJUGADOR)) {
			
//			btMultijugador.setVisible(false);
//			btSolitario.setVisible(false);
//			lbEscoger.setVisible(false);
			panelInicial.getVentana().remove(this);
			panelInicial.getVentana().add(panelInicial.getpEscogerEquipo());
			panelInicial.getVentana().refresh();
		}
		
		if (comando.equals(REGRESAR)) {
			
//			btMultijugador.setVisible(true);
//			btSolitario.setVisible(true);
//			lbEscoger.setVisible(true);
//			
//			btMultijugador.setVisible(true);
//			btSolitario.setVisible(true);
//			lbEscoger.setVisible(true);
			
			panelInicial.getVentana().remove(this);
			panelInicial.getVentana().add(panelInicial);
			panelInicial.getVentana().refresh();
		}
	}
	  
	  
	  
	  
	  
//	  private  int tipoDeJuego() {
//		  
//		  int op = JOptionPane.showOptionDialog(null,"Escoge una opcion", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,  null,
//		new String[] {"Multijugador" , "Un jugador"}, null );
//		  
//		  
//		  return op;
//	  }
}
