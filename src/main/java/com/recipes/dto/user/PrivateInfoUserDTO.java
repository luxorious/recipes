package com.recipes.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateInfoUserDTO {
    private String firstName;
    private String lastName;
    private String eMail;
    private String aboutMe;
    private String skills;
    private String link;
    private Timestamp createdAt;
    private String login;
    private String role;
}
