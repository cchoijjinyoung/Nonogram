package com.logic.nemonemo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String username;
    private String password;
    // private String email;
    // private String image;
    // private int level;
    // private UserRole role;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Board> boards;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Notification> notification;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comment;

}
