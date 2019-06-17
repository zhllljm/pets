package com.zkt.service.Impl;

import com.zkt.api.service.SearchItemService;
import com.zkt.common.api.BaseApiService;
import com.zkt.entity.SearchItem;
import com.zkt.manage.SearchItemManage;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchItemServiceImpl extends BaseApiService implements SearchItemService {

    @Autowired
    private SearchItemManage searchItemManage;

    @Override
    public Map<String,Object> importAllItems() {
        return searchItemManage.importAllItems();
    }
}
