package za.ac.nwu.as.web.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.as.domain.service.GeneralResponse;

@RestController
public class AccountTypeController
{
    @GetMapping("/all")
    public GeneralResponse<String> getAll() { return new GeneralResponse<>(true, "No types found");}
}