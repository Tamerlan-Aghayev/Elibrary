package com.company.repository;

import com.company.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    @Query("Select b from BookEntity b where b.name=:name")
    BookEntity findByName(@Param("name") String name);
}
