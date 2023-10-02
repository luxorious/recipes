package com.recipes.dto.user;

import com.recipes.dto.receipt.ReceiptDTO;
import com.recipes.entity.Authentication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String aboutMe;
    private String skills;
    private String links;
    private Timestamp createdAt;
    private List<ReceiptDTO> recipes;
    private Authentication authentication;
}
