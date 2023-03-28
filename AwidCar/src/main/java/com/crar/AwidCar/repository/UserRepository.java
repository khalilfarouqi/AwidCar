package com.crar.AwidCar.repository;

import com.crar.AwidCar.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Specification spec, Pageable pageable);
    @Query("select u from User u where upper(u.userName) = upper(:username)")
    User findByUsername(String username);
    @Query(value = "SELECT CAST(COUNT(1) AS BIT) AS Expr1 FROM photos\n WHERE id = 4",nativeQuery = true)
    Boolean existsByUsername(String username);
}
