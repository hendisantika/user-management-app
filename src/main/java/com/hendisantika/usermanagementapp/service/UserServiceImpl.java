package com.hendisantika.usermanagementapp.service;

import com.hendisantika.usermanagementapp.model.User;
import com.hendisantika.usermanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : user-management-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/20
 * Time: 07.41
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(Boolean.TRUE);
        }
        userRepository.save(user);
    }

    @Override
    public Page<User> listUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> searchByTerm(String name, Pageable pageable) {
        return userRepository.searchByTerm(name, pageable);
    }

    @Override
    public Boolean removeAll() {
        userRepository.deleteAll();
        return Boolean.TRUE;
    }

    @Override
    public void removeById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> searchBy(String keyword, String criteria) {
        if ("firstName".equals(criteria)) {
            return userRepository.findByFirstNameIgnoreCaseContaining(keyword);
        } else if ("lastName".equals(criteria)) {
            return userRepository.findByLastNameIgnoreCaseContaining(keyword);
        } else if ("email".equals(criteria)) {
            return userRepository.findByEmailIgnoreCaseContaining(keyword);
        }
        return new ArrayList<>();

    }
}
