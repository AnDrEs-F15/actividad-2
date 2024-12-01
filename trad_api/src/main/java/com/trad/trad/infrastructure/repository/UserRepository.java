package com.trad.trad.infrastructure.repository;

import com.trad.trad.infrastructure.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query( "SELECT user " +
            "FROM User user " +
            "WHERE user.email =:email " +
            "AND user.isAccountValidated = true ")
    Optional<User> findByActiveEmail(@Param("email") String email );
    @Query( "SELECT true " +
            "FROM User user " +
            "WHERE user.email= :email " +
            "AND user.codeValidated= :code ")
    Optional<Boolean> activeAccountByCode(@Param("email") String email , @Param("code") String code );
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT us FROM User us WHERE us.email= :email ")
    User getByEmail(@Param("email") String email);
    public User findByName(String id);

}
