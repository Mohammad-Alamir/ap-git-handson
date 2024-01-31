import java.util.ArrayList;

public class Comment {
    private static double totalCommentNumber;
    private static ArrayList<Comment> commentArrayList = new ArrayList<Comment>();
    private final double commentId;
    private final double postId;
    private final double commentOwnerId;
    private final String commentString;

    public Comment(double postId, double commentOwnerId, String commentString) {
        Comment.totalCommentNumber += 1;
        this.postId = postId;
        this.commentId = Comment.totalCommentNumber;
        this.commentOwnerId = commentOwnerId;
        this.commentString = commentString;
        Comment.commentArrayList.add(this);
    }

    //getter methods
    public double getPostId() {
        return postId;
    }


    public double getCommentOwnerId() {
        return commentOwnerId;
    }

    public String getCommentString() {
        return commentString;
    }

}
