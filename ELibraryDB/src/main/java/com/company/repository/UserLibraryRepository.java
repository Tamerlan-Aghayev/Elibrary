package com.company.repository;

import com.company.entity.LibraryEntity;
import com.company.entity.UserEntity;
import com.company.entity.UserLibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLibraryRepository extends JpaRepository<UserLibraryEntity, Integer> {

    @Query("select u from UserLibraryEntity u where u.userByUserId=:user and u.libraryByLibraryId=:library")
    public UserLibraryEntity getByIDs(@Param("user") UserEntity user, @Param("library")LibraryEntity library);
    @Query("select u from UserLibraryEntity u where u.libraryByLibraryId=:library")
    public List<UserLibraryEntity> getByLibrary(@Param("library")LibraryEntity library);

}
