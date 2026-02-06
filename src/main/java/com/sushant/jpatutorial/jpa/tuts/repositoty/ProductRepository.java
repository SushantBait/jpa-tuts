package com.sushant.jpatutorial.jpa.tuts.repositoty;

import com.sushant.jpatutorial.jpa.tuts.entites.ProductEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitleOrderByPrice(String title);

    List<ProductEntity> findByTitle(String title);

//    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

//    List<ProductEntity> findByQuantityGraterThanAndPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContaining(String title);

//    Optional<ProductEntity> findByTitleAndPrice(String coke, BigDecimal bigDecimal);

//    //JPQL query used to fetch data from DB
//    @Query("Select e from ProductEntity e where e.title=?1 and e.price=?2")
//    Optional<ProductEntity> findByTitleAndPrice(String coke, BigDecimal bigDecimal);


    //JPQL custom query used to fetch data from DB
    @Query("Select e from ProductEntity e where e.title=:title and e.price=:price")
    Optional<ProductEntity> findByTitleAndPrice(String coke, BigDecimal bigDecimal);

    List<ProductEntity> findAllByOrderByPriceAsc();

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, PageRequest of);
}



/*  ***************** JPA (Java Persistence API)   *****************

JPA is a specification for object-relational mapping (ORM) in Java.

It defines a set of interfaces and annotations for mapping Java objects to database tables and vice versa.

****************************************************************
JPA is a specification for object-relational mapping (ORM) in Java.

A It defines a set of interfaces and annotations for mapping Java objects to database tables and vice versa.

JPA itself is just a set of guidelines and does not provide any implementation. The implementation of JPA is provided by ORM frameworks such as Hibernate, EclipseLink, and OpenJPA.

Hibernate is one such JPA Provider.

However,

Hibernate is a specific implementation of JPA and a powerful ORM framework on its own. It offers additional features and optimizations beyond the JPA specification, making it a popular choice for ORM ir Java applications.

****************    Key features of JPA *******************

1. Entity Management: Defines how entities (Java objects) are persisted to the database.

2. Query Language: Provides JPQL (Java Persistence Query Language) for querying entities.

3. Transactions: Manages transactions, making it easier to handle database operations within a transactional context.

4. Entity Relationships: Supports defining relationships between entities (e.g., One-to-One, One-to-Many, Many-to-One, Many-to-Many).

****************   Spring Data JPA  *****************

Spring Data JPA is a part of the larger Spring Data family.

It builds on top of JPA, providing a higher-level and more convenient abstraction for data access.

Spring Data JPA makes it easier to implement JPA-based repositories by providing boilerplate code, custom query methods, and various utilities to reduce the amount of code you need to write.
 */



/*
  *************************  Rules for Method Names   **************************

1. The name of our query method must start with one of the following prefixes: find...By, read...By, query...By, and get...By.

Examples: findByName, readByName, queryByName, getByName

2. If we want to limit the number of returned query results, we can add the First or the Top keyword before the first By word.

Examples: findFirstByName, readFirst2ByName, findTop10ByName

3. If we want to select unique results, we have to add the Distinct keyword before the first By word.

Examples: findDistinctByName or findNameDistinctBy

4. Combine property expression with AND and OR.

Examples: findByNameOrDescription, findByNameAndDescription

5. Checkout official docs
https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html

*
 */