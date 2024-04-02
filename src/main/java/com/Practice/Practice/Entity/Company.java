package com.Practice.Practice.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
    @Id
    private UUID id;
    private String companyName;
    private String email;
    private Integer strength;
    private String webSiteURL;
    private String company_code;
    }

