/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import pe.edu.upeu.model.Products;

/**
 *
 * @author server-itecs
 */
public interface ProductsDao {

    List<Products> listProductos();

    void guardarProducto(Products products);

    void eliminarProductoId(int id);

    void modificarProductoId(Products products);

    List<Products> listarPorNombre(String nombre);

    Products buscarProductoId(int id);

}
