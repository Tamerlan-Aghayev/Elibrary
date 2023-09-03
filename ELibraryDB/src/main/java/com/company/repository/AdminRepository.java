package com.company.repository;

import com.company.entity.AdminEntity;
import com.company.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    @Query("select u from AdminEntity u where u.username=:username and u.password=:password")
    public PrivilegeEntity login(@Param("username")String username, @Param("password")String password);
}
