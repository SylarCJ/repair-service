package ust.augury.interview.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FixAreaDetails {

    private String areaType;

    private List<Component> components;
}
