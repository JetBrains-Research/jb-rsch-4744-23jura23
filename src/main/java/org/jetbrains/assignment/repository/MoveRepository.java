package org.jetbrains.assignment.repository;

import org.jetbrains.assignment.model.Move;
import org.springframework.data.repository.CrudRepository;

public interface MoveRepository extends CrudRepository<Move, Long> {}

