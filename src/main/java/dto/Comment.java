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

	public static Comment createComment(List<String> list){
		String memberId=list.get(0);
		Integer postId=Integer.parseInt(list.get(1));
		Date creationDate=new Date(System.currentTimeMillis());
		String content=list.get(2);

		return new Comment(memberId,postId,creationDate,content);
	}
}
