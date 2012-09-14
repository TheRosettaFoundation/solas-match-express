
package SolasMatch.Express.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;


/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

  @JsonProperty("_targetCountryCode")
  private String targetCountryCode;
  @JsonProperty("_targetID")
  private String targetID;
  @JsonProperty("_referencePage")
  private String referencePage;
  @JsonProperty("_sourceCountryCode")
  private String sourceCountryCode;
  @JsonProperty("_sourceLanguageID")
  private String sourceLanguageID;
  @JsonProperty("_impact")
  private String impact;
  @JsonProperty("_id")
  @JsonSerialize(include = Inclusion.NON_EMPTY)
  private String id;
  @JsonProperty("_createdTime")
  private String createdTime;
  @JsonProperty("_organisationID")
  private String organisationID;
  @JsonProperty("_status")
  private Object status;
  @JsonProperty("_tags")
  private List<String> tags;
  @JsonProperty("_wordCount")
  private String wordCount;
  @JsonProperty("_title")
  private String title;


  public String getTargetCountryCode() {
    return targetCountryCode;
  }
  
  public void setTargetCountryCode(String targetCountryCode) {
    this.targetCountryCode = targetCountryCode;
  }

  public String getTargetID() {
    return targetID;
  }
  
  public void setTargetID(String targetID) {
    this.targetID = targetID;
  }

  public String getReferencePage() {
    return referencePage;
  }
  
  public void setReferencePage(String referencePage) {
    this.referencePage = referencePage;
  }

  public String getSourceCountryCode() {
    return sourceCountryCode;
  }
  
  public void setSourceCountryCode(String sourceCountryCode) {
    this.sourceCountryCode = sourceCountryCode;
  }

  public String getSourceLanguageID() {
    return sourceLanguageID;
  }
  
  public void setSourceLanguageID(String sourceLanguageID) {
    this.sourceLanguageID = sourceLanguageID;
  }

  public String getImpact() {
    return impact;
  }
  
  public void setImpact(String impact) {
    this.impact = impact;
  }

  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }

  public String getCreatedTime() {
    return createdTime;
  }
  
  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public String getOrganisationID() {
    return organisationID;
  }
  
  public void setOrganisationID(String organisationID) {
    this.organisationID = organisationID;
  }

  public Object getStatus() {
    return status;
  }
  
  public void setStatus(Object status) {
    this.status = status;
  }

  public List<String> getTags() {
    return tags;
  }
  
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public String getWordCount() {
    return wordCount;
  }
  
  public void setWordCount(String wordCount) {
    this.wordCount = wordCount;
  }

  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }

}
