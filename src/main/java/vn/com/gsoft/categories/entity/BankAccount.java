package vn.com.gsoft.categories.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BankAccount")
public class BankAccount extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "AccountName")
    private String accountName;
    @Column(name = "StoreCode")
    private String storeCode;
    @Column(name = "BankBIN")
    private String bankBin;
    @Column(name = "AccountNo")
    private String accountNo;

    @Transient
    private String bankLogo;
    @Transient
    private String bankCode;
    @Transient
    private String bankName;
    @Transient
    private String bankShortName;

}
