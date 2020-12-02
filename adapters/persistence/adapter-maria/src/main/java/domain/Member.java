package domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private int authCode;
    private String email;
    private String name;
    private String birthDay;
    private String gender;
    private String phoneNumber;
    private boolean isAgreeMarketSns;
}
