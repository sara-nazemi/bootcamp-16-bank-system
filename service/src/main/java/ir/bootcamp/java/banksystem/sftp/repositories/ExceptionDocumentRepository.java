package ir.bootcamp.java.banksystem.sftp.repositories;

import ir.bootcamp.java.banksystem.models.documents.documents.ExceptionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExceptionDocumentRepository extends MongoRepository<ExceptionDocument, String> {
}
