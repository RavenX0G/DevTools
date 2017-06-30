package com.mogul.xxm.devtools.refreshview;

/**
 * Time:6/30/2017 9:49 AM
 * Created by Curtain.
 */

public class Person {
    private String name, age;
    private int type;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String age, int type) {
        this.name = name;
        this.age = age;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
