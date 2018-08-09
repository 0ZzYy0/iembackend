package com.iem.safety.iembackend.geologydisaster;

import com.iem.safety.iembackend.customer.Customer;
import com.iem.safety.iembackend.customer.CustomerRepository;
import com.iem.safety.iembackend.earthquake.Earthquake;
import com.iem.safety.iembackend.earthquake.EarthquakeRepository;
import com.iem.safety.iembackend.group.Group;
import com.iem.safety.iembackend.group.GroupRepository;
import com.iem.safety.iembackend.intensitysurvey.Intensitysurvey;
import com.iem.safety.iembackend.multisurvey.Multisurvey;
import com.iem.safety.iembackend.multisurvey.MultisurveyRepository;
import com.iem.safety.iembackend.multisurvey.PartSurvey;
import com.iem.safety.iembackend.utils.DownloadFileUtils;
import com.iem.safety.iembackend.utils.ExcelUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zy 2018-01-08 15:58
 */
@Service
public class GeologyDisasterService {

    private final static String rootPath = System.getProperty("user.dir");
    private final static String fileDir = System.getProperty("user.dir") + File.separator + "static";


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final EarthquakeRepository earthquakeRepository;
    private final GeologyDisasterRepository repository;
    private final GroupRepository groupRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public GeologyDisasterService(EarthquakeRepository earthquakeRepository, GeologyDisasterRepository repository, GroupRepository groupRepository, CustomerRepository customerRepository) {
        this.earthquakeRepository = earthquakeRepository;
        this.repository = repository;
        this.groupRepository = groupRepository;
        this.customerRepository = customerRepository;
    }

