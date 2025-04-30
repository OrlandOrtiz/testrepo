
package com.personal.rest_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.personal.rest_server.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
