package com.ldblao.cv360.services;

import com.ldblao.cv360.messages.request.ScoreRequest;

import java.util.HashMap;
import java.util.List;

public interface ScoreService {
    HashMap<String, Object> AllScoreValues() throws Exception;

    HashMap<String, Object> GetScoreValueById(Long id) throws Exception;

    HashMap<String, Object> NewScore(ScoreRequest scoreRequest) throws Exception;

    HashMap<String, Object> MultiNewScore(List<ScoreRequest> scoreRequests) throws Exception;

    HashMap<String, Object> UpdateScore(Long id, ScoreRequest scoreRequest) throws Exception;

    HashMap<String, Object> DeleteScore(Long id) throws Exception;

    HashMap<String, Object> JoinScoreToManage() throws Exception;
}
