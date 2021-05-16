package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter //Getter
@Setter //Setter
@NoArgsConstructor  //Default Constructor
@AllArgsConstructor //Constructor
public class Comment {
    private Integer id;
    private String memberID;
    private Integer postID;
    private Date date;
    private String content;

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
