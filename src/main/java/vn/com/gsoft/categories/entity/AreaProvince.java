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
@Table(name = "AreaProvince")
public class AreaProvince extends BaseEntity{
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "AreaID")
    private Long areaId;
    @Column(name = "ProvinceID")
    private Long provinceId;
}

