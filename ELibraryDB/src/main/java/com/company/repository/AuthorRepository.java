package com.company.repository;

import com.company.entity.AuthorEntity;
import com.company.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    @Query("Select b from AuthorEntity b where b.name=:name and b.surname=:surname")
    AuthorEntity findByName(@Param("name") String name,@Param("surname")String surname);
}
