package prediktive.challenge.pojo;

import lombok.Data;

import java.util.List;

@Data
public class RelatedTopic {
    private String FirstURL;
    private String Result;
    private String Text;
    private Icon Icon;

    private String Name;
    private List<RelatedTopic> Topics;
}