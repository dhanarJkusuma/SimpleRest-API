package id.dhanarjkusuma.simplerest.simplerest.repository;

import id.dhanarjkusuma.simplerest.simplerest.domain.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
    UserReview findOneById(long id);
}
