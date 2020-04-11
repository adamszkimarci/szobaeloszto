package hu.elte.Szobaeloszto.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Szoba implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iD;

    @Column
    @NotNull
    private String epuletNev;

    @Column
    @NotNull
    private Integer emeletSzama;
    
    @Column
    @NotNull
    private Integer szobaSzama;
    
    @Column
    @NotNull
    private Integer feroHely;
    
    @JsonIgnore
    @OneToMany(mappedBy = "szoba")
    private List<Diak> diakok;
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Epulet epulet;
}
