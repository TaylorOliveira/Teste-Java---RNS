### Feature Controle de Estoque

You must create an inventory control feature.
- The entity that will be responsible for stock control must list products with a branch and indicate the quantity of items available for that product.
- Remember that to build all the necessary structure so that this feature can be consumed via rest.
- There must be an endpoint that allows the transfer of a product from one branch to another.
- All endpoints of this API must be working properly.
- You have complete freedom to make any changes to the project that you think are relevant, as long as it continues to meet the main objectives of the API.

### Create Product
```
post: http://localhost:8080/api/product
{
    "name":"PRODUTO A",
    "stockQuantity": 10,
    "code": 5162554-7 
}
```
### Create Branch
```
post: http://localhost:8080/api/branch
{
    "name":"EMPRESA A",
    "code":"8645154-8"
}
```
### Create BranchProduct
```
post: http://localhost:8080/api/branchProduct
{
    "quantity": 10, 
    "branchId": 1, 
    "productId": 1,
    "transferDate":"2020-05-10"
}
```
