package com.ldblao.cv360.services;

import com.ldblao.cv360.messages.request.SevenCoreScoreValueRequest;

import java.util.HashMap;

public interface SevencoreValueService {
    HashMap<String, Object> AllCoreScoreValues() throws Exception;

    HashMap<String, Object> GetCoreScoreValueById(Long id) throws Exception;

    HashMap<String, Object> NewCoreScore(SevenCoreScoreValueRequest sevenCoreScoreValueRequest) throws Exception;

    HashMap<String, Object> UpdateCoreScore(Long id, SevenCoreScoreValueRequest sevenCoreScoreValueRequest) throws Exception;

    HashMap<String, Object> DeleteCoreScore(Long id) throws Exception;
}
