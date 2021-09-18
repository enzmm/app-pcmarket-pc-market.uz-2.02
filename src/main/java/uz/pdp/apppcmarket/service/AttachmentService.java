package uz.pdp.apppcmarket.service;


import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.entity.AttachmentContent;
import uz.pdp.apppcmarket.payload.AttachmentDto;
import uz.pdp.apppcmarket.payload.Result;
import uz.pdp.apppcmarket.repository.AttachmentContentRepository;
import uz.pdp.apppcmarket.repository.AttachmentRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @SneakyThrows
    public Result uploadFile(MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        //attachmentni saqlash
        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);

        //contentni saqlash
        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepository.save(attachmentContent);
        return new Result("Fayl saqlandi", true, savedAttachment.getId());
    }

    @DeleteMapping(value = "/api/attachmentId/{attachmentId}")
    public Result deleteAttachment(@PathVariable Integer attachmentId){
        attachmentRepository.deleteById(attachmentId);
        return null;
    }

    //UPDATE
    @PutMapping(value = "/api/attachment/{id}")
    public Result editAttachment(@PathVariable Integer id, @RequestBody AttachmentDto attachmentDto) {
        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findById(id);
        if (optionalAttachmentContent.isPresent()) {
            AttachmentContent attachmentContent = optionalAttachmentContent.get();
            attachmentContent.setBytes(attachmentDto.getBytes());

            Attachment attachment = attachmentContent.getAttachment();
            attachment.setName(attachmentDto.getName());
            attachment.setSize(attachmentDto.getSize());
            attachment.setContentType(attachmentDto.getContentType());
            attachmentRepository.save(attachment);

            attachmentContentRepository.save(attachmentContent);
            return new Result();
        }
        return null;
    }

    @GetMapping
    public List<Attachment> getAttachments()
    {
        return  attachmentRepository.findAll();
    }

}