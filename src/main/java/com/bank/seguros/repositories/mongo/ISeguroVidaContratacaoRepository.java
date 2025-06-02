package com.bank.seguros.repositories.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.seguros.repositories.entities.SeguroVidaContratacaoEntity;

@Repository
public interface ISeguroVidaContratacaoRepository extends MongoRepository<SeguroVidaContratacaoEntity, UUID> {

}
