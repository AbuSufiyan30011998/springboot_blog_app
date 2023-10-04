package com.ashokit.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty
    @Size(min = 4, message = "username must be minimum four character..!!")
    private String name;

    @Email(message = "email is not valid.Please enter correct email..!!")
    private String email;

    @NotEmpty
    @Size(min = 4, max = 8, message = "must be minimum 4 character and not greater than 8..!!")
    private String password;

    @NotEmpty
    private String about;

}
