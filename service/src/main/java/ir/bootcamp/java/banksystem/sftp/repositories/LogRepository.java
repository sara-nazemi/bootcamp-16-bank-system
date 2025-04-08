package ir.bootcamp.java.banksystem.sftp.repositories;

import ir.bootcamp.java.banksystem.models.documents.documents.LogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogDocument,String> {
}
