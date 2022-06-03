package com.walmart.queuedatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleModel implements Serializable {

    private String person_ID;

    private String name;

    private String first;

    private String last;

    private String middle;

    public String email;

    public String phone;

    public String fax;

    public String title;
}
