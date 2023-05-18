package example.domain.feedPost.mapper;

import example.domain.comment.dto.CommentFanResponseDto;
import example.domain.comment.entity.Comment;
import example.domain.fans.dto.FansResponseDto;
import example.domain.fans.entity.Fans;
import example.domain.feedPost.dto.feedPostDto;
import example.domain.feedPost.dto.feedPostResponseDto;
import example.domain.feedPost.entity.FeedPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface feedPostMapper {
    // feedPostDto.Post -> feedPost
    default FeedPost feedPostDtoToFeed(feedPostDto.Post requestBody, Fans fans){
        FeedPost feedPost = new FeedPost(requestBody.getContent(), requestBody.getImg(), fans);
        return feedPost;
    }
    // feedPostDto.Patch -> feedPost
    default FeedPost feedPatchDtoToFeed(FeedPost feedpost, feedPostDto.Patch requestBody, Fans fans){
        FeedPost feedPost = new FeedPost(requestBody.getContent(), requestBody.getImg(), fans);
//        feedPost.setId(requestBody.getFeedPostId());
        feedPost.setFeedPostId(feedpost.getFeedPostId());
        return feedPost;
    }

    // feedPost -> feedPostDto.Response
    feedPostResponseDto feedToFeedResponseDto(FeedPost feedPost);

    List<feedPostResponseDto> feedPostsToFeedResponseDtos(List<FeedPost> feedPost);

    default CommentFanResponseDto commentToCommentFanResponseDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentFanResponseDto commentFanResponseDto = new CommentFanResponseDto();
        Fans fans = comment.getFans();
        FansResponseDto userDto = new FansResponseDto();
        userDto.setFanId(fans.getFanId());
        userDto.setNickname(fans.getNickname());
        userDto.setProfile(fans.getProfile());

        commentFanResponseDto.setUser(userDto);
        commentFanResponseDto.setFeedPostId(comment.getFeedPost().getFeedPostId());
        commentFanResponseDto.setContent( comment.getContent() );
        commentFanResponseDto.setCreatedAt( comment.getCreatedAt() );
        commentFanResponseDto.setLikeCount( comment.getLikeCount() );

        return commentFanResponseDto;
    }

}
