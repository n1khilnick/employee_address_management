# Employee Address Management 

## Built With
* `Java 17`
* `Maven 4.0.0`
* `MySql Ver 8.0.32`
* `Spring Boot 3.0.5`
*  `IntelliJ IDEA 2023.1 (Community Edition)`


## Data Flow

### 1. Model:
* It consists of **Employee** and **Address** entity classes along with their data members and member functions
* Used **_@Table_** and **_@Entity_** annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like _**@Data,**_ **@_NoArgsConstructor_**, **_@AllArgsConstructor_** getters and setters for those object generate automatically.
* Used **_@OneToOne**_ annotation to perform one to one mapping between Employee and Address.

### 2. Controller:
* It consists of **EmployeeController** and **AddressController** classes in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation **_@GetMapping_** , **_@PostMapping_** , **_@PutMapping_** , **_@DeleteMapping_** to map the HTTP web requests to the specific handler methods.

<br>

### API Reference:
<br>

>Employee's API References
<br>
> 
* Add Employee:
```*.sh-session
  http://localhost:8080/employee/
```

* Get all Employees:
```*.sh-session
  http://localhost:8080/employee/getAll
```

* Get Employee By ID:
```*.sh-session
  http://localhost:8080/employee/{employeeId}
```

* Update Employee by Job ID
```http
  http://localhost:8080/employee/{employeeId}/firstName/{firstName}/lastName/{lastName}
```

* Delete Employee by ID
```http
  http://localhost:8080/employee/{employeeId}
```
<br>

>Address's API References:
<br>

* Add Address:
```*.sh-session
  http://localhost:8080/address/
```

* Get all Addresses:
```*.sh-session
  http://localhost:8080/address/getAll
```

* Get Address By ID:
```*.sh-session
  http://localhost:8080/address/{addressId}
```

* Update Address's Street by Address ID
```http
  http://localhost:8080/address/{addressId}/{street}
```

* Delete Address by ID
```http
  http://localhost:8080/address/{addressId}
```

### 3. Service:
* It consists of **EmployeeService** and **AddressService** classes in which provide some business functionalities of every handler methods.
* Used _**@Service**_ annotation to indicate that a class belongs to the service layer.
* Used **_@Transactional_** annotation to separate transaction management code from the code for business logic on the update and delete methods.

### 4. Repository:
* It consists of **IEmployeeDao** and **IAddressDao** interface classes that extends CrudRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used **Iterable** for Employee and Address to manage the data of Employee and Address by performing CRUD operations.
* Used _**@Repository**_ annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
* Used **_@Modifying_** annotation wrote named parameters query using @Query annotation to insert, update, or delete an entity.

## Data Structure Used
Used `Iterable<T>` for Employee and Address to store the User type object.

## Project Summary
* In this project I performed CRUD operation like add user,get user,delete user and update user.<br/>
* The aim of this project to perform _**one to one**_ mapping between Employee and Address.
* Used interface CrudRepository class for generic CRUD inbuilt operations like save,saveAll,updateById, etc.
* Used our own custom finder methods and wrote operations using custom queries.
