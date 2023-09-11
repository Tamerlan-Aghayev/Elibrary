package com.company.repository;

import com.company.entity.LibraryEntity;
import com.company.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("select u from UserEntity u  JOIN FETCH u.userLibrariesById ul JOIN FETCH ul.libraryByLibraryId where ul.libraryByLibraryId=:library and u.name=:name and u.surname=:surname")
    public UserEntity getUser(@Param("name")String name, @Param("surname") String surname, @Param("library") LibraryEntity library);

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.userLibrariesById ul JOIN FETCH ul.libraryByLibraryId where ul.libraryByLibraryId=:library")
    List<UserEntity> getAll(@Param("library")LibraryEntity library);
    @Query("SELECT u FROM UserEntity u JOIN FETCH u.userLibrariesById ul JOIN FETCH ul.libraryByLibraryId where u.fin=:fin and u.name=:name and u.surname=:surname and u.username=:username and u.address=:address")
    UserEntity getByFin(@Param("name")String name, @Param("surname")String surname, @Param("username")String username, @Param("fin")String fin, @Param("address")String address);
    @Query("select u from UserEntity u  JOIN FETCH u.userLibrariesById ul JOIN FETCH ul.libraryByLibraryId where u.username=:username")
    public UserEntity getUserByUsername(@Param("username")String username);

}
