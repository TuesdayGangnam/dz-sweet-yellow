package com.caregiver.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private long id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Column(name = "minimum_capacity", nullable = false)
    private Integer minimumCapacity;

    @Column(name = "maximum_capacity", nullable = false)
    private Integer maximumCapacity;

    @Column(name = "number_of_participants", nullable = false)
    private Integer numberOfParticipants;

    @Column(name = "description")
    private String description;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "closed", nullable = false)
    private Boolean closed;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "contents", cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id")
    private List<Content> contents = new ArrayList<>();
}
