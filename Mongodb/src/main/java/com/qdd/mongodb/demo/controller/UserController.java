package com.qdd.mongodb.demo.controller;

import com.qdd.mongodb.demo.bean.UserEntity;
import com.qdd.mongodb.demo.common.BaseResult;
import com.qdd.mongodb.demo.common.BaseResultGenerator;
import com.qdd.mongodb.demo.common.page.PageBean;
import com.qdd.mongodb.demo.req.UserQueryRequest;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 新增一个user
     * @param user
     * @return
     */
    @PostMapping("/insert")
    private BaseResult addUser(UserEntity user){
        System.out.println("user:"+user);
        UserEntity save = mongoTemplate.insert(user);
        return BaseResultGenerator.success(save);
    }

    /**
     * 新增或修改user
     * @param user
     * @return
     */
    @PostMapping("/save")
    private BaseResult  saveUser( UserEntity user){
        System.out.println("user:"+user);
        UserEntity save = mongoTemplate.save(user);
        return BaseResultGenerator.success(save);
    }

    @RequestMapping("/update")
    private BaseResult  updateUser( UserEntity user){
        System.out.println("user:"+user);
        Query query = Query.query(Criteria.where("_id").is(user.getId()));
        Update update = new Update();
//        update.set("id",user.getId());
        update.set("age",user.getAge());
        update.set("email",user.getEmail());
        update.set("name",user.getName());
        UpdateResult result = mongoTemplate.upsert(query, update, UserEntity.class);
        return BaseResultGenerator.success(result);
    }

    /**
     * 删除
     * @param user
     * @return
     */
    @RequestMapping("/delete")
    private BaseResult  deleteUser(UserEntity user){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(user.getId()));
        DeleteResult remove = mongoTemplate.remove(query, UserEntity.class);
        return BaseResultGenerator.success(remove);
    }

    /**
     * 查询所有记录
     * @return
     */
    @RequestMapping("/findall")
    private BaseResult  findUser(){
        List<UserEntity> list = mongoTemplate.findAll(UserEntity.class);
        return BaseResultGenerator.success(list);
    }

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    @RequestMapping("/findone")
    private BaseResult  queryOne(@RequestParam("name")String name){
        System.out.println("name:"+name);
        Query query = Query.query(Criteria.where("status").is(1).and("name").is(name));
        List<UserEntity> list = mongoTemplate.find(query, UserEntity.class);
        return BaseResultGenerator.success(list);
    }

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @RequestMapping("/findlike")
    private BaseResult  findLike(@RequestParam("name")String name){
        System.out.println("name:"+name);
        Query query = Query.query(Criteria.where("status").is(1).and("name").regex("^.*"+name+".*$"));
        List<UserEntity> list = mongoTemplate.find(query, UserEntity.class);
        return BaseResultGenerator.success(list);
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/findlist")
    private BaseResult  findList(UserQueryRequest request){
        PageBean<UserEntity> pageBean = new PageBean<>();
//        Integer pages = (int)Math.ceil((double)request.get / (double)request.getPageSize());
        pageBean.setCurrentPage(request.getCurrentPage());
        pageBean.setPageSize(request.getPageSize());
        //从当前页查找，过滤前几页的数据
        int skip = request.getPageSize()*(request.getCurrentPage()-1);
        Query query = Query.query(Criteria.where("status").is(1));
        query.skip(skip).limit(request.getPageSize());
        List<UserEntity> list = mongoTemplate.find(query, UserEntity.class);
        long count =mongoTemplate.count(query,UserEntity.class);
        pageBean.setTotalNum(count);
        pageBean.setItems(list);
        return BaseResultGenerator.success(pageBean);
    }

}
