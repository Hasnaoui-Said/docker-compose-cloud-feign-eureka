package org.product.gp.rest.provided.facade;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.product.gp.domains.Product;
import org.product.gp.rest.converter.ProductConverter;
import org.product.gp.rest.provided.vo.ProductVo;
import org.product.gp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
@Api("Getsion des products")
public class ProductRessource {

    @Autowired
    ProductService productService;
    @Autowired
    ProductConverter productConverter;


    @GetMapping("/")
    @ResponseBody
    @ApiOperation("Find all products")
    public List<ProductVo> findAll() {
        List<Product> all = productService.findAll();
        List<ProductVo> productVos = new ArrayList<>();
        all.forEach(product -> productVos.add(productConverter.toVo(product)));
        return productVos;
    }
    @GetMapping("/uuid/{uuid}")
    @ResponseBody
    @ApiOperation("Find by uuid")
    public ProductVo findByUuid(@PathVariable UUID uuid) {
        Product p = productService.findByUuid(uuid);
        if (p == null)
            return null;
        return productConverter.toVo(p);
    }

    @GetMapping("/name/{name}")
    @ResponseBody
    @ApiOperation("Find if exist by name")
    public ProductVo findByName(@PathVariable String name) {
        Product p = productService.findByName(name);
        if (p == null)
            return null;
        return productConverter.toVo(p);
    }
    @GetMapping("/exists/name/{name}")
    @ResponseBody
    @ApiOperation("Check if exist by name")
    public boolean existsByName(@PathVariable String name) {
        return productService.existsByName(name);
    }

    @DeleteMapping("/uuid/{uuid}")
    @ResponseBody
    @ApiOperation("Delete if exist by uuid")
    public int deleteByUuid(@PathVariable UUID uuid) {
        return productService.deleteByUuid(uuid);
    }

    @GetMapping("/exists/uuid/{uuid}")
    @ResponseBody
    @ApiOperation("Ckeck if exist by uuid")
    public boolean existsByUuid(@PathVariable UUID uuid) {
        return productService.existsByUuid(uuid);
    }

    @PostMapping("/")
    @ResponseBody
    @ApiOperation("Save new Product")
    public ProductVo save(@RequestBody ProductVo product) {
        System.out.println(product);
        Product save = productService.save(productConverter.toBean(product));
        if (save == null)
            return null;
        return productConverter.toVo(save);
    }
}
