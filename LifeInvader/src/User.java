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
    private ArrayList<User> followingArr = new ArrayList<User>();
    private ArrayList<User> followerArr = new ArrayList<User>();
    private ArrayList<User> postIdArr = new ArrayList<User>();

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
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

    public void setFollowingArr(ArrayList<User> followingArr) {
        this.followingArr = followingArr;
    }

    public ArrayList<User> getFollowerArr() {
        return followerArr;
    }

    public void setFollowerArr(User follower,boolean followed) {
        this.followerArr.add(follower);
    }

    public ArrayList<User> getPostIdArr() {
        return postIdArr;
    }

    public void setPostIdArr(ArrayList<User> postIdArr) {
        this.postIdArr = postIdArr;
    }
    public void setPost(Post post){
        this.userPostArrayList.add(post);
    }
    public void deletePost(Post post){
        this.userPostArrayList.remove(post);
    }
    public double postNumberOfUser(){
        return this.userPostArrayList.size();
    }
}
