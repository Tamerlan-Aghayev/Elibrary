package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_library", schema = "elibrary", catalog = "postgres")
public class UserLibraryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "library_id", referencedColumnName = "id", nullable = false)
    private LibraryEntity libraryByLibraryId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "library_id")
    private int libraryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLibraryEntity that = (UserLibraryEntity) o;
        return id == that.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }
}
