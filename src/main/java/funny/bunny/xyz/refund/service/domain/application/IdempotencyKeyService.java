package funny.bunny.xyz.refund.service.domain.application;

import funny.bunny.xyz.refund.service.domain.IdempotencyKey;
import funny.bunny.xyz.refund.service.domain.events.IdempotencyKeyRequestUsage;
import funny.bunny.xyz.refund.service.domain.exception.IdempotencyKeyAlreadyUsed;
import funny.bunny.xyz.refund.service.domain.repositories.IdempotencyKeyRepository;
import java.util.UUID;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class IdempotencyKeyService {

  private final IdempotencyKeyRepository idempotencyKeyRepository;

  public IdempotencyKeyService(IdempotencyKeyRepository idempotencyKeyRepository) {
    this.idempotencyKeyRepository = idempotencyKeyRepository;
  }

  public void handleUsage(IdempotencyKeyRequestUsage event) {
    try {
      this.idempotencyKeyRepository.insert(new IdempotencyKey(UUID.fromString(event.getIdempotencyKey())));
    }catch (DataIntegrityViolationException e){
      throw new IdempotencyKeyAlreadyUsed();
    }
  }
}
