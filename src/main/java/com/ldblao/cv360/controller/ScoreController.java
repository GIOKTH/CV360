package com.ldblao.cv360.controller;

import com.ldblao.cv360.messages.request.ScoreRequest;
import com.ldblao.cv360.services.implement.ScoreServiceImpl;
import com.ldblao.cv360.utils.Cv360Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        value = Cv360Path.ROTT_PATH + Cv360Path.VERSION_PATH
)
public class ScoreController {
    private final ScoreServiceImpl scoreService;

    public ScoreController(ScoreServiceImpl scoreService) {
        this.scoreService = scoreService;
    }

    @RequestMapping(
            value = Cv360Path.SCORE_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    @ResponseBody
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity<>(this.scoreService.AllScoreValues(), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.SCORE_BY_ID_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> getScoreById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.scoreService.GetScoreValueById(id), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.SCORE_PATH,
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> createNewScore(@Valid @RequestBody ScoreRequest scoreRequest) throws Exception {
        return new ResponseEntity<>(this.scoreService.NewScore(scoreRequest), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.SCORE_MULTI_CREATE_PATH,
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> createMultiNewScore(@Valid @RequestBody List<ScoreRequest> scoreRequests) throws Exception {
        return new ResponseEntity<>(this.scoreService.MultiNewScore(scoreRequests), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.SCORE_BY_ID_PATH,
            method = RequestMethod.PUT,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> updateCoreScore(@PathVariable("id") Long id, @Valid @RequestBody ScoreRequest scoreRequest) throws Exception {
        return new ResponseEntity<>(this.scoreService.UpdateScore(id, scoreRequest), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.SCORE_BY_ID_PATH,
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> deleteCoreScore(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.scoreService.DeleteScore(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.SCORE_PATH_JOIN,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> JoinData() throws Exception {
        return new ResponseEntity<>(this.scoreService.JoinScoreToManage(), HttpStatus.OK);
    }
}
