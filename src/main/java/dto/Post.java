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
