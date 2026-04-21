/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canvasPrinters.utils;

import com.mycompany.canvasPrinters.CanvasPrinter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericUtils {

    public static Class<?> getCanvasPrinterBoundsType(Class<?> clazz) {
        for (Type type : clazz.getGenericInterfaces()) {
            if (type instanceof ParameterizedType parameterizedType) {
                Type rawType = parameterizedType.getRawType();

                if (rawType instanceof Class<?> rawClass &&
                        CanvasPrinter.class.equals(rawClass)) {

                    Type actualType = parameterizedType.getActualTypeArguments()[0];

                    if (actualType instanceof Class<?> actualClass) {
                        return actualClass;
                    }
                }
            }
        }
        return null;
    }
}