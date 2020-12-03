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

    @Column(name = "auth_code")
    private int authCode;

    private String email;

    private String name;

    @Column(name = "birth_day")
    private String birthDay;

    private String gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_agree_marketing_sns")
    private boolean isAgreeMarketingSns;
}
