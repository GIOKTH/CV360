package com.ldblao.cv360.services;

import com.ldblao.cv360.messages.request.IndicatorRequest;

import java.util.HashMap;

public interface IndicatorService {
    HashMap<String, Object> AllIndicator() throws Exception;

    HashMap<String, Object> GetIndicatorById(Long id) throws Exception;

    HashMap<String, Object> NewIndicator(IndicatorRequest indicatorRequest) throws Exception;

    HashMap<String, Object> UpdateIndicator(Long id, IndicatorRequest indicatorRequest) throws Exception;

    HashMap<String, Object> DeleteIndicator(Long id) throws Exception;
}
