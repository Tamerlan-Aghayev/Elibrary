package com.company.repository;


import com.company.entity.NationalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalityRepository extends JpaRepository<NationalityEntity, Integer> {
    @Query("Select b from NationalityEntity b where b.nationality=:nationality")
    NationalityEntity findByNationality(@Param("nationality") String nationality);
    @Query("Select b from NationalityEntity b where b.country=:country")
    NationalityEntity findByCountry(@Param("country") String country);
}
