package com.crar.AwidCar.repository;

import com.crar.AwidCar.entity.NotificationGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationGroupRepository extends JpaRepository<NotificationGroup, Long> {
    Page<NotificationGroup> findAll(Specification spec, Pageable pageable);
}
