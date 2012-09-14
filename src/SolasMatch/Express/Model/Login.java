
package SolasMatch.Express.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {

  private String pass;
  private String email;


  public String getPass() {
    return pass;
  }
  
  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }

}
