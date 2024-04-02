package com.Practice.Practice.Dto;
import com.Practice.Practice.Validation.EvenNumberorZero;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyDto {
    @NotEmpty(message = "Name must not be empty")
    @Size(min=5)
   private  String companyName;
    @Email
    @NotEmpty
   private String email;
    @PositiveOrZero
    @EvenNumberorZero
    private Integer strength;
   private String webSiteURL;
    @Column(unique = true)
    @Size(min=5,max=5)
    @Pattern(regexp = "^(?i)[a-z]{2}\\d{2}(?i)[EN]$", message = "Invalid string format")
    private String company_code;
}
