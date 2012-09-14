
package SolasMatch.Express.Model;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;


/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Org {

  @JsonProperty("_id")
  @JsonSerialize(include = Inclusion.NON_EMPTY)
  private String id;
  @JsonProperty("_home_page")
  private String homePage;
  @JsonProperty("_name")
  private String name;
  @JsonProperty("_biography")
  private String biography;


  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }

  public String getHomePage() {
    return homePage;
  }
  
  public void setHomePage(String homePage) {
    this.homePage = homePage;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public String getBiography() {
    return biography;
  }
  
  public void setBiography(String biography) {
    this.biography = biography;
  }

}
