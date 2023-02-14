package eucis.libraryapp.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDeleteRequest {
    private long id;
    private  String name;
}
