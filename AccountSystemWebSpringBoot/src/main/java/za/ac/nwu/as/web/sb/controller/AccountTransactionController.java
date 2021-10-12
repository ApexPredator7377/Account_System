package za.ac.nwu.as.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.as.logic.flow.FetchAccountTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountTransactionController {

    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;
    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private AccountTransactionDto accountTransaction;

    @Autowired
    public AccountTransactionController(FetchAccountTransactionFlow fetchAccountTransactionFlow,
                                        @Qualifier("createAccountTransactionFlowName") CreateAccountTransactionFlow createAccountTransactionFlow){
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
        this.createAccountTransactionFlow = createAccountTransactionFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all Transactions.", notes = "Returns a list of transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transaction returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){
        List<AccountTransactionDto> accountTypes = fetchAccountTransactionFlow.getAccountTransaction();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new transaction.", notes = "Creates a new Transaction in DB")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transaction created", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new Transaction.", required = true)
            @RequestBody AccountTransactionDto accountType) {
        AccountTransactionDto accountTypeResponse = createAccountTransactionFlow.create(accountType);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
