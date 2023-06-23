package com.company.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "elibrary", catalog = "elibrary")
public class BookEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private AuthorEntity author;
    @ManyToOne
    @JoinColumn(name = "library_id", referencedColumnName = "id", nullable = false)
    private LibraryEntity library;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public AuthorEntity getAuthorByAuthorId() {
        return author;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.author = authorByAuthorId;
    }

    public LibraryEntity getLibraryByLibraryId() {
        return library;
    }

    public void setLibraryByLibraryId(LibraryEntity libraryByLibraryId) {
        this.library = libraryByLibraryId;
    }
}
