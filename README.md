# RNS - JAVA
O JAVATeste é uma API desenvolvida na linguagem java e que utiliza o framework Spring Boot 2.3.3.RELEASE e Lombok com o objetivo de avaliar
os seus conhecimentos em Java 1.8. 
Essa API será hipoteticamente utilizada para controlar os estoques entre lojas e os nossos centros de estocagem. Gerênciando 
os processos de transferência entre as unidades.  

# Pré-requisitos
Este é um projeto Maven que utiliza o SpringBoot como framework. Logo para conseguir compila-lo é necessário ter o Maven instalado na sua máquina ou utilizar algum plugin Maven na sua IDE de preferência.
Para saber mais sobre como instala o Maven na sua máquina acesse http://maven.apache.org .

Ainda, este projeto utiliza Lombok, uma biblioteca Java que elimina a necessidade de criação de getters e setter. Para que a biblioteca funcione em tempo de compilação é necessário instalação de plugin na sua IDE.
Acesse https://projectlombok.org para mais informações.

## O que precisa ser desenvolvido:

### Feature Controle de Estoque

Você deverá criar uma feature de controle de estoque. 
- A entidade que será responsável pelo controle de estoque deve relacionar produtos com filial e indicar a quantidade de itens disponível para esse produto.
- Lembre-se que de construir toda a estrutura necessária para que essa feature possa ser consumida por via rest.
- Deve existir um endpoint que permita a transferência de um produto de uma filial para outra.
- Todos os endpoints dessa API devem estar funcionando adequadamente.
- Você tem total liberdade para fazer qualquer alteração no projeto que achar pertinente, desde que ele continue atendendo aos objetivos principais da API.

### Create Product
post: http://localhost:8080/api/product
{
    "name":"PRODUTO A",
    "stockQuantity": 10,
    "code": 5162554-7 
}

### Create Branch
post: http://localhost:8080/api/branch
{
    "name":"EMPRESA A",
    "code":"8645154-8"
}

### Create BranchProduct
post: http://localhost:8080/api/branchProduct
{
    "quantity": 10, 
    "branchId": 1, 
    "productId": 1,
    "transferDate":"2020-05-10"
}
