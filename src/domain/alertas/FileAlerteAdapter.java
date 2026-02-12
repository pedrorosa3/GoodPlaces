package domain.alertas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import domain.Utilizador;

/**
 * Classe que define O FileAlerteAdapter
 * @author ADS
 */
public abstract class FileAlerteAdapter implements IAlerteAdapter {
	
	
	/**
	 * Envia alertas para um ficheiro
	 * @param u - objeto Utilizador
	 * @param evento - objeto EventoAlerte
	 * @requires u,evento != null
	 */
	public void enviaAlerte(Utilizador u , EventoAlerte evento)  {
		
		String filePath = "../nome.txt";
		
		String nome = u.obtemNome();
		
		String textoParaAdicionar="oi"+nome;
		
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filePath, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        try {
			writer.write(textoParaAdicionar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

}
