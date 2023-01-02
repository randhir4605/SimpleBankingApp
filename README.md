# SimpleBankingApp

Database - H2 in memory database
data.sql and schemal.sql files are present in resource folder. They execute automatically while server up.
But some times data.sql don't execute automatically. So execute manually using http://localhost:8080/h2-console

While server up database view created as table. so delete table <view name> then execute view query manually.


APIs
http://localhost:8080/account/getById/8000145
http://localhost:8080/customer/getCustomerById/3
http://localhost:8080/accountDetail/getAllAccountDetailsByCustomerId/3
http://localhost:8080/customer/getAllCustomers
http://localhost:8080/search/

payload - 
{
    
    "firstName": "randhir"
} 

