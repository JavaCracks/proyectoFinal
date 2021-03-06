package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.LaminaNoObtenidaException;
import junit.framework.TestCase;
import modelo.Album;
import modelo.Constantes;
import modelo.Jugador;
import modelo.Lamina;
import modelo.Pagina;

class JugadorTest extends TestCase implements Constantes{
        
	
	private Jugador jugador;
	
	Album album;
	public void escenario1() {
		jugador = new Jugador("juan", "1234");
				
				album = jugador.getAlbum();
	
	}
	
	
	public void escenario2() {
		jugador = new Jugador("juan", "1234");
		
	Lamina lamina1 = new Lamina("messi", 4);
	Lamina lamina2 = new Lamina("james", 3);
	Lamina lamina3 = new Lamina("falcao", 2);
	Lamina lamina4 = new Lamina("salah", 1);

	jugador.agregarLamina(lamina1);
	jugador.agregarLamina(lamina2);
	jugador.agregarLamina(lamina3);
	jugador.agregarLamina(lamina4);
	}
	
	/**
	 * verifica que se agregan correctamente los false al arreglo
	 */
	@Test
	public void testiniciarFalse() {
		
		escenario1();
		
		for (int i = 0; i < jugador.getLaminasObtenidas().length; i++) {
			   assertFalse(jugador.getLaminasObtenidas()[i]);
		}
	}
	
	/**
	 * verifica que se agregan laminas correctamente
	 */
	@Test
	public void testAgregarLamina() {
		
		escenario1();
		
		Lamina lamina1 = new Lamina("messi", 1);
		Lamina lamina2 = new Lamina("james", 2);
		Lamina lamina3 = new Lamina("falcao", 3);
		Lamina lamina4 = new Lamina("salah", 4);

		jugador.agregarLamina(lamina1);
		jugador.agregarLamina(lamina2);
		jugador.agregarLamina(lamina3);
		jugador.agregarLamina(lamina4);
		
		
		assertEquals(4, jugador.getLaminas().size());
		
	}
	
	/**
	 * verifica que se actualizar correctamente el valor booleano del arreglo
	 */
	@Test
	public void testVerificarTrue() {
		
		
		
		escenario1();
		
		Lamina lamina1 = new Lamina("messi", 1);
		Lamina lamina2 = new Lamina("james", 2);
		Lamina lamina3 = new Lamina("falcao", 3);
		Lamina lamina4 = new Lamina("salah", 4);

		jugador.agregarLamina(lamina1);
		jugador.agregarLamina(lamina2);
		jugador.agregarLamina(lamina3);
		jugador.agregarLamina(lamina4);
		
		
		assertTrue(jugador.getLaminasObtenidas()[1]);
		assertTrue(jugador.getLaminasObtenidas()[2]);
		assertTrue(jugador.getLaminasObtenidas()[3]);
		assertTrue(jugador.getLaminasObtenidas()[4]);

		
		
	}
	
	/**
	 *  verifica que se actualiza la informacion de las laminas para poder ser pintadas correctamente en el album
	 */
	@Test
	public void testActualizarLaminasObtenidas() {
		
		escenario1();
		
		
		Lamina lamina1 = new Lamina("messi", 1);
		Lamina lamina2 = new Lamina("james", 2);
		Lamina lamina3 = new Lamina("falcao",3);
		Lamina lamina4 = new Lamina("salah", 4);
         
		jugador.agregarLamina(lamina1);
		jugador.agregarLamina(lamina2);
		jugador.agregarLamina(lamina3);
		jugador.agregarLamina(lamina4);
		
      
		 
		assertTrue(album.getPrimero().getLaminas()[0].estaObtenida());
		assertTrue(album.getPrimero().getLaminas()[1].estaObtenida());
		assertTrue(album.getPrimero().getLaminas()[2].estaObtenida());
		assertTrue(album.getPrimero().getLaminas()[3].estaObtenida());

		//fgd

		
	}
	
	/**
	 * verifica que se ordena correctamente las laminas
	 * 
	 */
	@Test
	public void testOrdenar() {
		
		escenario2();
		
		
		jugador.ordenarLaminasObtenidas();
		assertEquals("salah", jugador.getLaminas().get(0).getJugador());
	}
	
	/**
	 * verifica que si se busca una lamina correctamente cuando existe.
	 */
      @Test
      public void testBuscarCorrectamente() {
    	       
    	  escenario2();
    	  
    	  try {
			Lamina lamina = jugador.buscarLamina(1);
			assertEquals("salah", lamina.getJugador());
		} catch (LaminaNoObtenidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      

  	/**
  	 * verifica que no se busca una lamina correctamente cuando  no existe.
  	 */
        @Test
        public void testBuscarInCorrectamente() {
      	       
      	  escenario2();
      	  
      	  try {
  			Lamina lamina = jugador.buscarLamina(5);
  			assertNotEquals("salah", lamina.getJugador());
  		} catch (LaminaNoObtenidaException e) {
  			// TODO Auto-generated catch block
  			System.out.println(e.getMessage());
  		}
        }
}
