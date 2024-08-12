

class Account {
    String name; //Default type -> can be accessed in the class but cannot be used in a different package like after importing the package in a different file.
    public int dateofCreation; //Public type -> can be accessed in and out of the package.
    protected String email; //similar to default
    private String password; //cannot be accessed even by the class we use getters and setters for them

    // Getter for password
    public String getPassword() {
        return this.password;
    }

    // Setter for password
    public void setPassword(String pass) {
        this.password = pass;
    }

    // we can also make rake setpassword a private method and generate a random password
    // public String getPassword(){
    //     setPassword("RandomPasss");
    //     return this.password;
    // }
    // private void setPassword(String pass) {
    //     this.password = pass;
    // }
}

public class accessModifiers {
    public static void main(String[] args) {
        Account ac1 = new Account();
        ac1.name = "Saad Sabahuddin";
        ac1.dateofCreation = 23;
        ac1.email = "saad@gmail.com";
        // ac1.password = cannot be accessed

        // setter for the password
        // getter
        System.out.println(ac1.getPassword());
    }
}
