package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.payload.AttachmentDto;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.service.AttachmentService;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request){
        Result result = attachmentService.uploadFile(request);
        return result;
    }

    //Delete
    @DeleteMapping(value = "/api/attachment/{attachmentId}")
    public Result deleteAttachment(@PathVariable Integer attachmentId) {
        Result result = attachmentService.deleteAttachment(attachmentId);
        return result;
    }

    @PutMapping(value = "/api/attachment/{id}")
    public Result editAttachment(@PathVariable Integer attachmentId, @RequestBody AttachmentDto attachmentDto){
        Result result = attachmentService.editAttachment(attachmentId, attachmentDto);
        return result;
    }

    @GetMapping
    public List<Attachment> getAttachments() {
        List<Attachment> attachmentList = attachmentService.getAttachments();
        return attachmentList;
    }
}