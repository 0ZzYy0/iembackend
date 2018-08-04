package com.iem.safety.iembackend.web;


import com.iem.safety.iembackend.buildingsusage.BuildingUsageRepository;
import com.iem.safety.iembackend.customer.CustomerRepository;
import com.iem.safety.iembackend.news.NewsRepository;
import com.iem.safety.iembackend.structuretype.StructureTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi 2018-01-08 15:58
 */
@Controller
@RequestMapping("")
@SuppressWarnings(value = "unused")
public class WebController {


    private final NewsRepository newsRepository;
    private final CustomerRepository customerRepository;
    private final WebService service;
    private final BuildingUsageRepository buildingUsageRepository;
    private final StructureTypeRepository structureTypeRepository;

    public WebController(NewsRepository newsRepository, CustomerRepository customerRepository, WebService service, BuildingUsageRepository buildingUsageRepository, StructureTypeRepository structureTypeRepository) {
        this.newsRepository = newsRepository;
        this.customerRepository = customerRepository;
        this.service = service;
        this.buildingUsageRepository = buildingUsageRepository;
        this.structureTypeRepository = structureTypeRepository;
    }

    @RequestMapping("")
    String home() {
        return "homepage";
    }

    @RequestMapping("login")
    String loginCustomer() {

//        String[] strings = {"住宅（公寓、居民楼等）", "政府（政府机关、科研院所等）",
//                "商业（商场、酒店等）", "站点（机场、火车站等）", "工业厂房（重、轻工业厂房等）",
//                "公共集会场所（体育馆、影剧院等）", "医疗卫生系统（医院、诊所等）",
//                "生命线（生命线系统结构）", "文化教育系统（学校等）", "其它（物资储存设施等）"};
//        for (String string : strings) {
//            BuildingUsage buildingUsage = buildingUsageRepository.findBuildingUsageByUsage(string);
//            buildingUsage = buildingUsage == null ? new BuildingUsage() : buildingUsage;
//            buildingUsage.setUsage(string);
//            buildingUsageRepository.save(buildingUsage);
//        }
//
//        String[] strings1 = {"多层砌体房屋", "多层和高层钢筋混凝土房屋", "底层框架房屋", "内框架房屋", "单层钢筋混凝土柱厂房", "单层砖柱厂房和空旷厂房", "木结构房屋", "土石墙房屋", "空间钢结构"};
//        for (String string : strings1) {
//            StructureType structureType = structureTypeRepository.findStructureTypeByTypeName(string);
//            structureType = structureType == null ? new StructureType() : structureType;
//            structureType.setUsage(string);
//            structureType.setLevel(0);
//            structureTypeRepository.save(structureType);
//        }

        return "customerloginpage";
    }


    @RequestMapping("loginsu")
    String loginSupper() {
        return "superadminloginpage";
    }

    @RequestMapping("loginadmin")
    String loginNormalAdmin() {
        return "normaladminloginpage";
    }

    @RequestMapping("su/manage")
    String suManage() {
        return "superadminmanagepage";
    }

    @RequestMapping("su/customer")
    String suCustomer() {
        return "sucustomerpage";
    }

    @RequestMapping("su/StructureParts")
    String suStructureParts(@RequestParam("tid") String tid,
                            Model model) {
        return service.suStructureParts(tid, model);
    }

    @RequestMapping("admin/manage")
    String adminManage(@RequestParam("eid") String eid, Model model) {
        return service.adminManage(eid, model);
    }

    @RequestMapping("admin/information")
    String adminInfo() {
        return "normalinformationpage";
    }

    @RequestMapping("admin/data")
    String adminData() {
        return "normaldatapage";
    }

    @RequestMapping("admin/media")
    String adminMedia() {
        return "normalmediapage";
    }

    @RequestMapping("customer/manage")
    String customerSelf(@RequestParam("id") String id, Model model,
                        HttpServletRequest request) {
        return service.customerManagePage(id, model, request);
    }

    @RequestMapping("customer/data")
    String customerData(@RequestParam("eid") String eid,
                        @RequestParam("cid") String cid, Model model) {
        return service.customerData(eid, cid, model);
    }


    @RequestMapping("news/newsdetail")
    String newsDetail(@RequestParam("id") String id, Model model) {
        model.addAttribute("news", newsRepository.findNewsById(id));
        return "newsdetailpage";
    }
}
