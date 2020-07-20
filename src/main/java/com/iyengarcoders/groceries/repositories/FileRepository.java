package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Files, String> {
}
