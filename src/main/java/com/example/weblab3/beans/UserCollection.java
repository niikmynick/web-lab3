package com.example.weblab3.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;


@Named
@ApplicationScoped
public class UserCollection implements java.io.Serializable {
    private List<Hit> collection;

    public UserCollection() {
        collection = new ArrayList<>();
    }

    public List<Hit> getCollection() {
        return collection;
    }

    public void setCollection(List<Hit> collection) {
        this.collection = collection;
    }

    public void insertHit(Hit hit) {
        this.collection.add(0, hit);
    }

    @Override
    public String toString() {
        return "UserCollection{" + "collection=" + collection + '}';
    }

}