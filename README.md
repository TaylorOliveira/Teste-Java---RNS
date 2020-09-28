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
