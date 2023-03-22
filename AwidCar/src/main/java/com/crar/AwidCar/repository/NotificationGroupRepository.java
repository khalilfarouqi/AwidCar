package com.crar.AwidCar.repository;

import com.crar.AwidCar.entity.NotificationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationGroupRepository extends JpaRepository<NotificationGroup, Long> {
}
