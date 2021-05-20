package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Post {
    private Integer id;
    private String memberID;
    private String title;
    private String content;
    private Date creationDate;
    private Classification classification;
    private String attachFileName;
    private String filePath;


	public Post(Integer id, String memberID, String title, String content, Date creationDate,
                Classification classification, String attachFileName,String filePath) {
		super();
		this.id = id;
		this.memberID = memberID;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
		this.classification = classification;
		this.attachFileName=attachFileName;
		this.filePath=filePath;
	}


	public Post( String memberID, String title, String content, Date creationDate, Classification classification,String attachFileName,String filePath) {
        this.memberID = memberID;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.classification = classification;
        this.attachFileName=attachFileName;
        this.filePath=filePath;
    }

    public static Post createPost(List<String> list){
        String memberId=list.get(0);
        String title=list.get(1);
        String content=list.get(2);
        Date creationDate=new Date(System.currentTimeMillis());
        Classification classification=Classification.valueOf(list.get(3));
        String attachFileName=list.get(4);
        String filePath=list.get(5);
        return new Post(memberId,title,content,creationDate,classification,attachFileName,filePath);
    }
}
