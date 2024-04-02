package com.Practice.Practice.Service;
import com.Practice.Practice.Dto.CompanyDto;
import com.Practice.Practice.Entity.Company;
import com.Practice.Practice.Repositary.CompanyID;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class Companyadata {

    private final CompanyID companyID;
    private final ModelMapper modelMapper;

    @Autowired
    public Companyadata(CompanyID companyID, ModelMapper modelMapper){
        this.companyID = companyID;
        this.modelMapper = modelMapper;
    }

    public CompanyDto cretecompny(CompanyDto companyDto){
        Company company = modelMapper.map(companyDto, Company.class);
        companyID.save(company);
        return companyDto;
    }

    public CompanyDto retrivealldata(UUID id){
        Optional<Company> optionalCompany = companyID.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            return modelMapper.map(company, CompanyDto.class);
        } else {
            return null; // or throw exception, handle as needed
        }
}

    public CompanyDto retrivedataByCompanycode(String company_code) {
        Optional<Company> optionalCompany = companyID.findbyCompanycode(company_code);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            return modelMapper.map(company, CompanyDto.class);
        } else {
            return null; // or throw exception, handle as needed
        }
    }

    public CompanyDto partialUpdateCompany(UUID id, Map<Object,Object> updates) {
        Optional<Company> optionalCompany = companyID.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            // Apply updates from the map
            Company finalCompany = company;
            updates.forEach((key, value) -> {
                switch (key.toString()) {
                    case "companyName":
                        finalCompany.setCompanyName(value.toString());
                        break;
                    case "email":
                        finalCompany.setEmail(value.toString());
                        break;
                    case "strength":
                        finalCompany.setStrength(Integer.parseInt(value.toString()));
                        break;
                    case "webSiteURL":
                        finalCompany.setWebSiteURL(value.toString());
                        break;
                    case "company_code":
                        finalCompany.setCompany_code(value.toString());
                        break;
                    default:
                        break;
                }
            });
            company=finalCompany;
            company = companyID.save(company);
            return modelMapper.map(company, CompanyDto.class);
        } else {
            return null; // or throw an exception
        }
    }

}

