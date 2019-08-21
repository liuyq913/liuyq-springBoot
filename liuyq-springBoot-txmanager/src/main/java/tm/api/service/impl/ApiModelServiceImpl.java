package tm.api.service.impl;


import org.springframework.stereotype.Service;
import tm.api.service.ApiModelService;
import tm.manager.ModelInfoManager;
import tm.model.ModelInfo;

import java.util.List;

/**
 * create by lorne on 2017/11/13
 */
@Service
public class ApiModelServiceImpl implements ApiModelService {


    @Override
    public List<ModelInfo> onlines() {
        return ModelInfoManager.getInstance().getOnlines();
    }


}
