package com.iem.safety.iembackend.intensitysurvey;


import com.iem.safety.iembackend.customer.Customer;
import com.iem.safety.iembackend.customer.CustomerRepository;
import com.iem.safety.iembackend.earthquake.Earthquake;
import com.iem.safety.iembackend.earthquake.EarthquakeRepository;
import com.iem.safety.iembackend.group.Group;
import com.iem.safety.iembackend.group.GroupRepository;
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
 * @author MengQi 2018-01-08 15:58
 */
@Service
public class IntensitysurveyService {

    private final static String rootPath = System.getProperty("user.dir");
    private final static String fileDir = System.getProperty("user.dir") + File.separator + "static";


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final EarthquakeRepository earthquakeRepository;
    private final IntensitysurveyRepository repository;
    private final GroupRepository groupRepository;
    private final CustomerRepository customerRepository;
    private final MultisurveyRepository multisurveyRepository;

    @Autowired
    public IntensitysurveyService(EarthquakeRepository earthquakeRepository, IntensitysurveyRepository repository, GroupRepository groupRepository, CustomerRepository customerRepository, MultisurveyRepository multisurveyRepository) {
        this.earthquakeRepository = earthquakeRepository;
        this.repository = repository;
        this.groupRepository = groupRepository;
        this.customerRepository = customerRepository;
        this.multisurveyRepository = multisurveyRepository;
    }

    List<Intensitysurvey> getByOidAndTSLg(String ownerId) {
        long temp = (90L * 24L * 60L * 60L * 1000L);
        return repository.findByOwnerIdAndTimestampGreaterThan(ownerId, new DateTime().getMillis() - temp);
    }


    List<Intensitysurvey> getByEidForMap(String earthquakeId) {
        logger.info(earthquakeId);
        List<Group> groups = groupRepository.findGroupsByEarthquakeIdAndIsLeader(earthquakeId, "是");
        List<Intensitysurvey> list = new ArrayList<>();
        groups.forEach(group -> {
            logger.info(group.getCustomerId());
            List<Intensitysurvey> li = repository.findIntensitysurveysByEarthquakeIdAndOwnerIdAndStatus(earthquakeId, group.getCustomerId(), "working");
            li.forEach(intensitysurvey -> {
                intensitysurvey.setVideoList(null);
                intensitysurvey.setAudioList(null);
                intensitysurvey.setImageList(null);
                intensitysurvey.setAudios(null);
                intensitysurvey.setImages(null);
                intensitysurvey.setVideos(null);
                intensitysurvey.setAddress(null);
                intensitysurvey.setName(null);
                list.add(intensitysurvey);
            });
        });

        return list;
    }

