package by.softclub.test.clientservice.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statuses {
    
    @Id
    @Column(name = "name")
    String name;

}
