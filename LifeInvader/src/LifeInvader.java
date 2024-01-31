import java.util.Objects;
import java.util.Scanner;

public class LifeInvader {
    public static void main(String[] args) {
        boolean signed = false;
        User currentUser = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            homeOptions();
            String command = sc.nextLine();
            if (Objects.equals(command, "sign in")) {
                if (signed) {
                    System.out.println("You already signed in!");
                } else {
                    System.out.println("please enter your E-mail:");
                    String email = sc.nextLine();
                    System.out.println("please enter your password:");
                    String password = sc.nextLine();
                    boolean isValid = isEmailPasswordValid(email, password);
                    if (isValid) {
                        signed = true;
                        currentUser = catchUserByemail(email);
                        System.out.println("Signed in!");
                    } else {
                        System.out.println("E-mail or password was wrong\nplease try again.");
                    }
                }
            } else if (Objects.equals(command, "sign out")) {
                if (signed) {
                    signed = false;
                    currentUser = null;
                } else {
                    System.out.println("You Never Signed In");
                }
            } else if (Objects.equals(command, "sign up")) {
                signUp();

            } else if (Objects.equals(command, "show post")) {
                if (signed){
                    Post.showPost(currentUser);
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (Objects.equals(command, "show post info")) {
                if (signed){
                    System.out.println("enter post ID");
                    Scanner postIdScanner = new Scanner(System.in);
                    double postId = postIdScanner.nextDouble();
                    Post.showInfoPost(postId);
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (Objects.equals(command, "show comment")) {
                if (signed){
                    System.out.println("enter post ID");
                    Scanner postIdScanner = new Scanner(System.in);
                    double postId = postIdScanner.nextDouble();
                    Post.showComments(postId);
            }
                else{
                    System.out.println("you should sign in first!");
            }

            } else if (Objects.equals(command, "setting")) {
                if (signed){
                    System.out.println("you can do these below");
                    System.out.println("change birth day\nlocation\nusername\npassword\nbio\nback");
                    command = sc.nextLine();
                    if (Objects.equals(command, "birth day")){
                        System.out.println("enter birth day");
                        currentUser.setBirthDay(sc.nextLine());
                    }
                    else if (Objects.equals(command, "location")){
                        System.out.println("enter location");
                        currentUser.setLocation(sc.nextLine());
                    }
                    else if (Objects.equals(command, "username")){
                        System.out.println("enter username");
                        currentUser.setUserName(sc.nextLine());
                    }
                    else if (Objects.equals(command, "password")){
                        System.out.println("enter new password");
                        currentUser.setPassword(sc.nextLine());
                    }
                    else if (Objects.equals(command, "bio")){
                        System.out.println("enter bio");
                        currentUser.setBio(sc.nextLine());
                    }
                    else if (Objects.equals(command, "back")){
                    }
                    else{
                        System.out.println("Invalid command\nyou're at home page");
                    }
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (Objects.equals(command, "post")) {
                if (signed){
                    System.out.println("enter text of your Post:(use\\n is is needed)");
                    Post newPost = new Post(currentUser.getUserId(),sc.nextLine());
                    System.out.println("congratulations!\nYour Life Just Got Invaded.");
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (Objects.equals(command, "follow")) {
                if (signed){
                    System.out.println("enter username you wish to follow:");
                    String userNameToFollow = sc.nextLine();
                    if (User.hasFollowed(currentUser,userNameToFollow)){
                        System.out.println("You have already followed!");
                    }
                    else{
                        currentUser.follow(userNameToFollow);
                        System.out.println("Successfully followed!");
                    }
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (Objects.equals(command, "like post")) {
                if (signed){
                    System.out.println("enter PostID which you wish to like!");
                    double postIdToLike = sc.nextDouble();
                    Post.likePost(postIdToLike);
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (Objects.equals(command, "dislike post")) {
                if (signed){
                    System.out.println("enter PostID which you wish to dislike!");
                    double postIdToLike = sc.nextDouble();
                    Post.disLikePost(postIdToLike);
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (Objects.equals(command, "unfollow")) {
                if (signed) {
                    System.out.println("enter username you wish to unfollow:");
                    String userNameToFollow = sc.nextLine();
                    if (!User.hasFollowed(currentUser, userNameToFollow)) {
                        System.out.println("You never followed!");
                    } else {
                        currentUser.unFollow(userNameToFollow);
                        System.out.println("Successfully unfollowed!");
                    }
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (Objects.equals(command, "delete post")) {
                if (signed){
                    System.out.println("enter PostID you want to delete");
                    double postIdToDelete = sc.nextDouble();
                    currentUser.deletePost(postIdToDelete);
                    System.out.println("successfully deleted");
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (Objects.equals(command, "add comment")) {
                if (signed){
                    System.out.println("enter PostID you wish to comment:");
                    double postIdToComment = sc.nextDouble();
                    System.out.println("enter text you wish to comment:(use\\n)");
                    String commentString = sc.nextLine();
                    Comment comment = new Comment(postIdToComment,currentUser.getUserId(),commentString);

                }
                else{
                    System.out.println("you should sign in first!");
                }
            }

            else {
                System.out.println("Invalid command!");
            }

        }
    }

    public static boolean isEmailPasswordValid(String email, String password) {
        return true;
    }

    public static User catchUserByemail(String email) {
        User user = User.returnUserByEmail(email);
        return user;
    }

    public static void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your email:");
        String email = sc.nextLine();
        boolean hasSignedUp = User.isEmailSigned(email);
        if (hasSignedUp){
            System.out.println("you already Signed Up");
        }
        else {
            System.out.println("enter your password:");
            String password = sc.nextLine();
            System.out.println("enter your username:");
            String userName = sc.nextLine();
            System.out.println("enter your Birth Day:");
            String birthDay = sc.nextLine();
            System.out.println("enter your Bio:");
            String bio = sc.nextLine();
            System.out.println("enter your Location:");
            String location = sc.nextLine();
            User user = new User(userName,bio,email,password,birthDay,location);
            System.out.println("Successfully Signed Up\n you can sign in now!");
        }
    }
    public static void homeOptions(){
            System.out.println("You can do these below:");
            System.out.println("sign in\nsign out\nsign up\nshow post");
            System.out.println("show post info\nshow comment\nseting");
            System.out.println("post\nfollow\nlike post\ndislike post\nunfollow");
            System.out.println("delete post\nadd comment");
    }
}
