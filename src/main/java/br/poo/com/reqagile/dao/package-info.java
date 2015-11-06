/**
 * Pacote responsável por armazenar as DAO's(Data Access Object) do projeto.
 * Dentro de cada classe desse pacote há métodos que fazem a comunicação direta com a
 * camada de persistência, retirando a responsabilidade de outras camadas do padrão MVC.
 * 
 * Existem aqui classes:
 * 
 * Interfaces (Puramente abstratas): têm a terminação DAO. Contém apenas a assinatura dos
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
 * É importante saber que duas classes de operações genéricas são utilizadas: GenericDAO e GenericDAOImplAbstract.
 * 
 * As classes devem serguir o padrão NomeDAO ou NomeDAOImpl ou NomeDAOImplAbstract com a extensão .java
 * 
 */
/**
 * @author Wellington Stanley
 *
 */
package br.poo.com.reqagile.dao;