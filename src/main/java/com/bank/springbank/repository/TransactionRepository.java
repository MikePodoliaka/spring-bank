package com.bank.springbank.repository;

import com.bank.springbank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    @Query(value = "SELECT * FROM transaction t" +
            " WHERE t.sender_name LIKE %:keyword%", nativeQuery = true)
    List<Transaction> findByKeyword(@Param("keyword") String keyword);
}
