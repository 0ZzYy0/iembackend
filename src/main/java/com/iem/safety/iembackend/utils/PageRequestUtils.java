package com.iem.safety.iembackend.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author MengQi 2018-06-07 09:26
 */
public class PageRequestUtils {
    /**
     * * 创建分页请求.
     */
    public static PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = new Sort(Sort.Direction.DESC, sortType);
        //参数1表示当前第几页,参数2表示每页的大小,参数3表示排序
        return PageRequest.of(pageNumber, pageSize, sort);
    }
}
