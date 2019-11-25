package br.com.w2.thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;

public class Inicial {
	
	public static void main(String[] args) throws IOException {
		Inicial inicial = new Inicial();
		inicial.carregaLista();
		inicial.criarDocumentoPdf();
	}
	
	private List<String> listaImagens;
	private List<String> listaImagens500;
	private List<String> listaImagens1000;
	int cont = 0;
	private String texto;
	
	
	public void criarDocumentoPdf() throws IOException {
		
		//Creating PDF document object 
	      PDDocument document = new PDDocument();    
	       
	      //Saving the document
	      document.save("/usr/tmp/test_pdf_container.pdf");
	         
	      System.out.println("Criado pdf de teste");  
	    
	      //Closing the document  
	      document.close();
		
	}
	
	
	public void carregaLista() {
		listaImagens = new ArrayList<String>();
		
		while(cont < 1000000) {
			texto = "texto " + cont;
			listaImagens.add(texto);
			cont ++;
		}
		
		
		ImprimirListas p1 = new ImprimirListas();
		p1.setNomePrograma("Programa 1");
		p1.setListaImagensImprimir(listaImagens);
		p1.imprimirLista();
		
		
		divideLista(listaImagens);
		p1.setListaImagensImprimir(listaImagens500);
		Thread t1 = new Thread(p1);
		t1.start();
		
		
		// ***********
		ImprimirListas p2 = new ImprimirListas();
		p2.setListaImagensImprimir(listaImagens1000);
		p2.setNomePrograma("Programa 2");

		Thread t2 = new Thread(p2);
		t2.start();
	}
	
	public void divideLista(List<String> listaImagens) {
		int metadeLista = listaImagens.size() / 2 ;
		listaImagens500 = listaImagens.subList(0, metadeLista);
		listaImagens1000 = listaImagens.subList(metadeLista, listaImagens.size());
		
		
			
	}

}
