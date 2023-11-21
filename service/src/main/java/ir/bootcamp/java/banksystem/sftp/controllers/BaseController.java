package ir.bootcamp.java.banksystem.sftp.controllers;

import ir.bootcamp.java.banksystem.sftp.controllers.response.BankResponse;
import ir.bootcamp.java.banksystem.sftp.converter.BaseConverter;
import ir.bootcamp.java.banksystem.models.documents.valid.GeneralValidationGroup;
import ir.bootcamp.java.banksystem.models.documents.valid.NotNullGroup;
import ir.bootcamp.java.banksystem.sftp.services.BaseService;
import ir.bootcamp.java.banksystem.sftp.util.ResourceBundleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


public abstract class BaseController<E, D, ID> {

    @Autowired
    private BaseService<E, ID> baseService;

    @Autowired
    private BaseConverter<E, D> baseConverter;

    @Autowired
    private ResourceBundleUtil resourceBundleUtil;

    @PostMapping("/save")
    @Transactional
    public BankResponse save(@RequestBody @Validated({NotNullGroup.class, GeneralValidationGroup.class}) D dto,
                             @RequestHeader("lang") String lang) {
        E entity = baseConverter.convertEntity(dto);
        E save = baseService.save(entity);
        D result = baseConverter.convertDto(save);

        return BankResponse.builder()
                .message(resourceBundleUtil.getMessage("operation.successful.run", lang))
                .code("operation.successful.run")
                .date(new Date())
                .hasError(false)
                .data(result)
                .build();
    }

    @GetMapping("/findById/{id}")
    @Transactional(readOnly = true)
    public BankResponse findById(@PathVariable @Validated(NotNullGroup.class) ID id,
                                 @RequestHeader("lang") String lang) {

        E byId = baseService.findById(id);
        D find = baseConverter.convertDto(byId);
        return BankResponse.builder()
                .message(resourceBundleUtil.getMessage("operation.successful.run", lang))
                .code("operation.successful.run")
                .date(new Date())
                .hasError(false)
                .data(find)
                .build();
    }

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public BankResponse findAll(@RequestHeader("lang") String lang) {
        List<E> all = baseService.findAll();
        List<D> find = baseConverter.converterDtoes(all);
        return BankResponse.builder()
                .message(resourceBundleUtil.getMessage("users.finded.successfull", lang))
                .code("users.finded.successfull")
                .date(new Date())
                .hasError(false)
                .data(find)
                .build();
    }

    @DeleteMapping("/delete")
    @Transactional
    public BankResponse deleteById(@RequestParam @Validated(NotNullGroup.class) ID id, @RequestHeader("lang") String lang) {
        baseService.deleteById(id);
        return BankResponse.builder()
                .message(resourceBundleUtil.getMessage("user.delete.successfull", lang))
                .code("user.delete.successfull")
                .date(new Date())
                .hasError(false)
                .data(true)
                .build();
    }

    @GetMapping()
    public BankResponse findByExample(@RequestBody @Validated D dto, @RequestHeader("lang") String lang) {
        E entity1 = baseConverter.convertEntity(dto);
        List<E> entities = baseService.findBySample(entity1);
        List<D> results = baseConverter.converterDtoes(entities);
        return BankResponse.builder()
                .message(resourceBundleUtil.getMessage("items.found.successfull", lang))
                .code("items.found.successfull")
                .date(new Date())
                .hasError(false)
                .data(results)
                .build();
    }

}
