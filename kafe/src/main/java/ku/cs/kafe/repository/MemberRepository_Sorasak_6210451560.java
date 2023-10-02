package ku.cs.kafe.repository;


import ku.cs.kafe.entity.Member_Sorasak_6210451560;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;


@Repository
public interface MemberRepository_Sorasak_6210451560 extends JpaRepository<Member_Sorasak_6210451560, UUID> {
    Member_Sorasak_6210451560 findByUsername(String username);
}
