package dev.herbidev.minievaluation.service;


import dev.herbidev.minievaluation.dao.CoursDao;
import dev.herbidev.minievaluation.dao.ICoursDao;
import dev.herbidev.minievaluation.dto.CoursDto;
import dev.herbidev.minievaluation.entities.CoursEntity;
import dev.herbidev.minievaluation.mapper.CoursMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CoursService implements ICoursService {
    private static final Logger logger = LoggerFactory.getLogger(CoursService.class);
    private ICoursDao coursDao = new CoursDao();

    @Override
    public Optional<List<CoursDto>> findAll() {
        List<CoursEntity> coursEntities = coursDao.list(new CoursEntity());
        List<CoursDto> coursDtos = CoursMapper.toListCoursDto(coursEntities);

        return Optional.of(coursDtos);
    }

    @Override
    public boolean save(CoursDto coursDto) {
        logger.info("CoursService - Tentative d'enregistrement d'un cours : {}", coursDto);
        CoursEntity productEntity = CoursMapper.toCoursEntity(coursDto);
        return coursDao.save(productEntity);
    }
}