package com.geeksterAssignment.Employee.address.repository;

import com.geeksterAssignment.Employee.address.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);


    @Modifying
    @Query(value = "DELETE FROM Address,user,product WHERE id = :ProductId" , nativeQuery = true)
    void DeleteProductBasedOnId(Integer ProductId);

//    @Modifying
//    @Query(value = "DELETE  from product \n" +
//            "FROM order_table\n" +
//            "LEFT JOIN address ON order_table.id = :ProductId\n" +
//            "LEFT JOIN product ON address_id.id = :product.id\n" +
//            "LEFT JOIN user ON product_id.id = :ProductId;\n" , nativeQuery = true)
//    void DeleteProductBasedOnId(Integer ProductId);

}
