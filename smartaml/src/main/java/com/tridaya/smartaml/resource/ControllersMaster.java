package com.tridaya.smartaml.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tridaya.smartaml.mapper.SmartAmlMasterMappers;
import com.tridaya.smartaml.utils.Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class ControllersMaster extends Utils{

    private SmartAmlMasterMappers smartAmlMasterMappers;

    public ControllersMaster(SmartAmlMasterMappers smartAmlMasterMappers) {
        this.smartAmlMasterMappers = smartAmlMasterMappers;
    }
    // GET Master Pekerjaan
    @GetMapping("/getmasterpekerjaan")
    public List<HashMap<String, Object>> getMasterPekerjaan(@RequestBody Map<String,Object> obj) throws Exception {
        
        List<String> paramList = listArray(obj);
        List<HashMap<String, Object>> getMasterPekerjaan= null;
        try {
            String store_procedure = "{CALL GET_MASTER_PEKERJAAN("+paramList
                    .toString()
                    .replace("[","")
                    .replace("]","")+")}";
            System.out.println("store_procedure :" +store_procedure);
            getMasterPekerjaan = smartAmlMasterMappers.exec(store_procedure);
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return getMasterPekerjaan;
    }
    //POST AND UPDATE Master Pekerjaan
    @PostMapping("/savemasterpekerjaan")
    public String saveMasterPekerjaan(@RequestBody Map<String,Object> obj){
        
        String res = "";
        try{
            List<String> paramList = listArray(obj);
            String store_procedure = "{CALL SET_MASTER_PEKERJAAN("+paramList
                    .toString()
                    .replace("[","")
                    .replace("]","")+")}";
            System.out.println("store_procedure :" +store_procedure);
            List<HashMap<String, Object>> jsave = smartAmlMasterMappers.exec(store_procedure);
            res = jsave.get(0).toString();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
