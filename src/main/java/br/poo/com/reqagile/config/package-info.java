/**
 * Pacote responsável por armazenar o gerenciamento de inicialização e configuração do projeto.
 * Ele estabelece e habilita o padra webMVC do Spring Framework.
 * Dentro de cada classe desse pacote há métodos que configuram características do
 * comportamento do sistema. Elas podem utilizar arquivos externos ao pacote para poder realizar
 * operações de mapeamento dos framework's que serão utilizados, como, por exemplo, o Hibernate.
 * 
 * As classes também configuram o caminho dos recursos, sufixo das views, local das views,
 * transação de persistência, classes de mapeamento no banco etc.
 * 
 * É importante ressaltar que a Classe que executa as configurações é a WebMvcInitializer.java.
 * Tem o mérito de inicializar os procedimentos contidos nas classes inseridas dentro dela. O conjunto
 * desse pacote substitui as configurações feias através de .xml. 
 * 
 *  As classes devem serguir o padrão NomeConfig com a extensão .java
 * 
 */
/**
 * @author Wellington Stanley
 *
 */
package br.poo.com.reqagile.config;