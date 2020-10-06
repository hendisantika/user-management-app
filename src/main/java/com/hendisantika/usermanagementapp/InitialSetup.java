package com.hendisantika.usermanagementapp;

import com.hendisantika.usermanagementapp.model.RoleNames;
import com.hendisantika.usermanagementapp.model.User;
import com.hendisantika.usermanagementapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by IntelliJ IDEA.
 * Project : user-management-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/10/20
 * Time: 06.55
 */
@Component
public class InitialSetup {

    @Autowired
    private UserService userService;

    @Value("${admin.first.name}")
    private String firstName;

    @Value("${admin.last.name}")
    private String lastName;

    @Value("${admin.email.address}")
    private String emailAddress;

    @Value("${admin.password}")
    private String password;


    @PostConstruct
    public void initData() throws Exception {

        User dbUser = userService.findUserByEmail(emailAddress);

        if (dbUser == null) {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(emailAddress);
            user.setPassword(password);
            user.setActive(Boolean.TRUE);
            user.setRoleName(RoleNames.ADMIN.name());
            userService.saveUser(user);
        }
        loadUsers();
    }
}
