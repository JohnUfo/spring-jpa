package uz.muydinovs.appspringjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.io.Serial;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true)
    private String phoneNumber;
}
