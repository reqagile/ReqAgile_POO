/**
 * Pacote responsável por armazenar as Service's do projeto. Service's são utilizadas
 * para fazer uma mediação entre o model e a persist. Aciona a DAO para que uma operação
 * seja realizada no banco. Assim, a indepedência e forma genérica é mantida.
 * 
 * Dentro de cada classe desse pacote há métodos que acionam e delegam tarefas para as
 * DAO's.
 * 
 * Existem aqui classes:
 * 
 * Interfaces (Puramente abstratas): têm a terminação Service. Contém apenas a assinatura dos
 * métodos que serão utilizados por ela.
 * 
 *  
 * Abstratas: têm a terminação Abstract. Contém a implementação de métodos (concretos) , mas
 * também contém a assinatura dos métodos que poderão ser sobrescritos (Override).
 * 
 * 
 * Implementações: têm a terminação Impl. Contém a implementação das assinaturas e ou sobrescreve
 * métodos abstratos ou não. Utiliza a nomenclatura na assinatura extends ou implements para, 
 * repectivamente, Abstratas e Interfaces.
 * 
 * 
 * É importante saber que duas classes de operações genéricas são utilizadas: GenericService e GenericServiceImplAbstract.
 * Estas classes são utilizadas para o auxilio de comunicação com as DAO's genéricas.
 * 
 * As classes devem serguir o padrão NomeService ou NomeServiceImpl ou NomeServiceImplAbstract com a extensão .java
 * 
 */
/**
 * @author Wellington Stanley
 *
 */
package br.poo.com.reqagile.service;