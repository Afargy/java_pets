package edu.school21.models;

import edu.school21.annotations.HtmlForm;
import edu.school21.annotations.HtmlInput;

@HtmlForm(fileName = "user_form.html", action = "/users", method = "post")
public class UserForm {
    @HtmlInput(type = "text", name = "first_name", placeholder = "Enter First Name")
    private String firstName;

    @HtmlInput(type = "text", name = "first_name", placeholder = "Enter Last Name")
    private String lastName;

    @HtmlInput(type = "text", name = "first_name", placeholder = "Enter Password")
    private String password;

}
