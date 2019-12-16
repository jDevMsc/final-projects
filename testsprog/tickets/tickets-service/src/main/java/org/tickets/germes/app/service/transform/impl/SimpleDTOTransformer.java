package org.tickets.germes.app.service.transform.impl;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tickets.germes.app.model.entity.base.AbstractEntity;
import org.tickets.germes.app.rest.dto.base.BaseDTO;
import org.tickets.germes.app.service.transform.Transformer;
import org.tickets.germes.app.util.Checks;
import org.tickets.germes.app.util.ReflectionUtil;

/**
 *  Uses reflection to transform objects
 */
public class SimpleDTOTransformer implements Transformer {
	private static final Logger LOGGER = LoggerFactory
		.getLogger(SimpleDTOTransformer.class);

	@Override
	public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(
		final T entity, final Class<P> clz) {
		checkParams(entity, clz);

		P dto = ReflectionUtil.createInstance(clz);
		// Now just copy all the similar fields
		ReflectionUtil.copyFields(entity, dto,
			ReflectionUtil.findSimilarFields(entity.getClass(), clz));
		dto.transform(entity);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("SimpleDTOTransformer.transform: {} DTO object",
				ReflectionToStringBuilder.toString(dto,
					ToStringStyle.SHORT_PREFIX_STYLE));
		}

		return dto;
	}

	private void checkParams(final Object param, final Class<?> clz) {
		Checks.checkParameter(param != null,
			"Source transformation object is not initialized");
		Checks.checkParameter(clz != null,
			"No class is defined for transformation");
	}

	@Override
	public <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(
		final P dto, final Class<T> clz) {
		checkParams(dto, clz);

		T entity = ReflectionUtil.createInstance(clz);

		ReflectionUtil.copyFields(dto, entity,
			ReflectionUtil.findSimilarFields(dto.getClass(), clz));
		dto.untransform(entity);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("SimpleDTOTransformer.transform: {} entity",
				ReflectionToStringBuilder.toString(entity,
					ToStringStyle.SHORT_PREFIX_STYLE));
		}

		return entity;
	}
}
