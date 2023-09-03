package com.company.entity;

import javax.persistence.*;
import java.util.List;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "library", schema = "elibrary", catalog = "postgres")
public class LibraryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "libraryByLibraryId")
    private List<BookEntity> booksById;
    @OneToMany(mappedBy = "libraryByLibraryId")
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        LibraryEntity that = (LibraryEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, email, password);
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
