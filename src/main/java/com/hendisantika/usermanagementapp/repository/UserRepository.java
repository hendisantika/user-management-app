package com.hendisantika.usermanagementapp.repository;

import com.hendisantika.usermanagementapp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : user-management-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/20
 * Time: 07.38
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByEmail(String email);

    List<User> findByFirstNameIgnoreCaseContaining(String firstName);

    List<User> findByLastNameIgnoreCaseContaining(String lastName);

    List<User> findByEmailIgnoreCaseContaining(String email);

    @Query("SELECT t FROM User t WHERE " +
            "LOWER(t.lastName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.firstName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    Page<User> searchByTerm(@Param("searchTerm") String searchTerm, Pageable pageable);
}