package domain;

public class User {
    private   String username;
    private   String password;
    private   String email;
    private   String firstName;
    private   String lastName;
    private   String phone;
    private   String sex;
    private   String age;
    private   String address;
    private   String country;
    private   String faverCategory;

    public String getFaverCategory() {return faverCategory;}

    public void setFaverCategory(String faverCategory) {this.faverCategory = faverCategory;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getCountry() {return country;}

    public void setCountry(String country) {this.country = country;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getSex() {return sex;}

    public void setSex(String sex) {this.sex = sex;}

    public User(String username, String password) {this.username = username;this.password = password;}

    public User(){}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getAge() {return age;}

    public void setAge(String age) {this.age = age;}
}
