# SimpleBankingApp

Database - H2 in memory database
data.sql and schemal.sql files are present in resource folder. They execute automatically while server up.
But some times data.sql don't execute automatically. So execute manually using http://localhost:8080/h2-console

While server up database view created as table. so delete table <view name> then execute view query manually.


APIs
http://localhost:8080/api/customer/{userId}/getCustomerById/{customerId}
userId - raj2020 , customerId=3
http://localhost:8080/api/customer/{userId}/getAllCustomers
userId - staff1
http://localhost:8080/api/account/{userId}/getByAccountNumber/{accountNumber}
userId -raj2020 , account Number - 8000145
http://localhost:8080/api/accountDetail/{userId}/getAllAccountDetailsByCustomerId/{customerId}

http://localhost:8080/api/search/
payload - 
{
    "firstName": "randhir"
} 

