package com.ldblao.cv360.controller;

import com.ldblao.cv360.messages.request.SevenCoreScoreValueRequest;
import com.ldblao.cv360.services.implement.SevenCoreValuesServiceImpl;
import com.ldblao.cv360.utils.Cv360Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(
        value = Cv360Path.ROTT_PATH + Cv360Path.VERSION_PATH
)
public class SevenCoreScoresController {
    private final SevenCoreValuesServiceImpl sevenCoreValuesService;

    public SevenCoreScoresController(
            SevenCoreValuesServiceImpl sevenCoreValuesService) {
        this.sevenCoreValuesService = sevenCoreValuesService;
    }

    @RequestMapping(
            value = Cv360Path.SEVEN_CORE_SCORE_VALUE_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> getAllScoreValues() throws Exception {
        return new ResponseEntity<>(this.sevenCoreValuesService.AllCoreScoreValues(), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.SEVEN_CORE_SCORE_VALUE_BY_ID_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> getScoreValueById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.sevenCoreValuesService.GetCoreScoreValueById(id), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.SEVEN_CORE_SCORE_VALUE_PATH,
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> createNewScoreValue(@Valid @RequestBody SevenCoreScoreValueRequest sevenCoreScoreValueRequest) throws Exception {
        return new ResponseEntity<>(this.sevenCoreValuesService.NewCoreScore(sevenCoreScoreValueRequest), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.SEVEN_CORE_SCORE_VALUE_BY_ID_PATH,
            method = RequestMethod.PUT,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> updateCoreScoreValue(@PathVariable("id") Long id, @RequestBody SevenCoreScoreValueRequest sevenCoreScoreValueRequest) throws Exception {
        return new ResponseEntity<>(this.sevenCoreValuesService.UpdateCoreScore(id, sevenCoreScoreValueRequest), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.SEVEN_CORE_SCORE_VALUE_BY_ID_PATH,
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> deleteCoreScoreValue(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.sevenCoreValuesService.DeleteCoreScore(id), HttpStatus.OK);
    }
}
