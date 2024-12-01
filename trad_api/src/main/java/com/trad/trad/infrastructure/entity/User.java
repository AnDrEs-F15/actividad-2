package com.trad.trad.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trad.trad.utils.GenerateCodeValidated;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

@Entity
@Table(name = "USERS")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class    User {
    @Id
    @Column(name = "USER_ID")
    private int id ;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ACCOUNT_VALIDATED")
    private Boolean isAccountValidated = Boolean.FALSE ;
    @Column(name = "CODE_VALIDATED")
    private String codeValidated = GenerateCodeValidated.generateCode();
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
    public void setCodeValidated() { this.codeValidated = GenerateCodeValidated.generateCode();}
    @JsonIgnore
    @OneToMany(mappedBy = "id" )
    private List<Budget> userBudget;
    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private List<BudgetCategory> userBudgetCategories;
}
