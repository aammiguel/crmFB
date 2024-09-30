package com.crmFB.crmFB.Province;

import com.crmFB.crmFB.Client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Province {
    @Id
    @SequenceGenerator(sequenceName = "province_sequence",
                        name = "province_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "province_sequence")
    private Long provinceId;
    private String provinceName;
    private boolean visit;

    @OneToMany(mappedBy = "province",
                cascade = CascadeType.ALL)
    private List<Client> clients;


    /**
     * province constructor
     * @param provinceName takes a province name
     * @param visit indicates if the province was already visited
     */
    public Province(final String provinceName,
                    final boolean visit) {
        this.provinceName = provinceName;
        this.visit = visit;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                ", visit=" + visit +
                '}';
    }
}
