package ms.grpc.domain;

import br.com.credit.v1.ApprovalStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_CREDIT")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private Double creditAmount;
    private Integer terminMonths;
    private ApprovalStatus approvalStatus;

    public Credit() {}
    public Credit(String cpf, Double creditAmount, Integer terminMonths, ApprovalStatus approvalStatus) {
        this.cpf = cpf;
        this.creditAmount = creditAmount;
        this.terminMonths = terminMonths;
        this.approvalStatus = approvalStatus;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public Integer getTerminMonths() {
        return terminMonths;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }
}
