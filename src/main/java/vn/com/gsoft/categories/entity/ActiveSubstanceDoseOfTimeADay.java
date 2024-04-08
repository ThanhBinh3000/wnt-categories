package vn.com.gsoft.categories.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ActiveSubstanceDoseOfTimeADay")
public class ActiveSubstanceDoseOfTimeADay extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ActiveSubstanceId", insertable = false, updatable = false)
    private Long activeSubstanceId;
    @Column(name = "DoseOfTimeADay")
    private Long doseOfTimeADay;
    @ManyToOne
    @JoinColumn(name = "ActiveSubstanceId", nullable = false)
    @JsonIgnore
    private ActiveSubstance activeSubstance;
}
