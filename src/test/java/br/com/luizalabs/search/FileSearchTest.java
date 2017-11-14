package br.com.luizalabs.search;

import org.junit.Assert;
import org.junit.Test;

import br.com.luizalabs.search.executor.FileSearch;

public class FileSearchTest {
	
	@Test
	public void testeExpressao()  throws Exception {
		Assert.assertTrue( new FileSearch().execute("walt disney").size() > 0);
	}
	
	@Test
	public void testeExpressaoNaoEncontrada() throws Exception {
		Assert.assertTrue( new FileSearch().execute("用中文表達").size() == 0);
	}
	
	@Test
	public void testeExpressaoRobertTaylor()  throws Exception {
		Assert.assertTrue( new FileSearch().execute("robert taylor").size() == 13);
	}
	
}
