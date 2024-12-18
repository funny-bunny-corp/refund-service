package funny.bunny.xyz.refund.service.domain.repositories;

import funny.bunny.xyz.refund.service.domain.IdempotencyKey;
import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IdempotencyKeyRepository extends CrudRepository<IdempotencyKey, UUID> {
  @Modifying
  @Transactional
  @Query(value = "INSERT INTO idempotency_key VALUES ( :#{#idempotencyKey.id} )", nativeQuery = true)
  void insert(@Param("idempotencyKey") IdempotencyKey idempotencyKey);

}
