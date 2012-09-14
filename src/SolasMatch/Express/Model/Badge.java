
package SolasMatch.Express.Model;


import com.fasterxml.jackson.annotation.*;



/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Badge {

  @JsonProperty("_owner_id")
  private Object ownerId;
  @JsonProperty("_description")
  private String description;
  @JsonProperty("_title")
  private String title;
  @JsonProperty("_badge_id")
  private String badgeId;


  public Object getOwnerId() {
    return ownerId;
  }
  
  public void setOwnerId(Object ownerId) {
    this.ownerId = ownerId;
  }

  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }

  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }

  public String getBadgeId() {
    return badgeId;
  }
  
  public void setBadgeId(String badgeId) {
    this.badgeId = badgeId;
  }

}
