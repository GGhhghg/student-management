package com.dev.student_management.controller;

import com.dev.student_management.dto.*;
import com.dev.student_management.service.BatchService;
import com.dev.student_management.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping( "/api/v1/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @Operation(summary = "Aduga grupa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping(path = "/save")
    public String saveBatch(@RequestBody BatchSaveDTO batchSaveDTO){
        String batchName = batchService.addBatch(batchSaveDTO);
        return batchName;
    }

    @Operation(summary = "Retrage grupa din bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @GetMapping("/getAllBatches")
    public List<BatchDTO> getAllBatches(){
        List<BatchDTO> allBatches = batchService.getAllBatches();
        return allBatches;
    }

    @Operation(summary = "Editeaza grupa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @PostMapping("/update")
    public String updateBatch(@RequestBody BatchUpdateDTO batchUpdateDTO){
        String batchName = batchService.updateBatch(batchUpdateDTO);
        return "Batch Updated Successfully";
    }

    @Operation(summary = "Sterge grupa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operatie efectuata cu success")
    })
    @DeleteMapping(path = "/delete/{id}")
    public String deleteBatch(@PathVariable(value="id")int id){
        boolean delete = batchService.deleteCourse(id);
        return "Batch Deleted Successfully";
    }
}
