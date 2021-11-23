package fr.uge.jee.springmvc.pokematch;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Name {
    @NotNull
    @Pattern(regexp = "[A-z]+", message = "minus letters required")
    private String firstName;
    @NotNull
    @Pattern(regexp = "[A-z]+", message = "minus letters required")
    private String lastName;

    public Name() {}

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
