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

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "number_of_participants", nullable = false)
    private int numberOfParticipants;

    @Column(name = "description")
    private String description;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "is_closed", nullable = false)
    private boolean isClosed;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "contents", cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id")
    private List<Content> contents = new ArrayList<>();
}
