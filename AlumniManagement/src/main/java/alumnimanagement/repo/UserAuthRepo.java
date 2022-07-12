package alumnimanagement.repo;

import alumnimanagement.entity.authUser.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {
    @Query("select  u from UserAuth u Where u.username =:username")
    UserAuth findByUsernameAndActive(@Param("username") String username);

    @Query("select u.Role from UserAuth u Where u.id =:id")
    String getRoleById(@Param("id") long id);
}
