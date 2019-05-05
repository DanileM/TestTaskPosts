package danilem.app.com.testtaskposts.repository.models;

import java.util.ArrayList;

import danilem.app.com.testtaskposts.repository.models.responses.model.User;

public class CategoryModel {
    private String name;
    private int number;
    ArrayList<User> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }
}
