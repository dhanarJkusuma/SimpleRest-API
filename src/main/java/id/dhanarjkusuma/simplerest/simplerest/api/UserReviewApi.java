package id.dhanarjkusuma.simplerest.simplerest.api;

import id.dhanarjkusuma.simplerest.simplerest.domain.UserReview;
import id.dhanarjkusuma.simplerest.simplerest.exception.NotFoundException;
import id.dhanarjkusuma.simplerest.simplerest.service.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/user-review")
public class UserReviewApi {

    private final UserReviewService userReviewService;

    @Autowired
    public UserReviewApi(UserReviewService userReviewService) {
        this.userReviewService = userReviewService;
    }

    @PostMapping
    public ResponseEntity<UserReview> createReview(@RequestBody @Validated UserReview userReview){
        UserReview result = userReviewService.create(userReview);
        return new ResponseEntity<>(result, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserReview>> fetchReview(){
        List<UserReview> reviewList = userReviewService.fetchAll();
        return new ResponseEntity<>(reviewList, OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserReview> updateReview(
            @RequestBody @Validated UserReview userReview,
            @PathVariable(name = "id") long id
    ){
        UserReview result;
        try{
            result = userReviewService.update(id, userReview);
            return new ResponseEntity<>(result, OK);
        }catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteReview(
            @PathVariable(name = "id") long id
    ){
        try{
            userReviewService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
