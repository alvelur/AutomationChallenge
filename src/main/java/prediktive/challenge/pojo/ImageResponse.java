package prediktive.challenge.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ImageResponse {

    private String Abstract;
    private String AbstractSource;
    private String AbstractURL;
    private String Answer;
    private String AnswerType;
    private String Definition;
    private String DefinitionSource;
    private String DefinitionURL;
    private String Entity;
    private String Heading;
    private String Image;
    private int ImageHeight;
    private int ImageIsLogo;
    private int ImageWidth;
    private String Infobox;
    private String Redirect;
    private List<RelatedTopic> RelatedTopics;
    private List<Object> Results;
    private String Type;
    private Object meta;

}
