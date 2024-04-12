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
@Table(name = "Area")
public class Area extends BaseEntity{
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "AreaCode")
    private String areaCode;
    @Column(name = "AreaName")
    private String areaName;
}

