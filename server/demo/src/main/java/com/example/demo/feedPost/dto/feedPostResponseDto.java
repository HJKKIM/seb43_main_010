package com.example.demo.feedPost.dto;

import com.example.demo.fans.dto.FansResponseDto;
import com.example.demo.feedPost.entity.feedPost;
//import com.example.demo.likes.dto.LikeResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class feedPostResponseDto {
    private FansResponseDto fansResponseDto;
    private int feedId;
    private String content;
    private String img;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
//
//    // feedPost 일때 좋아요 응답
//    public static LikeResponseDto feedPostCreateByEntity(feedPost entity){
//        LikeResponseDto dto = new LikeResponseDto();
//        dto.setUser(entity.getUser().getNickName());
//        dto.setCommentId(entity.getComment().getCommentId());
//        dto.setContent(entity.getContent());
//        dto.setCreateAt(entity.getCreatedAt());
//        dto.setCheck(entity.getLikes().isCheck());
//        dto.setTotal(entity.getLikes().getTotal().stream()
//                .mapToInt(Total::getTotal)
//                .sum());
//        return dto;
//    }
}
