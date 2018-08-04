package com.iem.safety.iembackend.web;

import com.iem.safety.iembackend.account.Account;
import com.iem.safety.iembackend.customer.CustomerRepository;
import com.iem.safety.iembackend.earthquake.Earthquake;
import com.iem.safety.iembackend.earthquake.EarthquakeRepository;
import com.iem.safety.iembackend.fileEntity.FileEntityRepository;
import com.iem.safety.iembackend.structuretype.StructureTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi 2018-06-15 20:38
 */
@Service
public class WebService {
    private final CustomerRepository customerRepository;
    private final EarthquakeRepository earthquakeRepository;
    private final StructureTypeRepository structureTypeRepository;
    private final FileEntityRepository fileEntityRepository;
    public WebService(CustomerRepository customerRepository, EarthquakeRepository earthquakeRepository, StructureTypeRepository structureTypeRepository, FileEntityRepository fileEntityRepository) {
        this.customerRepository = customerRepository;
        this.earthquakeRepository = earthquakeRepository;
        this.structureTypeRepository = structureTypeRepository;
        this.fileEntityRepository = fileEntityRepository;
    }

    public String customerManagePage(String id, Model model, HttpServletRequest request) {
        String role = (String) request.getSession().getAttribute("_role");
        switch (role) {
            case "su":
            case "admin":
                model.addAttribute("customer", customerRepository.findCustomerById(id));
                return "customermanagepage";
            case "normal":
                Account account = (Account) request.getSession().getAttribute("_session_user");
                if (account.getCustomerId().equals(id)) {
                    model.addAttribute("customer", customerRepository.findCustomerById(id));
                    return "customermanagepage";
                } else return "404";
            default:
                return "404";
        }
    }

    public String customerData(String eid, String cid, Model model) {
        Earthquake eq = earthquakeRepository.findEarthquakeById(eid);
        model.addAttribute("eq", eq);
        model.addAttribute("customer", customerRepository.findCustomerById(cid));
        return "customerdatapage";
    }

    public String adminManage(String eid, Model model) {
        model.addAttribute("eq", earthquakeRepository.findEarthquakeById(eid));
        return "normaladminmanagepage";
    }

    public String suStructureParts(String tid, Model model) {
        model.addAttribute("sType", structureTypeRepository.findStructureTypeById(tid));
        return "superstructpartspage";
    }

//    public String adminMedia(String eqId, String userId, Model model) {
//
//        model.addAttribute("files",fileEntityRepository.findFileEntitiesByEqId(eqId));
//
//        return "normalmediapage";
//    }
}
