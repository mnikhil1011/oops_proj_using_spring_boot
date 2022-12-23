package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findByFirstName(String firstName);//this searches customer with first name provided
    List<Customer> findByFirstNameContaining(String name);//this searches name with first name having those characters
    List<Customer>findByLastNameNotNull();//needs to have last name

    //adding a query jpql query below 5:33:02 to underastand

    @Query("select c from Customer c where c.emailId=?1")
    Customer getCustomerByEmailId(String emailId);

    @Modifying
    @Transactional //used when we edit or del ig
    @Query
            (
                    value = "update tbl_customer set first_name =?1 where email_address=?2",
                    nativeQuery = true
            )

   int updateCustomerNameByEmailId(String firstName, String emailId);

    Customer findByEmailId(String email);


    Customer findByCustomerId(String id);

    Customer findByCustomerId(Long id);
}
