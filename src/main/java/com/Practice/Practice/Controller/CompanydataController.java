package com.Practice.Practice.Controller;
import com.Practice.Practice.Dto.CompanyDto;
import com.Practice.Practice.Service.Companyadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;
@RestController
@RequestMapping("/company")
@Validated
public class CompanydataController {
private final Companyadata companyadata;
public CompanydataController(Companyadata companyadata){
    this.companyadata=companyadata;
}
@PostMapping("/createcompany")
public ResponseEntity<?> crratecompany(@RequestBody CompanyDto companyDto) {
    CompanyDto CompanyDto = companyadata.cretecompny(companyDto);
    return new ResponseEntity<>(companyDto, HttpStatus.CREATED);
}
//Add an API to retrieve the Company record by id
@GetMapping("/companycode/{id}")
public ResponseEntity<?> retrivealldata(@PathVariable UUID id) {
        CompanyDto  dto=companyadata.retrivealldata(id);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/companycode/{companycode}")
    public ResponseEntity<?> retrivedataByCompanycode(@PathVariable String company_code) {
        CompanyDto  dto=companyadata.retrivedataByCompanycode(company_code);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @PatchMapping("/companies/{id}")
    public ResponseEntity<?> partialUpdateCompany(@PathVariable UUID id, @RequestBody Map<Object,Object> updates ) {
        CompanyDto  dto=companyadata.partialUpdateCompany(id,updates);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }}