package com.sweet.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class Contents {
    @Id
    @GeneratedValue
    @Column(name = "contents_id")
    private Long id;

    private String name;

    @Column(name = "upload_url")
    private String uploadUrl;

    private String type;

    @Column(name = "is_delete")
    private String isDelete;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
