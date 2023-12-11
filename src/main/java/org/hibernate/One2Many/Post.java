package org.hibernate.One2Many;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "post_table")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    /*@JoinTable(name = "comment_post_table", joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))*/
    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                '}';
    }
}
