package servidor;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * TODO: Complementa esta clase para que acepte conexiones TCP con clientes
 * para recibir un boleto, generar la respuesta y finalizar la sesion
 */
public class ServidorTCP {
	private String [] respuesta;
	private int [] combinacion;
	private int reintegro;
	private int complementario;

	/**
	 * Constructor
	 */
	public ServidorTCP (int puerto) {
		this.respuesta = new String [9];
		this.respuesta[0] = "Boleto inv�lido - N�meros repetidos";
		this.respuesta[1] = "Boleto inv�lido - n�meros incorretos (1-49)";
		this.respuesta[2] = "6 aciertos";
		this.respuesta[3] = "5 aciertos + complementario";
		this.respuesta[4] = "5 aciertos";
		this.respuesta[5] = "4 aciertos";
		this.respuesta[6] = "3 aciertos";
		this.respuesta[7] = "Reintegro";
		this.respuesta[8] = "Sin premio";
		generarCombinacion();
		imprimirCombinacion();
	}
	
	
	/**
	 * @return Debe leer la combinacion de numeros que le envia el cliente
	 */
	public String leerCombinacion () {
		String respuesta = "Sin hacer leer";
		return respuesta;
	}
	
	/**
	 * @return Debe devolver una de las posibles respuestas configuradas
	 */
	public String comprobarBoleto () {
		String respuesta = "Sin hacer comprobar";
		return respuesta;
	}

	/**
	 * @param respuesta se debe enviar al ciente
	 */
	public void enviarRespuesta (String respuesta) {
		
	}
	
	/**
	 * Cierra el servidor
	 */
	public void finSesion () {
		
	}
	
	/**
	 * Metodo que genera una combinacion. NO MODIFICAR
	 */
	private void generarCombinacion () {
		Set <Integer> numeros = new TreeSet <Integer>();
		Random aleatorio = new Random ();
		while (numeros.size()<6) {
			numeros.add(aleatorio.nextInt(49)+1);
		}
		int i = 0;
		this.combinacion = new int [6];
		for (Integer elto : numeros) {
			this.combinacion[i++]=elto;
		}
		this.reintegro = aleatorio.nextInt(49) + 1;
		this.complementario = aleatorio.nextInt(49) + 1;
	}
	
	/**
	 * Metodo que saca por consola del servidor la combinacion
	 */
	private void imprimirCombinacion () {
		System.out.print("Combinaci�n ganadora: ");
		for (Integer elto : this.combinacion) 
			System.out.print(elto + " ");
		System.out.println("");
		System.out.println("Complementario:       " + this.complementario);
		System.out.println("Reintegro:            " + this.reintegro);
	}

}

