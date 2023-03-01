package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class RedesController {
	public RedesController () {
		super();
	 
 }
     // Retorna o S.O que está na máquina 
 	private String os() {
	 String os = System.getProperty("os.name");
	 return os;
 }
 	public void  readProcess () {
 		// ver se é Windowns 
 		if(os().contains("Windows")) {
 		try {
		 Process p = Runtime.getRuntime().exec("IPCONFIG");
		InputStream fluxo = p.getInputStream();
		InputStreamReader leitor= new InputStreamReader(fluxo);
		BufferedReader buffer= new BufferedReader(leitor);
		String linha = buffer.readLine();
		while(linha!=null) {
			if(linha.contains("Adaptador")) {
					System.out.println(linha);
				}
				if(linha.contains("IPv4")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
		}
		buffer.close();
		leitor.close();
		fluxo.close();
			

		} catch (Exception e) {
			 e.printStackTrace();
			
		}
 		
 		}
 		else if(os().contains("Linux")) {
 				try {
 					Process p = Runtime.getRuntime().exec("ifconfig");
 					InputStream fluxo = p.getInputStream();
 					InputStreamReader leitor= new InputStreamReader(fluxo);
 					BufferedReader buffer= new BufferedReader(leitor);
 					String linha = buffer.readLine();
 					while(linha!=null) {
 						if(linha.contains("flags")) {
 							System.out.println(linha);
 						}
 						if(linha.contains("inet") && !linha.contains("inet6")) {
 							System.out.println(linha.split("netmask")[0]);
 						}
 					}
 						
 						linha = buffer.readLine();
 					buffer.close();
 		 			leitor.close();
 		 			fluxo.close();
 		 			
 				} catch (IOException e) {
 					e.printStackTrace();
 				}
 			}
 	}
	public void ping() {
		if(os().contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor= new InputStreamReader(fluxo);
				BufferedReader buffer= new BufferedReader(leitor);
				String linha = buffer.readLine();
				String linha2="";
				while(linha != null) {
						System.out.println(linha);
						linha2=linha;
						linha = buffer.readLine();
					}
			
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
				if (os().contains("Windows")) {
					JOptionPane.showMessageDialog(null, "Média = " + linha2.split(" = ")[3]);
				}
		
				
			}		
			 catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro de conectividade ao endereço solicitado", "Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		
			}
		else if(os().contains("Linux")) {
				try {
					Process p = Runtime.getRuntime().exec("PING -4 -c 10 www.google.com.br");
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor= new InputStreamReader(fluxo);
					BufferedReader buffer= new BufferedReader(leitor);
					String linha = buffer.readLine();
					String linha2="";
					while(linha!=null) {
						System.out.println(linha);
						linha2=linha;
						linha = buffer.readLine();
					}
						
					linha = buffer.readLine();
					buffer.close();
		 			leitor.close();
		 			fluxo.close();
		 			
		 			if (os().contains("Linux")) {
						JOptionPane.showMessageDialog(null, "Média = " + linha2.split("/")[4]+"ms");
					}
		 			
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erro de conectividade ao endereço solicitado", "Error",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		
	}
}
