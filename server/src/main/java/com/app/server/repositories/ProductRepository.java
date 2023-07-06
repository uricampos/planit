package com.app.server.repositories;

import com.app.server.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value = """
                SELECT * FROM tb_products
                WHERE organization_id = :organization_id
                """)
    List<Product> findByOrganizationId(@Param("organization_id") Long organizationId);
}
