package com.recipes.repository;

import com.recipes.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

    @Query("SELECT auth FROM Authentication auth " +
            "WHERE auth.id=:id")
    Optional<Authentication> getAuthenticationById(Long id);

    @Query("SELECT auth FROM Authentication auth " +
            "WHERE auth.user.id = :userId")
    Optional<Authentication> findByUserId(Long userId);

    @Query("SELECT auth FROM Authentication auth " +
            "WHERE auth.login=:login")
    Optional<Authentication> findByLogin(String login);

    @Modifying
    @Query("UPDATE Authentication " +
            "SET password = :password " +
            "where login = :login")
    Authentication updatePasswordByLogin(String login, String password);

    @Modifying
    @Query("DELETE FROM Authentication a WHERE a.login = :login AND a.password = :password")
    boolean deleteByLoginAndPassword(String login, String password);
}
