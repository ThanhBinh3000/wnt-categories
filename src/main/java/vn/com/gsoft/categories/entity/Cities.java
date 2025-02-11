package vn.com.gsoft.categories.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cities")
public class Cities extends BaseEntity{
    @Id
    @Column(name = "Id")
    private Long id;
    @Column(name = "RegionId")
    private Long regionId;
    @Column(name = "Name")
    private String name;
}

