package com.iem.safety.iembackend.expectenvir;

import com.iem.safety.iembackend.safetyassess.SafetyassessService;
import com.iem.safety.iembackend.utils.Message;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-06-20 15:25
 */
@Service
public class ExpectEnvirService {

    private static String[] changdi = {"无影响", "场地失稳", "滑坡", "塌岸", "液化", "土体崩塌", "水患"};
    private static String[] diji = {"无影响", "持力土层不稳", "地基滑移", "不均匀沉降", "承载力下降"};
    private static String[] pilin = {"无影响", "毗邻建筑震损危及被鉴定建筑物"};
    private final SafetyassessService safetyassessService;
    private final ExpectEnvirRepository repository;

    public ExpectEnvirService(SafetyassessService safetyassessService, ExpectEnvirRepository repository) {
        this.safetyassessService = safetyassessService;
        this.repository = repository;
    }

    public Message getByAssessId(String assessId) {
        Message message = new Message();
        ExpectEnvir expectEnvir = repository.findExpectEnvirByAssessId(assessId);
        if (expectEnvir == null) {
            expectEnvir = new ExpectEnvir();
            expectEnvir.setAbOther("");
            expectEnvir.setAssessId(assessId);
            expectEnvir.setId(new ObjectId().toString());
            expectEnvir.setFcOther("");
            expectEnvir.setLiOther("");
            expectEnvir.setEffectType("SMALL");
            expectEnvir.setYetIntensity("VI");
            expectEnvir.setExpectEffect("≤V");
            List<Part> lis = new ArrayList<>();
            for (String s : changdi) {
                lis.add(new Part(s, false));
            }
            expectEnvir.setLocationInfluence(lis);

            List<Part> fc = new ArrayList<>();
            for (String s : diji) {
                fc.add(new Part(s, false));
            }
            expectEnvir.setFoundationCondition(fc);

            List<Part> ab = new ArrayList<>();
            for (String s : pilin) {
                ab.add(new Part(s, false));
            }
            expectEnvir.setAdjoiningBuilding(ab);
        }
        message.setCode(1);
        Map<String, Object> map = new HashMap<>();
        map.put("expectEnvir", expectEnvir);
        message.setResult(map);
        return message;
    }
}
