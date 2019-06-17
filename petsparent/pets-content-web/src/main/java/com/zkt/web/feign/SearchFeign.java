package com.zkt.web.feign;


import com.zkt.api.service.SearchItemService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("solr")
public interface SearchFeign extends SearchItemService {

}
