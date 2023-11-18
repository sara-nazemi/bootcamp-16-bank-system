package ir.bootcamp.java.banksystem.sftp.converter;

import ir.bootcamp.java.banksystem.models.documents.documents.ExceptionDocument;
import ir.bootcamp.java.banksystem.models.documents.dto.ExceptionDocumentDto;

import java.util.List;

public interface ExceptionDocumentConverter {
    ExceptionDocument convertDocument(ExceptionDocumentDto dto);

    ExceptionDocumentDto convertDocumentDto(ExceptionDocument doc);

    List<ExceptionDocument> convertDocuments(List<ExceptionDocumentDto> dtos);

    List<ExceptionDocumentDto> convertDocumentDtos(List<ExceptionDocument> docs);

}
