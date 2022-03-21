package com.ldblao.cv360.controller;

import com.ldblao.cv360.messages.request.ManagesRequest;
import com.ldblao.cv360.messages.request.MultiManage;
import com.ldblao.cv360.services.implement.ManagesServiceImpl;
import com.ldblao.cv360.utils.Cv360Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(
        value = Cv360Path.ROTT_PATH + Cv360Path.VERSION_PATH
)
public class ManagesController {
    private final ManagesServiceImpl managesService;

    public ManagesController(ManagesServiceImpl managesService) {
        this.managesService = managesService;
    }

    @RequestMapping(
            value = Cv360Path.MANAGES_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> getAllmanages() throws Exception {
        return new ResponseEntity<>(this.managesService.AllManages(), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.MANAGES_PATH,
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> ManagesCreateNew(@Valid @RequestBody ManagesRequest managesRequest) throws Exception {
        return new ResponseEntity<>(this.managesService.CreateNewManages(managesRequest), HttpStatus.OK);
    }


    @RequestMapping(
            value = Cv360Path.MANAGES_MULTI_PATH,
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> ManagesCreateV2(@Valid @RequestBody MultiManage multiManage) throws Exception {
        return new ResponseEntity<>(this.managesService.CreateNewManagesV2(multiManage), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.MANAGES_GET_DATA_BY_ID_PATH,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> getManagesById(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.managesService.ByIdManages(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.MANAGES_GET_DATA_BY_EVAL_AND_STATUS,
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> getManagesByEvalByStatus(@PathVariable("eval") String eval,
                                              @PathVariable("status") String status) throws Exception {
        return new ResponseEntity<>(this.managesService.ByEvalByStatusManages(eval, status), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.MANAGES_GET_DATA_BY_ID_PATH,
            method = RequestMethod.PUT,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> ManagesUpdate(@PathVariable("id") Long id, @RequestBody ManagesRequest managesRequest) throws Exception {
        return new ResponseEntity<>(this.managesService.UpdateManages(id, managesRequest), HttpStatus.OK);
    }

    @RequestMapping(
            value = Cv360Path.MANAGES_GET_DATA_BY_ID_PATH,
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<?> ManagesDelete(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.managesService.DeleteManages(id), HttpStatus.OK);
    }
}
