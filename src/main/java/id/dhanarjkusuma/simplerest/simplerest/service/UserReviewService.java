package id.dhanarjkusuma.simplerest.simplerest.service;

import id.dhanarjkusuma.simplerest.simplerest.domain.UserReview;
import id.dhanarjkusuma.simplerest.simplerest.exception.NotFoundException;

import java.util.List;

public interface UserReviewService {
    UserReview create(UserReview userReview);
    List<UserReview> fetchAll();
    UserReview findById(long id) throws NotFoundException;
    UserReview update(long id, UserReview userReview) throws NotFoundException;
    void delete(long id) throws NotFoundException;
}
