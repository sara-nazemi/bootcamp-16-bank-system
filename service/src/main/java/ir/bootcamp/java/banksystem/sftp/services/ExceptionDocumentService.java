package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.documents.ExceptionDocument;

public interface ExceptionDocumentService {
    void saveException(ExceptionDocument exceptionDocument);
}
