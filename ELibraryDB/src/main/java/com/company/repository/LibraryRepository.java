package com.company.repository;

import com.company.entity.BookEntity;
import com.company.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {
    @Query("Select b from LibraryEntity b where b.name=:name")
    LibraryEntity findByName(@Param("name") String name);
    @Query("Select b from LibraryEntity b where b.address=:address")
    LibraryEntity findByAddress ( @Param("address") String address);
}
