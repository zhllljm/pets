package com.zkt.web.feign;

import com.zkt.api.service.ItemService;
import com.zkt.config.MultipartSupportConfig;
import com.zkt.entitys.ItemCat;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "content",configuration = MultipartSupportConfig.class)
public interface ItemFeign extends ItemService{

}
