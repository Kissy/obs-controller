package fr.kissy.tools.obscontroller.model.response;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Guillaume on 04/12/2016.
 */
class ObsResponseTypeIdResolver implements TypeIdResolver {
    private static final String BASE_PACKAGE = ObsResponse.class.getPackage().getName();
    private JavaType javaType;

    @Override
    public void init(JavaType javaType) {
        this.javaType = javaType;
    }

    @Override
    public String idFromValue(Object o) {
        return idFromValueAndType(o, o.getClass());
    }

    @Override
    public String idFromValueAndType(Object o, Class<?> aClass) {
        return aClass.getSimpleName() + "-" + new Date().getTime();
    }

    @Override
    public String idFromBaseType() {
        return idFromValueAndType(null, javaType.getRawClass());
    }

    @Override
    public JavaType typeFromId(DatabindContext databindContext, String s) throws IOException {
        try {
            String className = s.split("-")[0];
            Class<?> responseClass = TypeFactory.defaultInstance().findClass(BASE_PACKAGE + "." + className);
            return TypeFactory.defaultInstance().constructSpecializedType(javaType, responseClass);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Error while finding class");
        }
    }

    @Override
    public String getDescForKnownTypeIds() {
        return null;
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}
