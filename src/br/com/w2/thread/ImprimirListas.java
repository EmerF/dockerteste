package br.com.w2.thread;

import java.util.Collection;
import java.util.List;

public class ImprimirListas implements Runnable {

	private Collection<String> listaImagensImprimir;
	private String nomePrograma;
	private long inicio;
	private long fim;

	public void imprimirLista() {
		
		inicio = System.currentTimeMillis();
		getListaImagensImprimir().stream().forEach(texto -> {
			//System.out.println(texto);
		});
		fim = System.currentTimeMillis();
		
		System.out.println(getNomePrograma()+  " Sem thread Executou em " + (fim-inicio));

	}

	@Override
	public void run() {
		inicio = System.currentTimeMillis();
		System.out.println(getNomePrograma()+  " Com thread iniciou em " + inicio);
		getListaImagensImprimir().stream().forEach(texto -> {
			//System.out.println(texto);
		});
		
		fim = System.currentTimeMillis();
		System.out.println(getNomePrograma()+  " Com thread finalizou em " + fim);
		System.out.println(getNomePrograma()+  " Com thread Executou em " + (fim-inicio));
	}

	public Collection<String> getListaImagensImprimir() {
		return listaImagensImprimir;
	}

	public void setListaImagensImprimir(Collection<String> listaImagensImprimir) {
		this.listaImagensImprimir = listaImagensImprimir;
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

}
