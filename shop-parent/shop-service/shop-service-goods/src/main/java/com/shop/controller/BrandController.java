package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.goods.pojo.Brand;
import com.shop.service.BrandService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    // find all brand
    @GetMapping
    public Result<List<Brand>> findAll() {
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"Obtain all brands list successfully", brands);
    }

    // find by id
    @GetMapping(value = "{id}")
    public Result<Brand> findById(@PathVariable(value = "id") int id) {
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK, "Obtain a brand by id successfully", brand);
    }

    // add brand
    @PostMapping
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "Add a brand successfully");
    }

    // modify brand
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id") int id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "Update a brand successfully");
    }

    // delete
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") int id) {
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "Delete a brand successfully");
    }

    // search with conditions
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand) {
        List<Brand> brands = brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK,"search brand list with conditions successfully", brands);
    }

    // search in pages
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo<Brand>>(true, StatusCode.OK,"paged search successfully", pageInfo);
    }

    // search in pages + conditions
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand, @PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result<PageInfo<Brand>>(true, StatusCode.OK,"paged search successfully", pageInfo);
    }



}
