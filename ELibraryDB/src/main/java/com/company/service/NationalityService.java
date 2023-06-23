package com.company.service;


import com.company.entity.AuthorEntity;
import com.company.entity.NationalityEntity;
import com.company.repository.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class NationalityService {
    @Autowired
    private NationalityRepository nationalityRepository;
    public List<NationalityEntity> getAll(){

        return nationalityRepository.findAll();
    }

    public NationalityEntity getByNationality(String nationality){
        return nationalityRepository.findByNationality(nationality);
    }
    public NationalityEntity getByCountry(String country){
        return nationalityRepository.findByCountry(country);
    }
    public void addNationality(NationalityEntity nationality){
        nationalityRepository.saveAndFlush(nationality);
    }
    public void deleteNationality(String name){
        NationalityEntity nationality=getByNationality(name);
        nationalityRepository.delete(nationality);
    }
    public void deleteCountry(String name){
        NationalityEntity country=getByCountry(name);
        nationalityRepository.delete(country);
    }
}
