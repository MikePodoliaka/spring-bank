package com.bank.springbank.repository;

import com.bank.springbank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM client c WHERE" +
            " c.first_name LIKE %:keyword% or c.last_name LIKE %:keyword%", nativeQuery = true)
    List<Client> findByKeyword(@Param("keyword") String keyword);
}
