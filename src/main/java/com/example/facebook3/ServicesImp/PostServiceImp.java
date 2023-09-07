package com.example.facebook3.ServicesImp;

import com.example.facebook3.Services.PostService;
import com.example.facebook3.entities.Post;
import com.example.facebook3.entities.User;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import com.example.facebook3.repos.PostRepo;
import com.example.facebook3.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService {
    @Autowired
    private PostRepo postsRepo;

    @Autowired
    private UserRepo usersRepo;

    @Override
    public List<Post> getPosts() throws InvalidNameFormatException {
        if (postsRepo.findAll().isEmpty())
            throw new InvalidNameFormatException(" there is no data ");
        return postsRepo.findAll();
    }

    @Override
    public Post addPost(Post posts) throws InvalidNameFormatException {

        User user = usersRepo.findById(posts.getUser_id()).orElseThrow(() -> new InvalidNameFormatException("id is not found"));

        Post posts1 = new Post();

        posts1.setUser_id(posts.getUser_id());
        posts1.setPost(posts.getPost());
        posts1.setCreated_at(posts.getCreated_at());

        return postsRepo.save(posts1);
    }

    @Override
    public Post updatePost(int post_id, String post) throws InvalidNameFormatException {
        Optional<Post> post1 = postsRepo.findById(post_id);
        if (post1.isEmpty())
            throw new InvalidNameFormatException("postid is not found");
        Post posts = post1.get();
        posts.setPost(post);
        return postsRepo.save(posts);

    }

    @Override
    public void removePost(int post_id) throws InvalidNameFormatException {
        Optional<Post> post1 = postsRepo.findById(post_id);
        if (post1.isEmpty())
            throw new InvalidNameFormatException("there is no post related to that post_id");

        postsRepo.deleteById(post_id);


    }

    @Override
    public List<Post> getPostParticularUser(int userId) throws InvalidNameFormatException {
        List<Post> posts = postsRepo.getPosts(userId);
        if (posts.isEmpty())
            throw new InvalidNameFormatException("there is no posts for that user");
        return posts;
    }

    @Override
    public List<String> getfeed(int userid) throws InvalidNameFormatException {
        List<String> a = postsRepo.getfeeds(userid);
        if (a.isEmpty())
            throw new InvalidNameFormatException("there is no posts to feed");

        return a;
    }
}
