package by.ryabchikov.lab1.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public abstract class Shape implements Serializable {
    protected Point startPoint;
    protected String color = "lime";
}
