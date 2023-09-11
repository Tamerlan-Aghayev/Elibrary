package com.company.repository;

import com.company.entity.AdminEntity;
import com.company.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    @Query("select a from AdminEntity a where a.username=:username")
    AdminEntity getAdminByUSername(@Param("username") String username);
}

