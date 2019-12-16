package org.tickets.germes.app.service.transform;


import org.tickets.germes.app.model.entity.base.AbstractEntity;
import org.tickets.germes.app.rest.dto.base.BaseDTO;

/**
 * Convert business entities into DTO objects
 *
 */
public interface Transformer {

	/**
	 *  Entity into DTO object
	 */
	<T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clz);
	
	/**
	 *  DTO object into business entity
	 */
	<T extends AbstractEntity, P extends BaseDTO<T>> T untransform(P dto, Class<T> clz);

}
