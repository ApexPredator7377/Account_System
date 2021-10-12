package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction",
    description = "DTO representing AccountTransaction")

public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = 2685715732961109888L;

    private Long memberId;
    private BigDecimal amount;
    private LocalDate transactionDate;
    private Long accountTypeId;

    public AccountTransactionDto() {

    }

    public AccountTransactionDto(Long memberId, BigDecimal amount, LocalDate transactionDate, Long accountTypeId) {
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountTypeId = accountTypeId;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setMemberID(accountTransaction.getMemberId());
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());
        this.setAccountTypeId(accountTransaction.getAccountTypeID());

    }

    @ApiModelProperty(position = 1,
        value = "AccountTransaction Member ID",
        name = "MemberID",
        notes = "Uniquely identifies member ID",
        dataType = "java.lang.String",
        example = "32647",
        required = true)
    public Long getMemberID() {
        return memberId;
    }

    public void setMemberID(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransaction Amount",
            name = "Amount",
            notes = "Uniquely identifies amount",
            dataType = "java.lang.String",
            example = "25647",
            required = true)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTransaction Transaction Date",
            name = "TransactionDate",
            notes = "Uniquely identifies the creation date of a transaction",
            dataType = "java.lang.String",
            example = "2020-06-07",
            required = true)
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @ApiModelProperty(position = 4,
            value = "AccountTransaction Account type ID",
            name = "AccountTypeID",
            notes = "Uniquely identifies the Account type ID",
            dataType = "java.lang.String",
            example = "01",
            required = true)
    public Long getAccountTypeID() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(accountTypeId, that.accountTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, amount, transactionDate, accountTypeId);
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction() {
        return new AccountTransaction(getMemberID(), getAmount(), getTransactionDate(), getAccountTypeID());
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", accountTypeId=" + accountTypeId +
                '}';
    }
}
