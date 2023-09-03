package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "elibrary", catalog = "postgres")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "status")
    private String status;

    @Basic
    @Column(name = "author")
    private String author;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "library_id", referencedColumnName = "id", nullable = false)
    private LibraryEntity libraryByLibraryId;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id  && Objects.equals(name, that.name) && Objects.equals(status, that.status) && Objects.equals(author, that.author) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, author);
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public LibraryEntity getLibraryByLibraryId() {
        return libraryByLibraryId;
    }

    public void setLibraryByLibraryId(LibraryEntity libraryByLibraryId) {
        this.libraryByLibraryId = libraryByLibraryId;
    }
}
