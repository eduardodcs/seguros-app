package com.bank.seguros.repositories.mongo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.seguros.repositories.entities.SeguroVidaSimulacaoEntity;

@Repository
public interface ISeguroVidaSimulacaoRepository extends MongoRepository<SeguroVidaSimulacaoEntity, UUID> {

}
