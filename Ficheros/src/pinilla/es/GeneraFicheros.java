package pinilla.es;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeneraFicheros {
	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			File fichero=new File("registros.txt");
			if (fichero.exists()) {
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					fr = new FileReader(fichero);
					br = new BufferedReader(fr);
					
				String linea;
				while ((linea=br.readLine())!=null) {
						creaFicheros(linea);
				}
					
					
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						br.close();
						fr.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			} else {
				System.out.println("El fichero no existe");
			}
			
			
			sc.close();
		}
	private static void creaFicheros(String registro) {
		
		String[] tablaReg=registro.split(";");
		
		File fichero = new File(tablaReg[0] + ".txt");
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try {
				fw = new FileWriter(fichero);
				bw = new BufferedWriter(fw);
				
				bw.write("Nombre: " + tablaReg[1]);
				bw.newLine();
				bw.write("DNI: " + tablaReg[2]);
				bw.newLine();
				bw.write("Teléfono: " + tablaReg[3]);
				bw.newLine();
				bw.write("Nacionalidad: " + tablaReg[4].toUpperCase());
				bw.newLine();
				bw.write("Media: " + calculaMedia(tablaReg));			
				bw.flush();
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					bw.close();
					fw.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}
	private static String calculaMedia(String[] tablaReg) {
		float sumaT=0;
		
		for (int i = 5; i < tablaReg.length; i++) {
			sumaT+=Float.parseFloat(tablaReg[i]);
		}
		
		float media=sumaT/(tablaReg.length-5);
		
		
		return Float.toString(media);
	}

	}
