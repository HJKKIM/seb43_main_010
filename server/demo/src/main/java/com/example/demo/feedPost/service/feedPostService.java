package com.example.demo.feedPost.service;

import com.example.demo.exception.BusinessLogicException;
import com.example.demo.exception.ExceptionCode;
import com.example.demo.feedPost.entity.feedPost;
import com.example.demo.feedPost.repository.feedPostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class feedPostService {
    private feedPostRepository feedPostRepository;

    public feedPostService(feedPostRepository feedPostRepository){
        this.feedPostRepository = feedPostRepository;
    }

    public feedPost createFeedPost(feedPost feedPost){
        return feedPostRepository.save(feedPost);
    }

    public feedPost findFeedPost(int feedId){
        Optional<feedPost> optionalPost = feedPostRepository.findById(feedId); // findById : Optional<T> 객체 반환
        return optionalPost.orElseThrow(() -> new BusinessLogicException(ExceptionCode.FEEDPOST_NOT_FOUND));
    }

    public feedPost updateFeedPost(feedPost feedPost){
        feedPost findFeedPost = findFeedPost(feedPost.getId());

        if(feedPost.getFans().getId() != findFeedPost.getFans().getId()) {
            throw new BusinessLogicException(ExceptionCode.FEEDPOST_AUTHOR_NOT_MATCH);
        }else{
            Optional.ofNullable(feedPost.getContent()).ifPresent(content -> findFeedPost.setContent(content));
            Optional.ofNullable(feedPost.getImg()).ifPresent(img -> findFeedPost.setImg(img));
            findFeedPost.setModifiedAt(LocalDateTime.now());
        }

        return feedPostRepository.save(findFeedPost);
    }

    public void deleteFeedPost(int feedId){
        feedPost findFeedPost = findFeedPost(feedId);
        feedPostRepository.delete(findFeedPost);
    }

}
