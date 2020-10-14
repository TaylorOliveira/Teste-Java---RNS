# Stock Manage

Simple stock manage software

  - Register Branch
  - Register Product
  - Listing Branchs
  - Listing Products
  - Transfer Product from Branch
 
### Installation
 
With Java e Maven configurado execute
```
mvn install
```

### Tech

Technologies used

* [Java] - Version 8

License
----

Software free



#### Create Product
```
post: http://localhost:8080/api/product
{
    "name":"PRODUTO A",
    "stockQuantity": 10,
    "code": 5162554-7 
}
```
#### Create Branch
```
post: http://localhost:8080/api/branch
{
    "name":"EMPRESA A",
    "code":"8645154-8"
}
```
#### Create BranchProduct
```
post: http://localhost:8080/api/branchProduct
{
    "quantity": 10, 
    "branchId": 1, 
    "productId": 1,
    "transferDate":"2020-05-10"
}
```
