package ro.sd.a3.entity;

import lombok.*;
import java.io.Serializable;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements Serializable {
    private String id;

    private String username;

    private String password;

    private String name;

    private String email;
}
