package Big5.big5.adapters;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ChatRequest {
    private String model;
    private List<Message> messages;
    private boolean stream;
}