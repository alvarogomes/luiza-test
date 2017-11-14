package br.com.luizalabs.search.executor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class FileSearch {
	
	public List<String> execute(String exp) throws Exception {

		List<String> retorno = new ArrayList<String>();
		
		
		String arquivo = new File("").getAbsolutePath();
		arquivo = arquivo.replace("\\","/");
		arquivo =  arquivo + "/movies.zip";
		
		//Download do arquivo...
		File file = new File(arquivo);
		if (!file.exists()) {
			URL website = new URL("https://s3-sa-east-1.amazonaws.com/luizalabs-tech-challenges/movies.zip");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(arquivo);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			rbc.close();
			file = new File(arquivo);
		}
		
		//Ordenar por ordem alfabetica...
		Comparator<ZipEntry> orderBy = (ze1, ze2) -> ze1.getName().compareTo(ze2.getName());
	            
        try (ZipFile zipFileArq = new ZipFile(file)) {
        	zipFileArq.stream()
        	.filter(ze -> consultarTexto(zipFileArq, ze, exp))
        	.sorted(orderBy)
        	.forEach( e -> retorno.add(e.getName()));
        	
        } catch (IOException e) {
        	throw new Exception("Erro ao abrir o arquivo ZIP");
        }
    	
		return retorno;
	}
	
	private boolean consultarTexto(ZipFile zipFile, ZipEntry zipEntry, String needle) {
	    try (InputStream inputStream = zipFile.getInputStream(zipEntry);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
	        Optional<String> found = reader.lines()
	                .filter(l -> l.contains(needle))
	                .findFirst();
	        return found.isPresent();
	    } catch (IOException e) {
	        return false;
	    }
	}
}
