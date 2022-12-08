package com.fecbo.companydeviceregister.controller;

import com.fecbo.companydeviceregister.application.exception.MissingEntityException;
import com.fecbo.companydeviceregister.application.exception.RestApiError;
import com.fecbo.companydeviceregister.business.WorkerManager;
import com.fecbo.companydeviceregister.controller.model.request.WorkerRequest;
import com.fecbo.companydeviceregister.controller.model.response.WorkerResponse;
import com.fecbo.companydeviceregister.controller.util.PdfGenerator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerManager manager;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = WorkerResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class))})
    })
    @Secured("ROLE_ADMIN")
    @Operation
    @PostMapping
    public WorkerResponse addWorker(@RequestBody WorkerRequest workerRequest) throws MissingEntityException {
        return manager.addWorker(workerRequest);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = WorkerResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class))})
    })
    @Operation
    @GetMapping("/{id}")
    public WorkerResponse getWorkerById(@PathVariable("id") Integer id) throws MissingEntityException {
        return manager.getWorkerById(id);
    }

    @Secured("ROLE_ADMIN")
    @Operation
    @GetMapping(value = "/downloadWorker/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void downloadWorker(@PathVariable("id") Integer id, HttpServletResponse response) throws MissingEntityException, IOException {
        // * check https://www.techgeeknext.com/exportpdfs

        WorkerResponse worker = manager.getWorkerById(id);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + generateFileName(worker.getWorkerId()));
        PdfGenerator.workerReport(response, worker);
    }

    private String generateFileName(Integer id) {
        return "worker_" + id.toString() + ".pdf";
    }

    @Operation
    @GetMapping("/getAll")
    public List<WorkerResponse> getAllWorkersSorted(
            @RequestParam(value = "property", defaultValue = "name") String property,
            @Parameter(description = "Starts with value of 0.")
            @RequestParam(value = "numOfPage", defaultValue = "0") Integer numOfPage,
            @RequestParam(value = "numOfElements", defaultValue = "5") Integer numOfElements,
            @RequestParam(value = "isAscending", defaultValue = "true") Boolean isAscending
    ) throws NoSuchFieldException {
        return manager.getAllSorted(property, numOfPage, numOfElements, isAscending);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = WorkerResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class))})
    })
    @Operation
    @PutMapping("/{id}")
    public WorkerResponse modifyWorker(@PathVariable("id") Integer id,
                                       @RequestBody WorkerRequest workerRequest) throws MissingEntityException {
        return manager.modifyWorker(id, workerRequest);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestApiError.class))})
    })
    @Operation
    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable("id") Integer id) throws MissingEntityException {
        manager.deleteWorker(id);
    }
}
