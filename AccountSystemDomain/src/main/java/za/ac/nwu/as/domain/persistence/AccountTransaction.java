package za.ac.nwu.as.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTIOM", schema = "HR")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 7125642797485930967L;

    private Long accountTransactionId;
    private Long memberId;
    private BigDecimal amount;
    private LocalDate transactionDate;
    private Long accountTypeId;

    public AccountTransaction( Long accountTransactionId, Long memberId, BigDecimal amount, LocalDate transactionDate, Long accountTypeId) {
        this.accountTransactionId = accountTransactionId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountTypeId = accountTypeId;
    }

    public AccountTransaction(Long memberId, BigDecimal amount, LocalDate transactionDate, Long accountTypeId) {
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountTypeId = accountTypeId;
    }

    public AccountTransaction() {

    }

    @Id
    @Column(name = "ACCOUNT_TRANSACTION_ID")
    @SequenceGenerator(name = "ACCOUNT_TRANSACTION_SEQ", sequenceName = "ACCOUNT_TRANSACTION_SEQ_NAME", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TRANSACTION_SEQ")
    public Long getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setAccountTransactionId(Long accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal memberId) {
        this.amount = amount;
    }

    @Column(name = "TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeID() {
        return accountTypeId;
    }

    public void setAccountTypeID(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountTransactionId, that.accountTransactionId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(accountTypeId, that.accountTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransactionId, memberId, amount, transactionDate, accountTypeId);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTransactionId=" + accountTransactionId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", accountTypeId=" + accountTypeId +
                '}';
    }

}
