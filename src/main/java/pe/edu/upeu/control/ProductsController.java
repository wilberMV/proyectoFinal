/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.edu.upeu.model.Products;
import pe.edu.upeu.service.ProductsService;

/**
 *
 * @author server-itecs
 */
@Controller
@RequestMapping("/")
public class ProductsController {

    @Autowired
    ProductsService service;
    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView listProductos(ModelMap model) {
        List<Products> lista = service.listProductos();
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("ListaProductos", lista);
        modelo.put("saludo", "Hola amigos");

        return new ModelAndView("producto/mainProducto", modelo);
    }

    @RequestMapping(value = "formProducto", method = RequestMethod.GET)
    public ModelAndView irFormulario(@ModelAttribute("modeloProducto") Products entidad, BindingResult result) {
        Map<String, Object> modelo = new HashMap<String, Object>();
        return new ModelAndView("producto/formProducto", modelo);
    }

    @RequestMapping(value = "guardarProducto", method = RequestMethod.POST)
    public ModelAndView guardarProducto(@ModelAttribute("modeloProducto") Products entidad,
            BindingResult result) {

        service.guardarProducto(entidad);
        return new ModelAndView(new RedirectView("list"));
    }

    @RequestMapping(value = "buscarProducto", method = RequestMethod.GET)
    public String buscarProducto(HttpServletRequest r, Model model) {
        int id = Integer.parseInt(r.getParameter("id"));
        Products products = null;
        products = service.buscarProductoId(id);
        model.addAttribute("modeloProducto", products);
        return "producto/formUProducto";
    }

    @RequestMapping(value = "actualizarProducto", method = RequestMethod.POST)
    public ModelAndView actualizarProducto(@ModelAttribute("modeloProducto") Products entidad,
            BindingResult result) {
        service.modificarProductoId(entidad);
        return new ModelAndView(new RedirectView("list"));
    }

    @RequestMapping(value = "buscarProductoNombre", method = RequestMethod.POST)
    public ModelAndView buscarProductoNombre(HttpServletRequest r) {
        String dato = r.getParameter("dato") == null ? "" : r.getParameter("dato");
        List<Products> lista = service.listarPorNombre(dato);
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("ListaProductos", lista);
        return new ModelAndView("producto/mainProducto", modelo);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
        // You can register other Custom Editors with the WebDataBinder, like CustomNumberEditor for Integers and Longs, or StringTrimmerEditor for Strings
    }

}
