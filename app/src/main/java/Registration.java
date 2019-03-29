public class Registration {
   String name;
   String email;
   String password;
   String LinkedInURL;
   String country;
   String state;
   String city;
   String timezone;

   public Registration(){

   }

   public Registration(String name, String email, String password, String LinkedInURL, String country, String state,  String city,  String timezone ){
       this.name = name;
       this.email = email;
       this.password = password;
       this.LinkedInURL = LinkedInURL;
       this.country = country;
       this.city = city;
       this.state = state;
       this.city = city;
       this.timezone = timezone;

   }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLinkedInURL() {
        return LinkedInURL;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getTimezone() {
        return timezone;
    }
}

