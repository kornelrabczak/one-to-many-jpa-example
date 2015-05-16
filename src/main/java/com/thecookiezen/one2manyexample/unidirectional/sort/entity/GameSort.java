package com.thecookiezen.one2manyexample.unidirectional.sort.entity;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

import javax.persistence.*;
import java.util.SortedSet;
import java.util.TreeSet;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
public class GameSort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String value;

    @OneToMany(cascade = ALL, fetch = EAGER)
    @JoinColumn
    @Sort(type = SortType.NATURAL)
    private SortedSet<GameImage> images = new TreeSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SortedSet<GameImage> getImages() {
        return images;
    }

    public void setImages(SortedSet<GameImage> images) {
        this.images = images;
    }
}
