package com.company.entity;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author", schema = "elibrary", catalog = "elibrary")
public class AuthorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "birth_year")
    private int birthYear;


    @ManyToOne
    @JoinColumn(name = "nationality_id", referencedColumnName = "id", nullable = false)
    private NationalityEntity nationality;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private NationalityEntity country;
    @OneToMany(mappedBy = "author")
    private List<BookEntity> booksById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return id == that.id  && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(birthYear, that.birthYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthYear);
    }

    public NationalityEntity getNationalityByNationalityId() {
        return nationality;
    }

    public void setNationalityByNationalityId(NationalityEntity nationalityByNationalityId) {
        this.nationality = nationalityByNationalityId;
    }

    public NationalityEntity getNationalityByCountryId() {
        return country;
    }

    public void setNationalityByCountryId(NationalityEntity nationalityByCountryId) {
        this.country = nationalityByCountryId;
    }

    public List<BookEntity> getBooksById() {
        return booksById;
    }

    public void setBooksById(List<BookEntity> booksById) {
        this.booksById = booksById;
    }
}
