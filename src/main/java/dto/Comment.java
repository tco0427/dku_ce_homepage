package dto;

import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter //Getter
@Setter //Setter
@NoArgsConstructor  //Default Constructor
@AllArgsConstructor //Constructor
@ToString
public class Comment {
    private Integer id;
    private String memberId;
    private Integer postId;
    private Date date;
    private String content;

	public Comment(String memberId, Integer postId, Date date,String content) {
		this.memberId = memberId;
		this.postId=postId;
		this.date=date;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
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

	public Comment(Integer id, String memberId, Integer postId, Date date, String content) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.postId = postId;
		this.date = date;
		this.content = content;
	}

	public static Comment createComment(List<String> list){
		String memberId=list.get(0);
		Integer postId=Integer.parseInt(list.get(1));
		Date creationDate=new Date(System.currentTimeMillis());
		String content=list.get(2);

		return new Comment(memberId,postId,creationDate,content);
	}
}
