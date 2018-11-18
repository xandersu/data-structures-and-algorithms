package com.xandersu.datastructuresandalgorithms.hashtable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @Author: suxun
 * @Date: 2018/11/18 13:59
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    int grade;
    int cls;
    String firstName;
    String lastName;

    @Override
    public int hashCode() {
        int b = 31;
        int hash = 0;
        hash = hash * b + grade;
        hash = hash * b + cls;
        hash = hash * b + firstName.toLowerCase().hashCode();
        hash = hash * b + lastName.toLowerCase().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Student another = (Student) o;
        return this.grade == another.grade
                && this.cls == another.cls
                && this.firstName.toLowerCase().equals(another.firstName)
                && this.lastName.toLowerCase().equals(another.lastName);
    }

}
