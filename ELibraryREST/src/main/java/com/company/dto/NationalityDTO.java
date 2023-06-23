package com.company.dto;

import com.company.entity.AuthorEntity;
import com.company.entity.NationalityEntity;

import java.util.ArrayList;
import java.util.List;

public class NationalityDTO {
    private int id;

    public int getId() {
        return id;
    }

    public NationalityDTO(NationalityEntity nationality) {
        this.id = nationality.getId();
        this.nationality = nationality.getNationality();
        this.country = nationality.getCountry();
        List<AuthorEntity> list =nationality.getAuthorsById();
        List<AuthorDTO> dto= new ArrayList<>();

        for(AuthorEntity l:list){
            dto.add(new AuthorDTO(l));

        }
        this.authors=dto;
    }

    public NationalityDTO() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
    }

    private String nationality;
    private String country;
    private List<AuthorDTO> authors;
}
