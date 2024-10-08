package com.crmFB.crmFB.Client;

import com.crmFB.crmFB.Province.Province;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(
        name = "emailid_unique",
        columnNames = "email_address"))
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Client
{
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence")
    private long clientId;
    private String name;
    private Long phone;
    @Column(name = "email_address", nullable = false)
    private String email;
    private int budget;
    private String feedback;
    private boolean status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ProvinceId", referencedColumnName = "provinceId")
    private Province province;

    public Client(final String name,
                  final Province province,
                  final Long phone,
                  final String email,
                  final int budget,
                  final String feedback,
                  final boolean status) {
        this.name = name;
        this.province = province;
        this.phone = phone;
        this.email = email;
        this.budget = budget;
        this.feedback = feedback;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", budget=" + budget +
                ", feedback='" + feedback + '\'' +
                ", status=" + status +
                '}';
    }
}
