package com.hospital_vm.cl.hopital_vm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hopital_vm.Model.Atencion;

@RestController
@RequestMapping("/api/v1/atencion")
public class AtencionController {

    @Autowired
    private Atencion AtencionService;

}
