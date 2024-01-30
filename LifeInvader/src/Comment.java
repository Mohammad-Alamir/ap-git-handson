import java.util.ArrayList;

public class Comment {
    private static double totalCommentNumber;
    private static ArrayList<Comment> commentArrayList = new ArrayList<Comment>();
    private final double commentId;
    private final double postId;
    private final double commentOwnerId;
    private final String commentString;
    private double commentLikeNumber;

    public Comment(double postId, double commentOwnerId, String commentString) {
        Comment.totalCommentNumber += 1;
        this.postId = postId;
        this.commentId = Comment.totalCommentNumber;
        this.commentOwnerId = commentOwnerId;
        this.commentString = commentString;
        this.commentLikeNumber = 0;
        Comment.commentArrayList.add(this);
    }

    //getter methods
    public double getPostId() {
        return postId;
    }

    public double getCommentId() {
        return commentId;
    }

    public double getCommentOwnerId() {
        return commentOwnerId;
    }

    public String getCommentString() {
        return commentString;
    }

    public double getCommentLikeNumber() {
        return commentLikeNumber;
    }

    //setter method
    public void setCommentLikeNumber(boolean isLiked) {
        if (isLiked){
         this.commentLikeNumber += 1;
        }
        else{
            this.commentLikeNumber -= 1;
        }
    }
    public void deleteComment(Comment comment){
        commentArrayList.remove(comment);
    }
}
