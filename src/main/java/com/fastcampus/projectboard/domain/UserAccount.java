package com.fastcampus.projectboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "userId"),
        @Index(columnList = "email", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "cratedBy")
})
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false, length = 50) private String userId;
    @Setter @Column(nullable = false, length = 255) private String userPassword;

    @Setter @Column(length = 100) private String email;
    @Setter @Column(length = 100) private String nickName;
    @Setter @Column private String memo;

    protected UserAccount() {}

    private UserAccount(String userId, String userPassword, String email, String nickName, String memo) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.nickName = nickName;
        this.memo = memo;
    }

    public static UserAccount of(String userId, String userPassword, String email, String nickName, String memo) {
        return new UserAccount(userId, userPassword, email, nickName, memo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
