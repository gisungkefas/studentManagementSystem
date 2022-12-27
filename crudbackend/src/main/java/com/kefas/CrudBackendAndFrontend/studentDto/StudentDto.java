package com.kefas.CrudBackendAndFrontend.studentDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @Email
    private String email;

    @NotNull(message = "Firstname most not be Empty")
    private String firstName;

    @NotNull(message = "Lastname most not be Empty")
    private String lastName;

    @NotNull(message = "PhoneNumber most not be Empty")
    private String phoneNumber;

    @NotNull(message = "DOB most not be Empty")
    private String dob;

    @NotNull(message = "Gender most not be Empty")
    private String gender;

    @NotNull(message = "Address most not be Empty")
    private String address;
}
