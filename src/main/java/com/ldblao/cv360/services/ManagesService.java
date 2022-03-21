package com.ldblao.cv360.services;

import com.ldblao.cv360.messages.request.ManagesRequest;
import com.ldblao.cv360.messages.request.MultiManage;

import java.util.HashMap;
import java.util.List;

public interface ManagesService {
    HashMap<String, Object> AllManages() throws Exception;

    HashMap<String, Object> CreateNewManages(ManagesRequest managesRequest) throws Exception;

    HashMap<String, Object> CreateNewManagesV2(MultiManage multiManage) throws Exception;

    HashMap<String, Object> ByIdManages(Long id) throws Exception;

    HashMap<String, Object> UpdateManages(Long id, ManagesRequest managesRequest) throws Exception;

    HashMap<String, Object> DeleteManages(Long id) throws Exception;

    HashMap<String, Object> ByEvalByStatusManages(String eval, String status) throws Exception;
}
