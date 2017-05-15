package com.newberry.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.newberry.util.Consts;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:gbreddys@gmail.com.com">Bala Reddy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
@Component
public class LocalDateSerializer
	extends JsonSerializer<LocalDate>
{

	/**
	 * {@inheritDoc}
	 *
	 * @see JsonSerializer#serialize(Object,
	 *      JsonGenerator,
	 *      SerializerProvider)
	 */
	@Override
	public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider)
		throws IOException, JsonProcessingException
	{
		if(value != null) {
			jgen.writeString(Consts.DOB_FORMATTER.print(value));
		}
	}

}
