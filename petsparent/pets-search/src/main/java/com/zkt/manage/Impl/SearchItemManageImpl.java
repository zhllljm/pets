package com.zkt.manage.Impl;

import com.zkt.common.api.BaseApiService;
import com.zkt.dao.ItemSearchMapper;
import com.zkt.entity.SearchItem;
import com.zkt.manage.SearchItemManage;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchItemManageImpl extends BaseApiService implements SearchItemManage {

    @Autowired
    private ItemSearchMapper itemSearchMapper;

    @Autowired
    private SolrClient solrClient;


    @Override
    public Map<String, Object> importAllItems() {
        //注入mapper,发布服务
        //调用mapper，查询所有数据
        //注入solrServer对象
        try {
            //查询商品列表
            List<SearchItem> list = itemSearchMapper.getAllList();
            //遍历商品列表
            //为每个商品创建一个solrInputDocument
            for (SearchItem s : list) {
                //创建文档对象
                SolrInputDocument document = new SolrInputDocument();
                //向文档对象添加域
                document.addField("id", s.getWareid());
                document.addField("item_title", s.getWarename());
                document.addField("item_price", s.getProprice());
                document.addField("item_category_name", s.getName());
                document.addField("item_desc", s.getWaredetailed());
                // 把文档对象写入索引库
                solrClient.add(document);
            }
            //提交
            solrClient.commit();
            //返回导入成功
            return setResultSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return setResultError("失败");
        }
    }
}
