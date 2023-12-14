package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.documents.ExceptionDocument;
import ir.bootcamp.java.banksystem.sftp.repositories.ExceptionDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionDocumentServiceImpl implements ExceptionDocumentService {

    private final ExceptionDocumentRepository exceptionDocumentRepository;

    @Autowired
    public ExceptionDocumentServiceImpl(ExceptionDocumentRepository exceptionDocumentRepository) {
        this.exceptionDocumentRepository = exceptionDocumentRepository;
    }

    @Override
    public void saveException(ExceptionDocument exceptionDocument) {
        exceptionDocumentRepository.save(exceptionDocument);
    }
}
