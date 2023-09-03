package com.company.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "elibrary", catalog = "postgres")
public class UserEntity {
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
    @Column(name = "fin")
    private String fin;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "userByUserId")
    private List<BookEntity> booksById;
    @OneToMany(mappedBy = "userByUserId")
    private List<UserLibraryEntity> userLibrariesById;

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

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(fin, that.fin) && Objects.equals(username, that.username) && Objects.equals(address, that.address) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, fin, username, address, password);
    }

    public List<BookEntity> getBooksById() {
        return booksById;
    }

    public void setBooksById(List<BookEntity> booksById) {
        this.booksById = booksById;
    }

    public List<UserLibraryEntity> getUserLibrariesById() {
        return userLibrariesById;
    }

    public void setUserLibrariesById(List<UserLibraryEntity> userLibrariesById) {
        this.userLibrariesById = userLibrariesById;
    }
}
