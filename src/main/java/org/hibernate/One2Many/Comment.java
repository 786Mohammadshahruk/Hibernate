package org.hibernate.One2Many;

import jakarta.persistence.*;

@Entity
@Table(name = "comment_table")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", text='" + text + '\'' +
                '}';
    }
}
