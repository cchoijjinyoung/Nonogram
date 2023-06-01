package com.logic.nemonemo.dto.request;

import com.logic.nemonemo.entity.Board;
import com.logic.nemonemo.entity.Comment;
import com.logic.nemonemo.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long id;
    private String nickname;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    /*
    private String email;
    private String image;
    private int level;
    private UserRole role;
    */
    private List<Board> boards;
    private List<Notification> notification;
    private List<Comment> comment;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
