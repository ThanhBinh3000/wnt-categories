package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ActiveSubstance")
public class ActiveSubstance extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "DoseByWeight")
    private String doseByWeight;

    @Column(name = "DoseMinimum")
    private Integer doseMinimum;

    @Column(name = "DoseMaximum")
    private Integer doseMaximum;

    @OneToMany(mappedBy = "activeSubstance")
    private List<ActiveSubstanceContents> contents;
    @OneToMany(mappedBy = "activeSubstance")
    private List<ActiveSubstanceDoseOfTimeADay> doseOfTimeADay;
}
