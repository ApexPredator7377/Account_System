package za.ac.nwu.as.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "HR")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 4711262906001798890L;

    @Id
    @SequenceGenerator(name = "ACCOUNT_TYPE_SEQ", sequenceName = "ACCOUNT_TYPE_SEQ_NAME", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TYPE_SEQ")
    @Column(name = "ACCOUNT_TYPE_ID")
    private Long accountTypeId;

    @Column(name = "MNEMONIC")
    private Long mnemonic;

    @Column(name = "ACCOUNT_TYPE_NAME")
    private Long accountTypeName;

    @Column(name = "CREATION_DATE")
    private Long creationDate;

}
