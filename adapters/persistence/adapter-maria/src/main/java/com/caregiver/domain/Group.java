package com.caregiver.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Group Entity.
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private Member user;

  @OneToMany(mappedBy = "contents", cascade = CascadeType.ALL)
  @JoinColumn(name = "content_id")
  private List<Content> contents = new ArrayList<>();

  /**
   * Group 객체를 생성하여 리턴합니다.
   */
  @Builder
  public Group(long id, String groupName, Integer minimumCapacity,
               Integer maximumCapacity, Integer numberOfParticipants, String description,
               Boolean deleted, Boolean closed, Member user,
               List<Content> contents) {
    this.id = id;
    this.groupName = groupName;
    this.minimumCapacity = minimumCapacity;
    this.maximumCapacity = maximumCapacity;
    this.numberOfParticipants = numberOfParticipants;
    this.description = description;
    this.deleted = deleted;
    this.closed = closed;
    this.user = user;
    this.contents = contents;
  }
}
