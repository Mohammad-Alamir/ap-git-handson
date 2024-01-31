import java.util.ArrayList;

public class User {
    private static ArrayList<User> userArrayList = new ArrayList<User>();
    private static double totalUserNumber;
    private String userName;
    private final double userId = User.totalUserNumber;
    private String bio;
    private String email;
    private String password;
    private String birthDay;
    private String location;
    private double followerNumber;
    private double followingNumber;
    private ArrayList<Post> userPostArrayList = new ArrayList<Post>();
    private ArrayList<User> followingArr;
    private ArrayList<User> followerArr;
    private ArrayList<User> postIdArr;

    //constructor method
    public User(String userName, String bio, String email, String password, String birthDay, String location) {
        User.totalUserNumber++;
        this.userName = userName;
        this.bio = bio;
        this.email = email;
        this.password = password;
        this.birthDay = birthDay;
        this.location = location;
        this.followerNumber = 0;
        this.followingNumber = 0;
        this.followingArr = new ArrayList<>();
        this.followerArr = new ArrayList<>();
        this.postIdArr = new ArrayList<>();
        User.userArrayList.add(this);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getUserId() {
        return userId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public double getFollowerNumber() {
        return followerNumber;
    }

    public void setFollowerNumber(boolean beenFollowed) {
        if (beenFollowed) {
            this.followerNumber += 1;
        }
        else{
            this.followerNumber -= 1;
        }
    }

    public double getFollowingNumber() {
        return followingNumber;
    }

    public void setFollowingNumber(boolean followed) {
        if (followed){
            this.followingNumber++;
        }
        else{
            this.followingNumber--;
        }
    }

    public ArrayList<User> getFollowingArr() {
        return followingArr;
    }

    public void setFollowingArr(User follower, boolean toFollow) {
        if (toFollow) {
            this.followingArr.add(follower);
        }
        else{
            this.followingArr.remove((follower));
        }
    }

    public ArrayList<User> getFollowerArr() {
        return followerArr;
    }

    public void setFollowerArr(User follower,boolean followed) {
        if (followed) {
            this.followerArr.add(follower);
        }
        else{
            this.followerArr.remove(follower);
        }
    }


    public void setPostIdArr(ArrayList<User> postIdArr) {
        this.postIdArr = postIdArr;
    }

    public void setPost(Post post){
        this.userPostArrayList.add(post);
    }

    public void deletePost(double postId){
        Post post = Post.returnPostById(postId);
        this.userPostArrayList.remove(post);
    }

    public double postNumberOfUser(){
        return this.userPostArrayList.size();
    }

    public static User returnUserById(double userId){
        for (User user : User.userArrayList){
            if (user.getUserId()==userId){
                return user;
            }
        }
        return userArrayList.get(0);
    }

    public static User returnUserByEmail(String email){
        for (User user : User.userArrayList){
            if(user.getEmail() == email){
                return user;
            }
        }
        return User.userArrayList.get(0);
    }

    public static User returnUserByUserName(String userName){
        for (User user : User.userArrayList){
            if(user.getEmail() == userName){
                return user;
            }
        }
        return User.userArrayList.get(0);
    }

    public static boolean isEmailSigned(String email){
        for (User user : userArrayList){
            if(user.getEmail() == email){
                return true;
            }
        }
        return false;
    }
    public static boolean hasFollowed(User currentUser, String userName){
        for(User user : currentUser.followingArr){
            if (user.getUserName() == userName){
                return true;
            }
        }
        return false;
    }
    public void follow(String userName){
        this.setFollowingNumber(true);
        User followedUser = returnUserByUserName(userName);
        followedUser.setFollowerNumber(true);
        followedUser.setFollowerArr(this,true);
        this.setFollowingArr(followedUser,true);
    }
    public void unFollow(String userName){
        User unFollowUser = returnUserByUserName(userName);
        this.setFollowingNumber(false);
        unFollowUser.setFollowerNumber(false);
        unFollowUser.setFollowerArr(this,false);
        this.setFollowingArr(unFollowUser,false);
    }
}
