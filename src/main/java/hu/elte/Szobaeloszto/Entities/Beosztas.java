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
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Beosztas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iD;

    @Column
    @NotNull
    private String neptunKod;
    
    @Column
    @NotNull
    private String diakNeve;
      
    @Column
    @NotNull
    private String epulet;
    
    /*@Column
    @NotNull
    private String szobatars1;
    
    @Column
    @NotNull
    private String szobatars2;*/
    
    @Column
    @NotNull
    private int emelet;
        
    @Column
    @NotNull
    private int szobaSzam;
}
