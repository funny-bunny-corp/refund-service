package funny.bunny.xyz.refund.service.domain.repositories;

import funny.bunny.xyz.refund.service.domain.Refund;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface RefundRepository extends CrudRepository<Refund, UUID> { }
