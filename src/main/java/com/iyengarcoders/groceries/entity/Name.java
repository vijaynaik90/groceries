package com.iyengarcoders.groceries.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Name {

    @NotNull
    @Size(min = 3 , max = 40, message = "First name can be min of 3 and max 40 characters")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 3 , max = 40, message = "Middle name can be min of 3 and max 40 characters")
    @Column(name = "middle_name")
    private String middleName;

    @Size(min = 3 , max = 40, message = "Last name can be min of 3 and max 40 characters")
    @Column(name = "last_name")
    private String lastName;

    public Name() {

    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
