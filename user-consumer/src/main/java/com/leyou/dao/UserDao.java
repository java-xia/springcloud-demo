package com.leyou.dao;

import com.leyou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public User queryById(Long id){
        // 根据服务名称,获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 由于我只有一个服务,直接get0
        ServiceInstance serviceInstance = instances.get(0);
        // 获取端口信息,拼接请求路径
        String reqUrl = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
        // 获取值
        return restTemplate.getForObject(reqUrl,User.class);
    }
}
