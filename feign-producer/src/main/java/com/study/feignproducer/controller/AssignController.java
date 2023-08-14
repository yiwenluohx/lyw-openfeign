package com.study.feignproducer.controller;

import com.study.feignbase.param.AssignParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luohx
 * @version 1.0.0
 * @date: 2023/8/14 下午2:14
 * @menu
 */
@RestController
@RequestMapping("/assign")
public class AssignController {

    @RequestMapping(value = "/assignOwner", method = RequestMethod.POST)
    public ResponseEntity<String> assignOwner(@Validated @RequestBody AssignParam param) {
        String newClueId = "XL00".concat(param.getClueId().toString());
        return new ResponseEntity<>(newClueId, HttpStatus.OK);
    }
}
