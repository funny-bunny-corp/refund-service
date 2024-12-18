package funny.bunny.xyz.refund.service.domain.application;

import funny.bunny.xyz.refund.service.domain.Refund;
import funny.bunny.xyz.refund.service.domain.events.IdempotencyKeyRequestUsage;
import funny.bunny.xyz.refund.service.domain.repositories.RefundRepository;
import funny.bunny.xyz.refund.service.dtos.refund.RequestRefund;
import org.springframework.stereotype.Service;

@Service
public class RefundService {

  private final RefundRepository refundRepository;
  private final IdempotencyKeyService idempotencyKeyService;

  public RefundService(RefundRepository refundRepository,
      IdempotencyKeyService idempotencyKeyService) {
    this.refundRepository = refundRepository;
    this.idempotencyKeyService = idempotencyKeyService;
  }

  public Refund requestRefund(RequestRefund requestRefund,String idempotencyKey){
    IdempotencyKeyRequestUsage idempotencyKeyRequestUsage = new IdempotencyKeyRequestUsage(this, idempotencyKey);
    idempotencyKeyService.handleUsage(idempotencyKeyRequestUsage);
    return null;
  }

}
