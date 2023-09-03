package com.company.repository;

import com.company.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, Integer > {
    @Query("Select u from PrivilegeEntity u where u.username=:username and u.password=:password")
    public PrivilegeEntity getByUsernamePassword(@Param("username")String username, @Param("password") String password);
    @Query("Select u from PrivilegeEntity u where u.username=:username")
    public PrivilegeEntity getByUsername(@Param("username")String username);
    @Query("select u from PrivilegeEntity u where u.privilege='USER'")
    public List<PrivilegeEntity> getUsers();
    @Query("select u from PrivilegeEntity u where u.privilege='ADMIN'")
    public List<PrivilegeEntity> getAdmins();
}
