package com.ldblao.cv360.controller;

import com.ldblao.cv360.messages.request.IndicatorRequest;
import com.ldblao.cv360.services.implement.IndicatorServiceImpl;
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
public class IndicatorController {
    private final IndicatorServiceImpl indicatorService;

    public IndicatorController(IndicatorServiceImpl indicatorService) {
        this.indicatorService = indicatorService;
    }

    @RequestMapping(
            value = Cv360Path.INDICATOR_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    @ResponseBody
    public ResponseEntity<?> getAllIndicator() throws Exception {
        return new ResponseEntity<>(this.indicatorService.AllIndicator(), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.INDICATOR_VALUE_BY_ID_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> getIndicatorById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.indicatorService.GetIndicatorById(id), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.INDICATOR_PATH,
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> createNewIndicator(@Valid @RequestBody IndicatorRequest indicatorRequest) throws Exception {
        return new ResponseEntity<>(this.indicatorService.NewIndicator(indicatorRequest), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.INDICATOR_VALUE_BY_ID_PATH,
            method = RequestMethod.PUT,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> updateIndicator(@PathVariable("id") Long id, @Valid @RequestBody IndicatorRequest indicatorRequest) throws Exception {
        return new ResponseEntity<>(this.indicatorService.UpdateIndicator(id, indicatorRequest), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.INDICATOR_VALUE_BY_ID_PATH,
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> deleteIndicator(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.indicatorService.DeleteIndicator(id), HttpStatus.OK);
    }
}
