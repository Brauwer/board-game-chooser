package brauwer.be.boardgamechooser.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    private String id;
    private String name;
    private String url;

}
