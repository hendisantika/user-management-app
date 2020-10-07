package com.hendisantika.usermanagementapp.service;

import com.hendisantika.usermanagementapp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : user-management-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/20
 * Time: 07.40
 */
public interface UserService {
    User findUserByEmail(String email);

    void saveUser(User user);

    Boolean removeAll();

    void removeById(UUID id);

    User findById(UUID id);

    Page<User> searchByTerm(String name, Pageable pageable);

    Page<User> listUsers(Pageable pageable);

    List<User> searchBy(String keyword, String criteria);
}
