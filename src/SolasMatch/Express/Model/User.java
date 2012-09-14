
package SolasMatch.Express.Model;


import com.fasterxml.jackson.annotation.*;



/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  @JsonProperty("_native_region_id")
  private String nativeRegionId;
  @JsonProperty("_biography")
  private String biography;
  @JsonProperty("_user_id")
  private String userId;
  @JsonProperty("_password")
  private Object password;
  @JsonProperty("_nonce")
  private String nonce;
  @JsonProperty("_display_name")
  private String displayName;
  @JsonProperty("_email")
  private String email;
  @JsonProperty("_native_language_id")
  private String nativeLanguageId;


  public String getNativeRegionId() {
    return nativeRegionId;
  }
  
  public void setNativeRegionId(String nativeRegionId) {
    this.nativeRegionId = nativeRegionId;
  }

  public String getBiography() {
    return biography;
  }
  
  public void setBiography(String biography) {
    this.biography = biography;
  }

  public String getUserId() {
    return userId;
  }
  
  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Object getPassword() {
    return password;
  }
  
  public void setPassword(Object password) {
    this.password = password;
  }

  public String getNonce() {
    return nonce;
  }
  
  public void setNonce(String nonce) {
    this.nonce = nonce;
  }

  public String getDisplayName() {
    return displayName;
  }
  
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }

  public String getNativeLanguageId() {
    return nativeLanguageId;
  }
  
  public void setNativeLanguageId(String nativeLanguageId) {
    this.nativeLanguageId = nativeLanguageId;
  }

}
