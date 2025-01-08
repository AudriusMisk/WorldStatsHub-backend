package lt.ca.javau11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.ca.javau11.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}
