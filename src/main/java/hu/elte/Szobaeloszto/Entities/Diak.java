package hu.elte.Szobaeloszto.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Diak implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iD;

    @Column(unique = true)
    @NotNull
    private String neptunKod;
    
    @Column
    @NotNull
    private String nev;
    
    @Column(unique = true)
    @NotNull
    private String emailCim;
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Szoba szoba;
}
