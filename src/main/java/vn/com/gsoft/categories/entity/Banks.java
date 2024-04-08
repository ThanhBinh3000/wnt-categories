package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Banks")
public class Banks extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Code")
    private String code;
    @Column(name = "Bin")
    private String bin;
    @Column(name = "ShortName")
    private String shortName;
    @Column(name = "Logo")
    private String logo;
    @Column(name = "SwiftCode")
    private String swiftCode;
    @Column(name = "TransferSupported")
    private Integer transferSupported;
    @Column(name = "LookupSupported")
    private Integer lookupSupported;
    @Column(name = "Support")
    private Integer support;
    @Column(name = "IsTransfer")
    private Boolean isTransfer;

}
