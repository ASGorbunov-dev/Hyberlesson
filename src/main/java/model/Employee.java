package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "surname")
    private String surName;
    @Column(name = "name")
    private String name;
    @Column(name = "midlename")
    private String midleName;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "position")
    private String position;
    @Column(name = "active")
    private Boolean active;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", midleName='" + midleName + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", active=" + active +
                '}';
    }

}
