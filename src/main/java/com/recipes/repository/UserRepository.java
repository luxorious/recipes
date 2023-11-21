package com.recipes.repository;

import com.recipes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user")
    List<User> findAllUsers();

    @Query("SELECT user FROM User user " +
            "WHERE user.firstName =: name " +
            "OR user.lastName = :name")
    List<User> findByName(String name);

    @Modifying
    @Query("UPDATE User user " +
            "SET user.firstName = :firstName " +
            "WHERE user.id = :id")
    void updateUserByIdAndFirstName(Long id, String firstName);

    @Modifying
    @Query("UPDATE User user " +
            "SET user.lastName = :lastName " +
            "WHERE user.id = :id")
    void updateUserByIdAndLastName(Long id, String lastName);

    @Modifying
    @Query("UPDATE User user " +
            "SET user.eMail = :eMail " +
            "WHERE user.id =:id")
    void updateUserByIdAndEMail(Long id, String eMail);
    @Modifying
    @Query("UPDATE User user " +
            "SET user.aboutMe = :aboutMe " +
            "WHERE user.id =:id")
    void updateUserByIdAndAboutMe(Long id, String aboutMe);

    @Modifying
    @Query("UPDATE User user " +
            "SET user.skills = :skills " +
            "WHERE user.id =:id")
    void updateUserByIdAndSkills(Long id, String skills);//можна зробити списком
    @Modifying
    @Query("UPDATE User user " +
            "SET user.link = :link " +
            "WHERE user.id =:id")
    void updateUserByIdAndLink(Long id, String link);//можна зробити списком

    @Modifying
    @Query("DELETE FROM User user " +
            "WHERE user.id=:id " +
            "AND user.authentication.password = :password")
    boolean deleteByIdAndPassword(Long id, String password);

}
