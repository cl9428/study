package com.example.demo.overlapUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


/**
 * @Description: GeoJSON工具类
 * @author: Mr.xulong
 * @date: 2023年01月09日 14:39
 */
public class GeoJSONUtils {
    /**
     * 判断是否在面上
     * @param x
     * @param y
     * @param geojson
     * @return boolean
     */
//    private static boolean surface(double x, double y, String geojson) {
//        try{
//            String wktStr =  GeoJSONUtils.geojson2Wkt(geojson);
//            Point wktPoint = new GeometryFactory().createPoint(new Coordinate(x, y));
//            return GeoJSONUtils.contains(wktPoint, wktStr);
//        }catch (Exception e){
//            return false;
//        }
//    }

    /**
     * 判断是否在面上
     * @param wktPoint
     * @param wktMapStr
     * @return
     */
    private static boolean contains(Point wktPoint, String wktMapStr) {
        //从WKT字符串读取几何图形
        Geometry g = null;
        try {
            //读取面
            g = new WKTReader().read(wktMapStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        //计算点是否在面内
        return g.contains(wktPoint);
    }

    public static Geometry geojson2Geometry(String geojson) throws IOException {
        GeometryJSON gjson = new GeometryJSON(7);
        return gjson.read(new StringReader(geojson));
    }

    public static String geometry2Geojson(Geometry geometry) throws IOException {
        GeometryJSON gjson = new GeometryJSON(7);
        StringWriter writer = new StringWriter();
        gjson.write(geometry, writer);
        return writer.toString();
    }

    public static Geometry wkt2Geometry(String wkt) throws ParseException {
        WKTReader reader = new WKTReader();
        return reader.read(wkt);
    }

    public static String geometry2Wkt(Geometry geometry) throws ParseException {
        WKTWriter writer = new WKTWriter();
        return writer.write(geometry);
    }

    /**
     * geojson 转 wtk
     *
     * @param geojson
     * @return
     * @throws Exception
     */
    public static String geojson2Wkt(String geojson) throws Exception {
        Geometry geometry = geojson2Geometry(geojson);
        return geometry2Wkt(geometry);
    }

    /**
     * wkt 转 geojson
     *
     * @param wkt
     * @return
     * @throws Exception
     */
    public static String wkt2Geojson(String wkt) throws Exception {
        Geometry geometry = wkt2Geometry(wkt);
        return geometry2Geojson(geometry);
    }

    /**
     * obj 转
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String obj2StringPretty(T obj) {
        ObjectMapper mapper = new ObjectMapper();
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> T string2Obj(String str, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        if (StringUtils.isEmpty(str) || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) str : mapper.readValue(str, clazz);
        } catch (IOException e) {
            return null;
        }
    }
}