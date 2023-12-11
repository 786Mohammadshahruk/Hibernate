package org.hibernate.One2Many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


public class PostTestClient {


    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();

    }

    private static void createPost(Post post) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(post);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    private static void createComment(Comment comment) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(comment);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


    private static void update(Comment comment, int postId) {
        try (Session session = sessionFactory.openSession()) {
            //fetching Post
            Post actualPost = session.get(Post.class, postId);

            //verifying and updating Post
            if (actualPost != null && actualPost.getCommentList() != null && !actualPost.getCommentList().isEmpty()) {
                for (int i = 0; i < actualPost.getCommentList().size(); i++) {
                    actualPost.getCommentList().get(i).setText(comment.getText());
                }
            }
            //Persisting Post
            Transaction transaction = session.beginTransaction();
            session.update(actualPost);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        //CreateOperation
        createPost(getPost1());


        //UpdateOperation
       /* Comment comment = new Comment();
        comment.setText("Hello Test 1");
        update(comment, 1);*/

    }

    /**
     * building Post Object
     *
     * @return
     */
    private static Post getPost() {
        Post post = new Post();
        post.setTitle("test Title");
        post.setCommentList(getComment());
        return post;
    }

    /**
     * building Comment Object
     *
     * @return
     */
    private static List<Comment> getComment() {
        Comment comment1 = new Comment();
        comment1.setText("Hello");


        Comment comment2 = new Comment();
        comment2.setText("Welcome");


        Comment comment3 = new Comment();
        comment3.setText("How are u");

        return List.of(comment1, comment2, comment3);
    }

    private static Post getPost1() {
        Post post = new Post();
        post.setTitle("Test 1");


        Comment comment1 = new Comment();
        comment1.setText("Hello");
        comment1.setPost(post);

        Comment comment2 = new Comment();
        comment2.setText("Welcome");
        comment2.setPost(post);

        Comment comment3 = new Comment();
        comment3.setText("How are u");
        comment3.setPost(post);

        post.setCommentList(List.of(comment1,comment2,comment3));
        return post;
    }


}
