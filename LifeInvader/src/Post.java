import java.util.ArrayList;

public class Post {
    ArrayList<Post> postArrayList = new ArrayList<Post>();
    private static double totalPostNumber;
    private User ownerUser;
    private String postString;
    private double postId;
    private double likeNumber;
    private double repostNumber;
    private double bookmarkNumber;
    private ArrayList<Comment> commentArr ;

    //constructor method
    public Post(double ownerId, String postString){
        Post.totalPostNumber += 1;
        this.postString = postString;
        this.postId = Post.totalPostNumber;
        this.likeNumber = 0;
        this.repostNumber = 0;
        this.bookmarkNumber = 0;
        this.commentArr = new ArrayList<Comment>();
    }

    //getter methods
    public static double getTotalPostNumber() {
        return totalPostNumber;
    }

    public double getLikeNumber(){
        return this.likeNumber;
    }

    public User getOwnerUser(){
        return this.ownerUser;
    }

    public double getPostId(){
        return this.postId;
    }

    public double getRepostNumber(){
        return this.repostNumber;
    }

    public double getBookmarkNumber(){
        return this.bookmarkNumber;
    }

    public ArrayList<Comment> getCommentArr(){
        return this.commentArr;
    }


    //setter methods
    public void setPostId(double postId){
        this.postId=postId;
    }

    public void setBookmarkNumber(boolean isBookmarked){
        if (isBookmarked){
            this.bookmarkNumber += 1;
        }
        else{
            this.bookmarkNumber -= 1;
        }
    }

    public void setRepostNumber(boolean isReposted){
        if (isReposted){
            this.repostNumber += 1;
        }
        else{
            this.repostNumber -= 1;
        }
    }

    public void setLikeNumber(boolean isLiked){
        if(isLiked){
            this.likeNumber +=1 ;
        }
        else{
            this.likeNumber -= 1;
        }
    }
    public String getPostString(){
        return this.postString;
    }
    public void setCommentArr(Comment comment){
        (this.commentArr).add(comment);
    }
    public void showPost(User user){
        System.out.println("*-----*");
        for(Post posts : postArrayList){
            if (user.getUserId() != posts.getOwnerUser().getUserId()){
                System.out.println(posts.getOwnerUser().getUserName());
                System.out.println(posts.getPostString());
                System.out.println(posts.getPostId());
                System.out.println("*-----*");
            }
        }
    }
    public void showInfoPost(double postId){
        for (Post posts : postArrayList){
            if (posts.getPostId()==postId){
                System.out.println(posts.getBookmarkNumber()+" Bookmarked!");
                System.out.println(posts.likeNumber+" Liked!");
                System.out.println(posts.getRepostNumber()+" Times reposted!");
                System.out.println("*-----*");
                break;
            }
        }
    }
    public void showComments(double postId){
        System.out.println("*-----*");
        for (Post posts : postArrayList) {
            if (posts.getPostId() == postId) {
                for (Comment comment: posts.getCommentArr()){
                    if (comment.getPostId()==postId){
                        System.out.println(comment.getCommentString());
                        System.out.println("*-----*");
                    }
                }
            }
        }
    }

    private Post returnPostById(double postId){
        for (Post posts : postArrayList) {
            if (posts.getPostId() == postId) {
                return posts;
            }
        }
        return postArrayList.get(0);

    }
    public void likePost(User user, double postId){
        Post post = returnPostById(postId);
        post.setLikeNumber(true);
    }
    public void disLikePost(User user, double postId){
        Post post = returnPostById(postId);
        post.setLikeNumber(false);
    }
    public void repostPost(User user, double postId){
        Post post = returnPostById(postId);
        post.setRepostNumber(true);
        user.setPost(post);

    }
}