    void exportIntensitySurveyAll(HttpServletResponse res, String earthquakeId) {
        String dir = fileDir + File.separator + earthquakeId;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return;
            }
        }
        Earthquake earthquake = earthquakeRepository.findEarthquakeById(earthquakeId);
        String sheetName = "intensity";
        String fileName = "intensity" + DateTime.now().getMillis() + ".xlsx";
        String[] rowNames = {"编号", "地震名称", "调查点名称", "调查点位置", "调查点经度",
                "调查点纬度", "调查时间", "建议烈度", "海拔高度", "调查点户数", "均户面积",
                "总人口数", "死亡人数", "失踪人数", "重伤人数", "轻伤人数", "调查人",
                "专业", "单位", "职称"};
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);
        List<Intensitysurvey> intensitysurveys = repository.findIntensitysurveysByEarthquakeIdAndStatus(earthquakeId, "working");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < intensitysurveys.size(); i++) {
            List<String> li = new ArrayList<>();
            Intensitysurvey intensity = intensitysurveys.get(i);
            li.add((i + 1) + "");
            li.add(earthquake.getName());
            li.add(intensity.getName());
            li.add(intensity.getAddress());
            li.add(intensity.getLng());
            li.add(intensity.getLat());
            li.add(intensity.getDateTime());
            li.add(intensity.getIntensity());
            li.add(intensity.getAltitude());
            li.add(intensity.getHouseNumber());
            li.add(intensity.getAvgArea());
            li.add(intensity.getTotalPeople());
            li.add(intensity.getDeath());
            li.add(intensity.getMiss());
            li.add(intensity.getSevereWound());
            li.add(intensity.getSlightWound());
            Customer customer = customerRepository.findCustomerById(intensity.getOwnerId());
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

    void exportMultiSurveyAll(String earthquakeId, HttpServletResponse res) {
        String dir = fileDir + File.separator + earthquakeId;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return;
            }
        }
        Earthquake earthquake = earthquakeRepository.findEarthquakeById(earthquakeId);
        String sheetName = "multisurvey";
        String fileName = "multisurvey" + DateTime.now().getMillis() + ".xlsx";
        String[] rowNames = {"编号", "地震名称", "调查点名称", "调查点位置", "调查点经度",
                "调查点纬度", "调查时间", "建议烈度", "海拔高度", "结构类型", "破坏等级", "", "", "", "",
                "总面积/栋数", "震害指数", "调查人", "专业", "单位", "职称"};
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);
        List<Intensitysurvey> intensitysurveys = repository.findIntensitysurveysByEarthquakeIdAndStatus(earthquakeId, "working");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < intensitysurveys.size(); i++) {
            Intensitysurvey intensitysurvey = intensitysurveys.get(i);
            Multisurvey multiSurvey = multisurveyRepository.findMultisurveyBySurveyUuid(intensitysurvey.getUuid());
            if (multiSurvey != null) {
                List<PartSurvey> parts = multiSurvey.getPartSurveyList();
                for (PartSurvey part : parts) {
                    List<String> list = new ArrayList<>();
                    list.add((i + 1) + "");
                    list.add(earthquake.getName());
                    list.add(intensitysurvey.getName());
                    list.add(intensitysurvey.getAddress());
                    list.add(intensitysurvey.getLng());
                    list.add(intensitysurvey.getLat());
                    list.add(intensitysurvey.getDateTime());
                    list.add(intensitysurvey.getIntensity());
                    list.add(intensitysurvey.getAltitude());
                    list.add(part.getName());
                    list.add(part.getBasic());
                    list.add(part.getLittle());
                    list.add(part.getMiddle());
                    list.add(part.getSevere());
                    list.add(part.getDamage());
                    list.add(part.getArea());
                    list.add(part.getFactor());
                    Customer customer = customerRepository.findCustomerById(intensitysurvey.getOwnerId());
                    list.add(customer.getName());
                    list.add(customer.getDiscipline());
                    list.add(customer.getDepartment());
                    list.add(customer.getProfTitle());
                    lists.add(list);
                }
            }

        }
        ExcelUtils excelUtils = new ExcelUtils(rowNames, lists, file, sheetName);
        try {
            excelUtils.createCustomerMultiSurvey();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DownloadFileUtils downloadFileUtils = new DownloadFileUtils();
        downloadFileUtils.downloadFile(res, fileName, file);


    }

    void exportIntensitySurveyByGroup(HttpServletResponse res, String earthquakeId) {
        String dir = fileDir + File.separator + earthquakeId;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return;
            }
        }
        Earthquake earthquake = earthquakeRepository.findEarthquakeById(earthquakeId);
        String sheetName = "intensity";
        String fileName = "intensity" + DateTime.now().getMillis() + ".xlsx";
        String[] rowNames = {"编号", "地震名称", "调查点名称", "调查点位置", "调查点经度",
                "调查点纬度", "调查时间", "建议烈度", "海拔高度", "调查点户数", "均户面积",
                "总人口数", "死亡人数", "失踪人数", "重伤人数", "轻伤人数", "调查人",
                "专业", "单位", "职称"};
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);

        List<Group> groups = groupRepository.findGroupsByEarthquakeIdAndIsLeader(earthquakeId, "是");

        Map<String, Object> map = new HashMap<>();
        groups.forEach(group -> map.put(group.getCustomerId(), new Object()));

        List<Intensitysurvey> intensitysurveys = repository.findIntensitysurveysByEarthquakeIdAndStatus(earthquakeId, "working");

        int count = 1;
        List<List<String>> lists = new ArrayList<>();
        for (Intensitysurvey intensity : intensitysurveys) {
            String customerId = intensity.getOwnerId();
            if (!map.containsKey(customerId))
                continue;
            List<String> li = new ArrayList<>();
            li.add((count++) + "");
            li.add(earthquake.getName());
            li.add(intensity.getName());
            li.add(intensity.getAddress());
            li.add(intensity.getLng());
            li.add(intensity.getLat());
            li.add(intensity.getDateTime());
            li.add(intensity.getIntensity());
            li.add(intensity.getAltitude());
            li.add(intensity.getHouseNumber());
            li.add(intensity.getAvgArea());
            li.add(intensity.getTotalPeople());
            li.add(intensity.getDeath());
            li.add(intensity.getMiss());
            li.add(intensity.getSevereWound());
            li.add(intensity.getSlightWound());
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

    void exportMultiSurveyByGroup(String earthquakeId, HttpServletResponse res) {
        String dir = fileDir + File.separator + earthquakeId;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return;
            }
        }
        Earthquake earthquake = earthquakeRepository.findEarthquakeById(earthquakeId);
        String sheetName = "multisurvey";
        String fileName = "multisurvey" + DateTime.now().getMillis() + ".xlsx";
        String[] rowNames = {"编号", "地震名称", "调查点名称", "调查点位置", "调查点经度",
                "调查点纬度", "调查时间", "建议烈度", "海拔高度", "结构类型", "破坏等级", "", "", "", "",
                "总面积/栋数", "震害指数", "调查人", "专业", "单位", "职称"};
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);
        List<Group> groups = groupRepository.findGroupsByEarthquakeIdAndIsLeader(earthquakeId, "是");
        Map<String, Object> map = new HashMap<>();
        groups.forEach(group -> map.put(group.getCustomerId(), new Object()));

        List<Intensitysurvey> intensitysurveys = repository.findIntensitysurveysByEarthquakeIdAndStatus(earthquakeId, "working");
        List<List<String>> lists = new ArrayList<>();
        int count = 1;
        for (Intensitysurvey intensitysurvey : intensitysurveys) {
            if (!map.containsKey(intensitysurvey.getOwnerId()))
                continue;
            Multisurvey multiSurvey = multisurveyRepository.findMultisurveyBySurveyUuid(intensitysurvey.getUuid());
            if (multiSurvey != null) {
                List<PartSurvey> parts = multiSurvey.getPartSurveyList();
                for (PartSurvey part : parts) {
                    List<String> list = new ArrayList<>();
                    list.add((count++) + "");
                    list.add(earthquake.getName());
                    list.add(intensitysurvey.getName());
                    list.add(intensitysurvey.getAddress());
                    list.add(intensitysurvey.getLng());
                    list.add(intensitysurvey.getLat());
                    list.add(intensitysurvey.getDateTime());
                    list.add(intensitysurvey.getIntensity());
                    list.add(intensitysurvey.getAltitude());
                    list.add(part.getName());
                    list.add(part.getBasic());
                    list.add(part.getLittle());
                    list.add(part.getMiddle());
                    list.add(part.getSevere());
                    list.add(part.getDamage());
                    list.add(part.getArea());
                    list.add(part.getFactor());
                    Customer customer = customerRepository.findCustomerById(intensitysurvey.getOwnerId());
                    list.add(customer.getName());
                    list.add(customer.getDiscipline());
                    list.add(customer.getDepartment());
                    list.add(customer.getProfTitle());
                    lists.add(list);
                }
            }

        }
        ExcelUtils excelUtils = new ExcelUtils(rowNames, lists, file, sheetName);
        try {
            excelUtils.createCustomerMultiSurvey();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DownloadFileUtils downloadFileUtils = new DownloadFileUtils();
        downloadFileUtils.downloadFile(res, fileName, file);

    }


    void exportCustomerByEid(String eid, String cid, HttpServletResponse res) {
        String dir = fileDir + File.separator + eid;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return;
            }
        }
        Customer customer = customerRepository.findCustomerById(cid);
        Earthquake earthquake = earthquakeRepository.findEarthquakeById(eid);
        String sheetName = "intensity";
        String fileName = "intensity" + DateTime.now().getMillis() + ".xlsx";
        String[] rowNames = {"编号", "地震名称", "调查点名称", "调查点位置", "调查点经度",
                "调查点纬度", "调查时间", "建议烈度", "海拔高度", "调查点户数", "均户面积",
                "总人口数", "死亡人数", "失踪人数", "重伤人数", "轻伤人数", "调查人",
                "专业", "单位", "职称"};
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);
        List<Intensitysurvey> intensitySurveys = repository.findIntensitysurveysByEarthquakeIdAndOwnerIdAndStatus(eid, cid, "working");
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < intensitySurveys.size(); i++) {
            List<String> li = new ArrayList<>();
            Intensitysurvey intensity = intensitySurveys.get(i);
            li.add((i + 1) + "");
            li.add(earthquake.getName());
            li.add(intensity.getName());
            li.add(intensity.getAddress());
            li.add(intensity.getLng());
            li.add(intensity.getLat());
            li.add(intensity.getDateTime());
            li.add(intensity.getIntensity());
            li.add(intensity.getAltitude());
            li.add(intensity.getHouseNumber());
            li.add(intensity.getAvgArea());
            li.add(intensity.getTotalPeople());
            li.add(intensity.getDeath());
            li.add(intensity.getMiss());
            li.add(intensity.getSevereWound());
            li.add(intensity.getSlightWound());
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

    public void exportCustomerMultiSurveyByEid(String eid, String cid, HttpServletResponse res) {
        String dir = fileDir + File.separator + cid;
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return;
            }
        }
        Earthquake earthquake = earthquakeRepository.findEarthquakeById(eid);
        String sheetName = "multisurvey";
        String fileName = "multisurvey" + DateTime.now().getMillis() + ".xlsx";
        String[] rowNames = {"编号", "地震名称", "调查点名称", "调查点位置", "调查点经度",
                "调查点纬度", "调查时间", "建议烈度", "海拔高度", "结构类型", "破坏等级", "", "", "", "",
                "总面积/栋数", "震害指数", "调查人", "专业", "单位", "职称"};
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);
        List<Intensitysurvey> intensitysurveys = repository.findIntensitysurveysByEarthquakeIdAndOwnerIdAndStatus(eid, cid, "working");
        List<List<String>> lists = new ArrayList<>();
        Customer customer = customerRepository.findCustomerById(cid);
        for (int i = 0; i < intensitysurveys.size(); i++) {
            Intensitysurvey intensitysurvey = intensitysurveys.get(i);
            Multisurvey multiSurvey = multisurveyRepository.findMultisurveyBySurveyUuid(intensitysurvey.getUuid());
            if (multiSurvey != null) {
                List<PartSurvey> parts = multiSurvey.getPartSurveyList();
                for (PartSurvey part : parts) {
                    List<String> list = new ArrayList<>();
                    list.add((i + 1) + "");
                    list.add(earthquake.getName());
                    list.add(intensitysurvey.getName());
                    list.add(intensitysurvey.getAddress());
                    list.add(intensitysurvey.getLng());
                    list.add(intensitysurvey.getLat());
                    list.add(intensitysurvey.getDateTime());
                    list.add(intensitysurvey.getIntensity());
                    list.add(intensitysurvey.getAltitude());
                    list.add(part.getName());
                    list.add(part.getBasic());
                    list.add(part.getLittle());
                    list.add(part.getMiddle());
                    list.add(part.getSevere());
                    list.add(part.getDamage());
                    list.add(part.getArea());
                    list.add(part.getFactor());
                    list.add(customer.getName());
                    list.add(customer.getDiscipline());
                    list.add(customer.getDepartment());
                    list.add(customer.getProfTitle());
                    lists.add(list);
                }
            }

        }
        ExcelUtils excelUtils = new ExcelUtils(rowNames, lists, file, sheetName);
        try {
            excelUtils.createCustomerMultiSurvey();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DownloadFileUtils downloadFileUtils = new DownloadFileUtils();
        downloadFileUtils.downloadFile(res, fileName, file);


    }
}
