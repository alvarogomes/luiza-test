#Desafio Técnico Luiza Labs

### Introdução

Para completar este desáfio desenvolvi a solução utilizando somente código nativo Java 8, utilizando Stream para realizar a consulta em todos os arquivos contidos dentro de um arquivo Zip.

O aplicativo faz o download no momento da execução da aplicação e realiza a consulta em todos os arquivos e retorna a lista dos arquivos onde foram encontrados os resultados.


### Gerando build

Para gerar o build da aplicação basta executar o comando Maven:

```
mvn clean package
```
Com este comando será gerado o Jar chamado: luiza-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar


### Executando aplicação

Para executar a aplicação basta digitar o comando abaixo:

```
java -jar target/luiza-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar "robert taylor"
```
O aplicativo irá mostrar os resultados abaixo:

```
Foram encontradas 13 ocorrência(s) pelo termo: robert taylor
Os arquivos que possuem "robert taylor" são:
data/above-and-beyond.txt
data/all-the-brothers-were-valiant.txt
data/conspirator.txt
data/d-day-the-sixth-of-june.txt
data/escape.txt
data/flight-command.txt
data/johnny-eager.txt
data/lady-of-the-tropics.txt
data/magnificent-obsession.txt
data/moto-4-the-movie.txt
data/personal-property.txt
data/the-last-hunt.txt
data/the-law-and-jake-wade.txt
```


### Testes Unitários


Para executar os testes unitários implementados utilizando JUnit basta digitar o comando abaixo:

```
mvn clean test
```