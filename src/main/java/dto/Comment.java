package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter //Getter
@Setter //Setter
@NoArgsConstructor  //Default Constructor
//@AllArgsConstructor //Constructor
public class Comment {
    private Integer id;
    private String memberID;
    private Integer postID;
    private Date date;
    private String content;
    
    

    public Comment(Integer id, String memberID, Integer postID, Date date, String content) {
		super();
		this.id = id;
		this.memberID = memberID;
		this.postID = postID;
		this.date = date;
		this.content = content;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMemberID() {
		return memberID;
	}



	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}



	public Integer getPostID() {
		return postID;
	}



	public void setPostID(Integer postID) {
		this.postID = postID;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	@Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", memberID='" + memberID + '\'' +
                ", postID='" + postID + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
