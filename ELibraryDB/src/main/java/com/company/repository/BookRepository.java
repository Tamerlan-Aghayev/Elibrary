package com.company.repository;

import com.company.entity.BookEntity;
import com.company.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    @Query("Select b from BookEntity b where b.name=:name")
    BookEntity findByName(@Param("name") String name);
    @Query("select b from BookEntity b where b.name=:name and b.libraryByLibraryId=:library")
    BookEntity findByName(@Param("name") String name, @Param("library")LibraryEntity library);
    @Query("select b from BookEntity b where b.libraryByLibraryId=:library")
    List<BookEntity>  findByLibrary(@Param("library") LibraryEntity library);
}
