package com.company.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "nationality", schema = "elibrary", catalog = "elibrary")
public class NationalityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "nationality")
    private String nationality;
    @OneToMany(mappedBy = "nationality")
    private List<AuthorEntity> authorsByIdNationality;
    @OneToMany(mappedBy = "country")
    private List<AuthorEntity> authorsByIdCountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NationalityEntity that = (NationalityEntity) o;
        return id == that.id && Objects.equals(country, that.country) && Objects.equals(nationality, that.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, nationality);
    }

    public List<AuthorEntity> getAuthorsById() {
        return authorsByIdNationality;
    }

    public void setAuthorsById(List<AuthorEntity> authorsById) {
        this.authorsByIdNationality = authorsById;
    }

    public List<AuthorEntity> getAuthorsById_0() {
        return authorsByIdCountry;
    }

    public void setAuthorsById_0(List<AuthorEntity> authorsById_0) {
        this.authorsByIdCountry = authorsById_0;
    }
}
