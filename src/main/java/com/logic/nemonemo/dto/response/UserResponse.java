package com.logic.nemonemo.dto.response;

import com.logic.nemonemo.entity.Board;
import com.logic.nemonemo.entity.Comment;
import com.logic.nemonemo.entity.Notification;
import com.logic.nemonemo.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String image;
    private int level;
    private UserRole role;
    private List<Board> boards;
    private List<Notification> notification;
    private List<Comment> comment;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
