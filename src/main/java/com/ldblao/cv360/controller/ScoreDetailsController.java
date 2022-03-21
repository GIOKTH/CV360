package com.ldblao.cv360.controller;

import com.ldblao.cv360.messages.request.DetailsRequest;
import com.ldblao.cv360.services.implement.DetailsScoreServiceImpl;
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
public class ScoreDetailsController {
    private final DetailsScoreServiceImpl detailsScoreService;

    public ScoreDetailsController(DetailsScoreServiceImpl detailsScoreService) {
        this.detailsScoreService = detailsScoreService;
    }

    @RequestMapping(
            value = Cv360Path.DETAILS_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    @ResponseBody
    public ResponseEntity<?> getAllDetails() throws Exception{
        return new ResponseEntity<>(this.detailsScoreService.AllDetails(), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.DETAILS_VALUE_BY_ID_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> getDetailsById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.detailsScoreService.GetDetailById(id), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.DETAILS_PATH,
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> createDetails(@Valid @RequestBody DetailsRequest detailsRequest) throws Exception {
        return new ResponseEntity<>(this.detailsScoreService.NewDetail(detailsRequest), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.DETAILS_VALUE_BY_ID_PATH,
            method = RequestMethod.PUT,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> updateDetails(@PathVariable("id") Long id, @Valid @RequestBody DetailsRequest detailsRequest) throws Exception {
        return new ResponseEntity<>(this.detailsScoreService.UpdateDetail(id, detailsRequest), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.DETAILS_VALUE_BY_ID_PATH,
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> deleteDetails(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.detailsScoreService.DeleteDetail(id), HttpStatus.OK);
    }
}
