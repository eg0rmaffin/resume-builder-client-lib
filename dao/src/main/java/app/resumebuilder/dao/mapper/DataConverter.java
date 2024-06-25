package app.resumebuilder.dao.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Конвертер между Model и DTO классами
 */

@Component
public class DataConverter {
    private final ModelMapper modelMapper;

    public DataConverter() {
        this.modelMapper = new ModelMapper();
    }

    public <T, U> U convertToDTO(T model, Class<U> modelDTO) {
        return modelMapper.map(model, modelDTO);
    }

    public <T, U> T convertToModel(U modelDTO, Class<T> model) {
        return modelMapper.map(modelDTO, model);
    }
}
