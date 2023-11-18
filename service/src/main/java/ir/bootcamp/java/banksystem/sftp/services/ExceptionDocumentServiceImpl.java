package ir.bootcamp.java.banksystem.sftp.services;

import ir.bootcamp.java.banksystem.models.documents.documents.ExceptionDocument;
import ir.bootcamp.java.banksystem.sftp.repository.ExceptionDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionDocumentServiceImpl implements ExceptionDocumentService {

    @Autowired
    ExceptionDocumentRepository exceptionDocumentRepository;

    @Override
    public void saveException(ExceptionDocument exceptionDocument) {
        exceptionDocumentRepository.save(exceptionDocument);
    }
}
