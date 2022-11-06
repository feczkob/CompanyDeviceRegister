package com.fecbo.companydeviceregister.application.configuration;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

public class CustomModelMapper extends ModelMapper {

    @Override
    public <D> D map(Object source, Class<D> destinationType){
        if(source == null){
            return null;
        }
        return super.map(source, destinationType);
    }

    @Override
    public <D> D map(Object source, Type destinationType){
        if(source == null){
            return null;
        }
        return super.map(source, destinationType);
    }
}
