import java.util.Scanner;

public class LifeInvader {
    public static void main(String[] args) {
        boolean signed = false;
        User currentUser = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.nextLine();
            if (command == "sign in") {
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
            } else if (command == "sign out") {
                if (signed) {
                    signed = false;
                    currentUser = null;
                } else {
                    System.out.println("You Never Signed In");
                }
            } else if (command == "sign up") {
                signUp();

            } else if (command == "show post") {
                if (signed){
                    Post.showPost(currentUser);
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (command == "show info post") {
                if (signed){
                    System.out.println("enter post ID");
                    Scanner postIdScanner = new Scanner(System.in);
                    double postId = postIdScanner.nextDouble();
                    Post.showInfoPost(postId);
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (command == "show comment") {
                if (signed){
                    System.out.println("enter post ID");
                    Scanner postIdScanner = new Scanner(System.in);
                    double postId = postIdScanner.nextDouble();
                    Post.showComments(postId);
            }
                else{
                    System.out.println("you should sign in first!");
            }

            } else if (command == "setting") {
                if (signed){
                    System.out.println("you can do these below");
                    System.out.println("change birth day\nlocation\nusername\npassword\nbio\nback");
                    command = sc.nextLine();
                    if (command == "birth day"){
                        System.out.println("enter birth day");
                        currentUser.setBirthDay(sc.nextLine());
                    }
                    else if (command == "location"){
                        System.out.println("enter location");
                        currentUser.setLocation(sc.nextLine());
                    }
                    else if (command == "username"){
                        System.out.println("enter username");
                        currentUser.setUserName(sc.nextLine());
                    }
                    else if (command == "password"){
                        System.out.println("enter new password");
                        currentUser.setPassword(sc.nextLine());
                    }
                    else if (command == "bio"){
                        System.out.println("enter bio");
                        currentUser.setBio(sc.nextLine());
                    }
                    else if (command == "back"){
                    }
                    else{
                        System.out.println("Invalid command\nyou're at home page");
                    }
                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (command == "post") {
                if (signed){

                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (command == "follow") {
                if (signed){

                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (command == "like post") {
                if (signed){

                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (command == "dislike post") {
                if (signed){

                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (command == "unfollow") {
                if (signed){

                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (command == "delete post") {
                if (signed){

                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else if (command == "comment") {
                if (signed){

                }
                else{
                    System.out.println("you should sign in first!");
                }

            } else {
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
}
