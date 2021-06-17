package com.qin.management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Integer gander;
    private String email;
    private LocalDate birthday;
    private Float salary;
    private LocalDate createTime;
    private Department department;
}
