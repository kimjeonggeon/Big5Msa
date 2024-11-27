package Big5.big5.adapters;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChatResponse {
    private String id;
    private String object;
    private int created;
    private String model;
    private List<Choices> choices;
    private Usage usage;
    @JsonProperty("system_fingerprint")
    private String systemFingerprint;
}