package org.jetbrains.assignment.repository;

import org.jetbrains.assignment.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {}