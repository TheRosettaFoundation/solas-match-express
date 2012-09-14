
package SolasMatch.Express.Model;


import com.fasterxml.jackson.annotation.*;



/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

  @JsonProperty("_tag_id")
  private String tagId;
  @JsonProperty("_label")
  private String label;


  public String getTagId() {
    return tagId;
  }
  
  public void setTagId(String tagId) {
    this.tagId = tagId;
  }

  public String getLabel() {
    return label;
  }
  
  public void setLabel(String label) {
    this.label = label;
  }

}
