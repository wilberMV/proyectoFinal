/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.dao.ProductsDao;
import pe.edu.upeu.model.Products;

/**
 *
 * @author server-itecs
 */
@Service("productsService")
@Transactional
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    public ProductsDao dao;

    @Override
    public List<Products> listProductos() {
        return dao.listProductos();
    }

    @Override
    public void guardarProducto(Products products) {
        dao.guardarProducto(products);
    }

    @Override
    public void eliminarProductoId(int id) {
        dao.eliminarProductoId(id);
    }

    @Override
    public void modificarProductoId(Products products) {
        dao.modificarProductoId(products);
    }

    @Override
    public List<Products> listarPorNombre(String nombre) {
        return dao.listarPorNombre(nombre);
    }

    @Override
    public Products buscarProductoId(int id) {
        return dao.buscarProductoId(id);
    }

}
