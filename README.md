# Employee and Designation Mapping Constraints

This project demonstrates the mapping constraints between `Employee` and `Designation` entities in a Spring Boot application without using any primary key or unique key.

## Employee Entity
The `Employee` entity represents an employee in the system. It contains the following attributes:

- `empCode`: The employee code (not a primary key in this example).
- `employeeDetails`: An embedded object containing details like name, phone, and email.
- `city`, `state`, `country`: Strings representing the employee's address.
- `company`: The name of the company where the employee works.
- `designation`: A transient one-to-one relationship with the `Designation` entity.

## EmployeeDetails Embeddable
The `EmployeeDetails` class represents the embedded details of an employee. It contains the following attributes:

- `name`: The name of the employee.
- `phone`: The phone number of the employee.
- `email`: The email address of the employee, which is marked as unique and nullable false in the database.

## Designation Entity
The `Designation` entity represents the designation or role of an employee. It contains the following attributes:

- `designationDetails`: An embedded object containing details like designation code and name.
- `employee`: A transient one-to-one relationship with the `Employee` entity.
- `designationDescription`: A description of the designation.

## DesignationDetails Embeddable
The `DesignationDetails` class represents the embedded details of a designation. It contains the following attributes:

- `designationCode`: The code assigned to the designation.
- `designationName`: The name of the designation.

## Mapping
- The `Employee` entity has a one-to-one relationship with the `Designation` entity, but it's transient, meaning it's not saved in the database. This relationship is mapped using `@OneToOne`.
- The `Employee` entity embeds `EmployeeDetails` for basic employee information.
- The `Designation` entity embeds `DesignationDetails` for basic designation information.

## Constraints
- The `email` attribute in `EmployeeDetails` is marked as unique and nullable false, ensuring that each employee has a unique email address and that the email address cannot be null.

Please note that this example does not include primary keys or unique keys to simplify the demonstration of mapping and constraints.
