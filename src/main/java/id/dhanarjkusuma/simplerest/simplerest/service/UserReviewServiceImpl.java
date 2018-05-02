package id.dhanarjkusuma.simplerest.simplerest.service;

import id.dhanarjkusuma.simplerest.simplerest.domain.UserReview;
import id.dhanarjkusuma.simplerest.simplerest.exception.NotFoundException;
import id.dhanarjkusuma.simplerest.simplerest.repository.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewServiceImpl implements UserReviewService {

    private final UserReviewRepository repository;

    @Autowired
    public UserReviewServiceImpl(UserReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserReview create(UserReview userReview) {
        userReview.setId(null);
        return repository.save(userReview);
    }

    @Override
    public List<UserReview> fetchAll() {
        return repository.findAll();
    }

    @Override
    public UserReview findById(long id) throws NotFoundException{
        UserReview review = repository.findOneById(id);
        if(review == null){
            throw new NotFoundException("Data User Review dengan id " + id + " tidak ditemukan.");
        }
        return review;
    }

    @Override
    public UserReview update(long id, UserReview userReview) throws NotFoundException{
        UserReview review = repository.findOneById(id);
        if(review == null){
            throw new NotFoundException("Data User Review dengan id " + id + " tidak ditemukan.");
        }
        userReview.setId(review.getId());
        return repository.save(userReview);
    }

    @Override
    public void delete(long id) throws NotFoundException{
        UserReview review = repository.findOneById(id);
        if(review == null){
            throw new NotFoundException("Data User Review dengan id " + id + " tidak ditemukan.");
        }
        repository.delete(review);
    }
}
