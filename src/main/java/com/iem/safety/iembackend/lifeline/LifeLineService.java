package com.iem.safety.iembackend.lifeline;

import com.iem.safety.iembackend.expectenvir.Part;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class LifeLineService {

    //主要结构形式 可选项
    private static String[] msfArray = {"给（排）水系统", "燃气系统", "输油系统", "交通系统", "电力系统", "广播通信系统", "热力系统", "水利工程", "生命线工程设备", "其它"};

    private final LifeLineRepository repository;

    public LifeLineService(LifeLineRepository repository) {
        this.repository = repository;
    }

    public List<LifeLine> findByOwnerIdAndEarthquakeId(String ownerId, String earthquakeId) {
        List<LifeLine> lifeLineList = repository.findByOwnerIdAndEarthquakeId(ownerId, earthquakeId);
        return lifeLineList;
    }

    //获取多选模版
    public List<Part>  getMsfDome(){
        List<Part> msfList = new ArrayList<>();
        for (String s : msfArray) {
            msfList.add(new Part(s, false));
        }
        return msfList;
    }
}
