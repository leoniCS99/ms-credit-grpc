package ms.grpc.controller;

import br.com.credit.v1.CreditServiceGrpc;
import br.com.credit.v1.creditReq;
import br.com.credit.v1.creditRes;
import io.grpc.stub.StreamObserver;
import ms.grpc.domain.Credit;
import ms.grpc.repository.CreditRepository;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CreditController extends CreditServiceGrpc.CreditServiceImplBase {
    private final CreditRepository repository;

    public CreditController(CreditRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(creditReq request, StreamObserver<creditRes> responseObserver) {
       var credit = new Credit(
                   request.getCpf(),
                   request.getCreditAmount(),
                   request.getTerminMonths(),
                   request.getApprovalStatus());

       var createdCredit= repository.save(credit);
       var response = creditRes.newBuilder()
                .setId(createdCredit.getId())
                .setCpf(createdCredit.getCpf())
                .setCreditAmount(createdCredit.getCreditAmount())
                .setTerminMonths(createdCredit.getTerminMonths())
                .setApprovalStatus(createdCredit.getApprovalStatus())
               .build();

       responseObserver.onNext(response);
       responseObserver.onCompleted();
    }
}
