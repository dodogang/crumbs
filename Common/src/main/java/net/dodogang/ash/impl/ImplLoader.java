package net.dodogang.ash.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ImplLoader {
    /**
     * Instantiates a class with the given class name with the given args.
     *
     * <p>For example, a proper class name would be
     * "net.dodogang.ash.loader.impl.ModLoaderImpl"</p>
     *
     * <p>The caller must guarantee that a class exists with the supplied name,
     * supplied parameterTypes, and supplied arguments. If a class doesn't
     * exist that meets those requirements, the program will crash.</p>
     *
     * <p>Because of a lack of compile-time safety guarantee, this method should
     * only be used when the caller is absolutely sure the specified class and
     * constructor exists.</p>
     *
     * @param className the name of the class to be loaded
     * @param parameterTypes the exact parameter class types for the class's
     *                       constructor
     * @param args the exact arguments needed for the class's constructor
     * @return a new instance of the class
     * @param <T> the class
     */
    public static <T> T load(String className, Class[] parameterTypes, Object... args) {
        try {
            return (T) Class.forName(className).getDeclaredConstructor(parameterTypes).newInstance(args);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to find class of name " + className);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Failed to find constructor for class " + className);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to initialize class " + className);
        }
    }

    /**
     * Similar to {@link ImplLoader#load(String, Class[], Object...)}, instead
     * of taking the name of the class to load it takes the api class to load
     * the implementation for.
     *
     * <p>For example, to load the implementation for
     * "net.dodogang.ash.loader.api.ModLoader" you can pass ModLoader.class
     * that would load "net.dodogang.ash.loader.impl.ModLoaderImpl"</p>
     *
     * @param clazz the name of the class to be loaded
     * @param parameterTypes the exact parameter class types for the class's
     *                       constructor
     * @param args the exact arguments needed for the class's constructor
     * @return a new instance of the class
     * @param <T> the class
     */
    public static <T> T load(Class<T> clazz, Class[] parameterTypes, Object... args){
        return load(getImplClassName(clazz.getName()), parameterTypes, args);
    }

    /**
     * Similar to {@link ImplLoader#load(String, Class[], Object...)}, but
     * doesn't take a parameterTypes array. Instead, it finds the top level
     * class of the given arguments and uses that.
     *
     * <p>If the constructor has a parameter type that isn't the top level
     * class of a given argument, then you must use
     * {@link ImplLoader#load(String, Class[], Object...)} and specify the
     * class types directly.</p>
     *
     * @param className the name of the class to be loaded
     * @param args the exact arguments needed for the class's constructor
     * @return a new instance of the class
     * @param <T> the class
     */
    public static <T> T load(String className, Object... args) {
        return load(className, Arrays.stream(args).map(Object::getClass).toArray(Class[]::new), args);
    }

    /**
     * Similar to {@link ImplLoader#load(String, Object...)}, but instead of
     * taking the name of the class to load it takes the api class to load the
     * implementation for.
     *
     * <p>For example, to load the implementation for
     * "net.dodogang.ash.loader.api.ModLoader" you can pass ModLoader.class
     * that would load "net.dodogang.ash.loader.impl.ModLoaderImpl"</p>
     *
     * @param clazz the api class
     * @param args the exact arguments needed for the class's constructor
     * @return a new instance of the implementation class
     * @param <T> the class
     */
    public static <T> T load(Class<T> clazz, Object... args){
        return load(getImplClassName(clazz.getName()), args);
    }

    private static String getImplClassName(String apiClassName) {
        int $index = apiClassName.indexOf("$");
        if ($index == -1) {
            return apiClassName.replace(".api.", ".impl.") + "Impl";
        } else {
            String result = apiClassName.substring(0, $index).replace(".api.", ".impl.");
            result += "Impl" + apiClassName.substring($index) + "Impl";
            return result;
        }
    }
}
