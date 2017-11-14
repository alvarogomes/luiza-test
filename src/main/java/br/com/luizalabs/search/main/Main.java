package br.com.luizalabs.search.main;

import java.util.List;

import br.com.luizalabs.search.executor.FileSearch;

public class Main {

	public static void main(String[] args) throws Exception {
		
		if (args.length != 1) {
			System.out.println("Coloque o parametro [Expressão a consultar]");
			return;
		}
		
		String exp = args[0];
		
		List<String> resultado = new FileSearch().execute(exp);
		
		System.out.println("Foram encontradas "+resultado.size()+ " ocorrência(s) pelo termo: " + exp);
		System.out.println("Os arquivos que possuem \""+exp+"\" são:");
		resultado.stream().forEach(System.out::println);
	}
	
}