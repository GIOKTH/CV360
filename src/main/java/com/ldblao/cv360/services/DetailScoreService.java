package com.ldblao.cv360.services;

import com.ldblao.cv360.messages.request.DetailsRequest;

import java.util.HashMap;

public interface DetailScoreService {
    HashMap<String, Object> AllDetails() throws Exception;

    HashMap<String, Object> GetDetailById(Long id) throws Exception;

    HashMap<String, Object> NewDetail(DetailsRequest detailsRequest) throws Exception;

    HashMap<String, Object> UpdateDetail(Long id, DetailsRequest detailsRequest) throws Exception;

    HashMap<String, Object> DeleteDetail(Long id) throws Exception;
}
