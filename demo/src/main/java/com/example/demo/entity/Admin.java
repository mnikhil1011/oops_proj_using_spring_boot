package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name="tbl_admin",
        uniqueConstraints = @UniqueConstraint(
                name="adminemailId_unique",
                columnNames="adminemail_address"
        )
)
public class Admin {

    @Id
    @SequenceGenerator(
            name="admin_sequence",
            sequenceName="admin_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="admin_sequence"
    )
    private long adminId;
    @Column(
            name="adminemail_address",
            nullable = false
    )
    private String adminemailId;
    @Column(length = 60)
    private String password;
    private String adminName;

}
