package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private Integer id;
    private String memberID;
    private String title;
    private String content;
    private Date creationDate;
    private Classification classification;


    public Post(Integer id, String memberID, String title, String content, Date creationDate,
			Classification classification) {
		super();
		this.id = id;
		this.memberID = memberID;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
		this.classification = classification;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public Post( String memberID, String title, String content, Date creationDate, Classification classification) {
        this.memberID = memberID;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", memberID='" + memberID + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", classification=" + classification +
                '}';
    }

    public static Post createPost(List<String> list){
        String memberId=list.get(0);
        String title=list.get(1);
        String content=list.get(2);
        Date creationDate=new Date(System.currentTimeMillis());
        Classification classification=Classification.valueOf(list.get(3));

        return new Post(memberId,title,content,creationDate,classification);
    }
}
