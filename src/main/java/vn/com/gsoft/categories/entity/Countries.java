package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Countries")
public class Countries extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Iso")
    private String iso;
    @Column(name = "Iso3")
    private String iso3;
    @Column(name = "Name")
    private String name;
    @Column(name = "NumCode")
    private Integer numCode;
    @Column(name = "PhoneCode")
    private Integer phoneCode;
}

