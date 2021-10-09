package za.ac.nwu.as.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "HR")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 4711262906001798890L;

    private Long accountTypeId;
    private Long mnemonic;
    private Long accountTypeName;
    private Long creationDate;

    public AccountType(){
    }

    public AccountType(Long accountTypeId, Long mnemonic, Long accountTypeName, Long creationDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_TYPE_SEQ", sequenceName = "ACCOUNT_TYPE_SEQ_NAME", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TYPE_SEQ")
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Column(name = "MNEMONIC")
    public Long getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(Long mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public Long getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(Long accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Column(name = "CREATION_DATE")
    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic=" + mnemonic +
                ", accountTypeName=" + accountTypeName +
                ", creationDate=" + creationDate +
                '}';
    }
}
