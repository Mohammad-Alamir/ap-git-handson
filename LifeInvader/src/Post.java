import java.util.ArrayList;

public class Post {
    //define state of each Post
    static ArrayList<Post> postArrayList = new ArrayList<Post>();
    private static double totalPostNumber;
    private User ownerUser;
    private String postString;
    private double postId;
    private double likeNumber;
    private double repostNumber;
    private double bookmarkNumber;
    private ArrayList<Comment> commentArr ;

    private ArrayList<Comment> bookmarkedPosts;
    //constructor method
    public Post(double ownerId, String postString){
        Post.totalPostNumber += 1;
        this.ownerUser = User.returnUserById(ownerId);
        this.postString = postString;
        this.postId = Post.totalPostNumber;
        this.likeNumber = 0;
        this.repostNumber = 0;
        this.bookmarkNumber = 0;
        this.commentArr = new ArrayList<>();
        this.bookmarkedPosts = new ArrayList<>();
    }

    //getter methods
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

    // if true then liked if false then disliked
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

    //this method formats posts to show
    public static void showPost(User user){
        System.out.println("*-----*");
        for(Post posts : postArrayList){
            if (user.getUserId() != posts.getOwnerUser().getUserId()){
                // type of ownereUser is User
                System.out.println(posts.getOwnerUser().getUserName());
                System.out.println(posts.getPostString());
                System.out.println(posts.getPostId());
                System.out.println("*-----*");
            }
        }
    }
    //this method shows post info including bookmarked number,...
    public static void showInfoPost(double postId){
        for (Post posts : postArrayList){
            if (posts.getPostId()==postId){
                System.out.println(posts.getBookmarkNumber()+" Bookmarked!");
                System.out.println(posts.getLikeNumber()+" Liked!");
                System.out.println(posts.getRepostNumber()+" Times reposted!");
                System.out.println("*-----*");
                break;
            }
        }
    }
    //the method shows comment below a post
    public static void showComments(double postId){
        System.out.println("*-----*");
        for (Post posts : postArrayList) {
            if (posts.getPostId() == postId) {
                for (Comment comment: posts.getCommentArr()){
                    if (comment.getPostId()==postId){
                        System.out.println(User.returnUserById(comment.getCommentOwnerId())+" :");
                        System.out.println(comment.getCommentString());
                        System.out.println("*-----*");
                    }
                }
            }
        }
    }
    // methods below translate states to object
    static Post returnPostById(double postId){
        for (Post posts : postArrayList) {
            if (posts.getPostId() == postId) {
                return posts;
            }
        }
        return postArrayList.get(0);

    }

    public static void likePost(double postId){
        Post post = returnPostById(postId);
        post.setLikeNumber(true);
    }

    public static void disLikePost(double postId){
        Post post = returnPostById(postId);
        post.setLikeNumber(false);
    }

    public void repostPost(User user, double postId){
        Post post = returnPostById(postId);
        post.setRepostNumber(true);
        user.setPost(post);
    }
}

