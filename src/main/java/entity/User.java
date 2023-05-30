package entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private int maxPoints;

    public User(String username, int maxPoints) {
        this.username = username;
        this.maxPoints = maxPoints;
    }
}
