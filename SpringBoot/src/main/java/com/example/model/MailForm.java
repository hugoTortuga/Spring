package com.example.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
public class MailForm {

    @Size(min=2, max=70)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Mail : " + this.email;
    }

}
