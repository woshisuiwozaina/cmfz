package com.baizhi.entity;

/**
 * Created by Administrator on 2018/6/3 0003.
 */
public class China {
    private String name;
    private Integer value;

    public China() {
    }

    public China(String name, Integer value) {

        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "China{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
