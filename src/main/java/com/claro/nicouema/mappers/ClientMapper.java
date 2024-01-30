package com.claro.nicouema.mappers;

import com.claro.nicouema.model.Client;
import com.claro.nicouema.requests.CreateClientRequest;
import com.claro.nicouema.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface ClientMapper {

    @Mapping(target = "user", ignore = true)
    Client createClientRequestToClient(CreateClientRequest request);

    @Mapping(target = "age", source = "client", qualifiedByName = "ageCalculator")
    ClientResponse clientToClientResponse(Client client);

    @Named("ageCalculator")
    default Integer ageCalculator(Client client){
        return client.calculateAge();
    }
}
