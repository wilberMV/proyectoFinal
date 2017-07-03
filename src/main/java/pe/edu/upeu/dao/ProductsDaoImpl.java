/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.configuration.SysDataAccess;
import pe.edu.upeu.model.Products;

/**
 *
 * @author server-itecs
 */
@Repository("productsDao")
public class ProductsDaoImpl extends SysDataAccess<Integer, Products> implements ProductsDao {

    @Override
    public List<Products> listProductos() {
        return getListAll();
    }

    @Override
    public void guardarProducto(Products products) {
        savev(products);
    }

    @Override
    public void eliminarProductoId(int id) {
        delete(id);
    }

    @Override
    public void modificarProductoId(Products products) {
        update(products);
    }

    @Override
    public List<Products> listarPorNombre(String nombre) {
        return (List<Products>) sessionFactory.getCurrentSession()
                .createQuery("select a from Products a where a.nombreProducto like ? ")
                .setString(0, "%" + nombre + "%")
                .list();
    }

    @Override
    public Products buscarProductoId(int id) {
        return getByKey(id);
    }

}
