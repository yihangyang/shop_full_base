package com.shop.service;

import com.github.pagehelper.PageInfo;
import com.shop.goods.pojo.Brand;
import java.util.List;

public interface BrandService {

    // find all
    List<Brand> findAll();
    // find One by id
    Brand findById(int id);
    // add brand
    void add(Brand brand);
    // modify brand
    void update(Brand brand);
    // delete brand
    void delete(int id);
    // find brands by conditions
    List<Brand> findList(Brand brand);
    // query with  pagehelper => page: currentpage, size: the data number on each page
    PageInfo<Brand> findPage(int page, int size);
    // query with  pagehelper + conditions
    PageInfo<Brand> findPage(Brand brand,int page, int size);



}
