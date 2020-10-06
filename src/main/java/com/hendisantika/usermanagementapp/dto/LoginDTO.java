package com.hendisantika.usermanagementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : user-management-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/20
 * Time: 07.43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private String emailAddress;
    private String password;
}