    void exportGeologyDisasterAll(String earthquakeId, HttpServletResponse res) {
        String dir = fileDir + File.separator + earthquakeId;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return;
            }
        }
        Earthquake earthquake = earthquakeRepository.findEarthquakeById(earthquakeId);
        String sheetName = "geologyDisaster";
        String fileName = "geologyDisaster" + DateTime.now().getMillis() + ".xlsx";
        String[] rowNames = {"编号", "地震名称", "调查点名称", "调查点位置", "调查点经度",
                "调查点纬度","震级", "调查时间","地质灾害类型","地质灾害形态","地质灾害大小",
                "是否编制地质灾害分布图","岩性构造条件","水文地质条件","变形机制分析","烈度评定初步意见",
                "烈度综合评定", "调查人","专业", "单位", "职称"};
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);
        List<GeologyDisaster> geologyDisasters = repository.findGeologyDisasterByEarthquakeIdAndStatus(earthquakeId, "working");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < geologyDisasters.size(); i++) {
            List<String> li = new ArrayList<>();
            GeologyDisaster geologyDisaster = geologyDisasters.get(i);
            li.add((i + 1) + "");
            li.add(earthquake.getName());
            li.add(geologyDisaster.getName());
            li.add(geologyDisaster.getAdderss());
            li.add(geologyDisaster.getLng());
            li.add(geologyDisaster.getLat());
            li.add(geologyDisaster.getIntensityIndex());
            li.add(geologyDisaster.getTime());
            li.add(geologyDisaster.getType());
            li.add(geologyDisaster.getShape());
            li.add(geologyDisaster.getSize());
            li.add(geologyDisaster.getWonaghdmic());
            li.add(geologyDisaster.getLsc());
            li.add(geologyDisaster.getHc());
            li.add(geologyDisaster.getAodm());
            li.add(geologyDisaster.getPooeoi());
            li.add(geologyDisaster.getCeoi());

            Customer customer = customerRepository.findCustomerById(geologyDisaster.getOwnerId());
            li.add(customer.getName());
            li.add(customer.getDiscipline());
            li.add(customer.getDepartment());
            li.add(customer.getProfTitle());
            lists.add(li);
        }


        ExcelUtils excelUtils = new ExcelUtils(rowNames, lists, file, sheetName);
        try {
            excelUtils.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DownloadFileUtils downloadFileUtils = new DownloadFileUtils();
        downloadFileUtils.downloadFile(res, fileName, file);

    }

    void exportGeologyDisasterByGroup(HttpServletResponse res, String earthquakeId) {
        String dir = fileDir + File.separator + earthquakeId;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return;
            }
        }
        Earthquake earthquake = earthquakeRepository.findEarthquakeById(earthquakeId);
        String sheetName = "geologyDisaster";
        String fileName = "geologyDisaster" + DateTime.now().getMillis() + ".xlsx";
        String[] rowNames = {"编号", "地震名称", "调查点名称", "调查点位置", "调查点经度",
                "调查点纬度","震级", "调查时间","地质灾害类型","地质灾害形态","地质灾害大小",
                "是否编制地质灾害分布图","岩性构造条件","水文地质条件","变形机制分析","烈度评定初步意见",
                "烈度综合评定", "调查人","专业", "单位", "职称"};
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);

        List<Group> groups = groupRepository.findGroupsByEarthquakeIdAndIsLeader(earthquakeId, "是");

        Map<String, Object> map = new HashMap<>();
        groups.forEach(group -> map.put(group.getCustomerId(), new Object()));
        List<GeologyDisaster> geologyDisasters = repository.findGeologyDisasterByEarthquakeIdAndStatus(earthquakeId, "working");

        int count = 1;
        List<List<String>> lists = new ArrayList<>();
        for (GeologyDisaster geologyDisaster : geologyDisasters) {
            String customerId = geologyDisaster.getOwnerId();
            if (!map.containsKey(customerId))
                continue;
            List<String> li = new ArrayList<>();
            li.add((count++) + "");
            li.add(earthquake.getName());
            li.add(geologyDisaster.getName());
            li.add(geologyDisaster.getAdderss());
            li.add(geologyDisaster.getLng());
            li.add(geologyDisaster.getLat());
            li.add(geologyDisaster.getIntensityIndex());
            li.add(geologyDisaster.getTime());
            li.add(geologyDisaster.getType());
            li.add(geologyDisaster.getShape());
            li.add(geologyDisaster.getSize());
            li.add(geologyDisaster.getWonaghdmic());
            li.add(geologyDisaster.getLsc());
            li.add(geologyDisaster.getHc());
            li.add(geologyDisaster.getAodm());
            li.add(geologyDisaster.getPooeoi());
            li.add(geologyDisaster.getCeoi());

            Customer customer = customerRepository.findCustomerById(customerId);
            li.add(customer.getName());
            li.add(customer.getDiscipline());
            li.add(customer.getDepartment());
            li.add(customer.getProfTitle());
            lists.add(li);
        }


        ExcelUtils excelUtils = new ExcelUtils(rowNames, lists, file, sheetName);
        try {
            excelUtils.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DownloadFileUtils downloadFileUtils = new DownloadFileUtils();
        downloadFileUtils.downloadFile(res, fileName, file);
   }


    public void exportCustomerGeologyDisasterByEid(String eid, String cid, HttpServletResponse res) {
        String dir = fileDir + File.separator + cid;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return;
            }
        }
        Earthquake earthquake = earthquakeRepository.findEarthquakeById(eid);
        String sheetName = "geologyDisaster";
        String fileName = "geologyDisaster" + DateTime.now().getMillis() + ".xlsx";
        String[] rowNames = {"编号", "地震名称", "调查点名称", "调查点位置", "调查点经度",
                "调查点纬度","震级", "调查时间","地质灾害类型","地质灾害形态","地质灾害大小",
                "是否编制地质灾害分布图","岩性构造条件","水文地质条件","变形机制分析","烈度评定初步意见",
                "烈度综合评定", "调查人","专业", "单位", "职称"};
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);
        List<GeologyDisaster> geologyDisasters = repository.findGeologyDisasterByEarthquakeIdAndOwnerIdAndStatus(eid, cid, "working");
        List<List<String>> lists = new ArrayList<>();
        Customer customer = customerRepository.findCustomerById(cid);
        for (int i = 0; i < geologyDisasters.size(); i++) {
            GeologyDisaster geologyDisaster = geologyDisasters.get(i);
            List<String> li = new ArrayList<>();
            li.add((i + 1) + "");
            li.add(earthquake.getName());
            li.add(geologyDisaster.getName());
            li.add(geologyDisaster.getAdderss());
            li.add(geologyDisaster.getLng());
            li.add(geologyDisaster.getLat());
            li.add(geologyDisaster.getIntensityIndex());
            li.add(geologyDisaster.getTime());
            li.add(geologyDisaster.getType());
            li.add(geologyDisaster.getShape());
            li.add(geologyDisaster.getSize());
            li.add(geologyDisaster.getWonaghdmic());
            li.add(geologyDisaster.getLsc());
            li.add(geologyDisaster.getHc());
            li.add(geologyDisaster.getAodm());
            li.add(geologyDisaster.getPooeoi());
            li.add(geologyDisaster.getCeoi());
            li.add(customer.getName());
            li.add(customer.getDiscipline());
            li.add(customer.getDepartment());
            li.add(customer.getProfTitle());
            lists.add(li);
        }
        ExcelUtils excelUtils = new ExcelUtils(rowNames, lists, file, sheetName);
        try {
            excelUtils.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DownloadFileUtils downloadFileUtils = new DownloadFileUtils();
        downloadFileUtils.downloadFile(res, fileName, file);
    }
}
