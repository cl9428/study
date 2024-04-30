package com.example.demo.overlapUtils;

import org.locationtech.jts.geom.Geometry;

import java.io.IOException;

import static com.example.demo.overlapUtils.GeoJSONUtils.geojson2Geometry;

public class OverlapPolygon {

   static String json1 = "{\"type\":\"Polygon\",\"coordinates\":[[[116.5141376,39.9093953],[116.5141251,39.9088839],[116.5150653,39.9089919],[116.5150943,39.9094906],[116.5141376,39.9093953]]]}";
   static String json2 = "{\"type\":\"Polygon\",\"coordinates\":[[[116.5146842,39.9089481],[116.5146825,39.9088669],[116.5140404,39.9088443],[116.5140244,39.9094354],[116.5146959,39.9095154],[116.5146946,39.9094508],[116.5141376,39.9093953],[116.5141251,39.9088839],[116.5146842,39.9089481]]]}";

   static Geometry geometry1;

    static {
        try {
            geometry1 = geojson2Geometry(json1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Geometry geometry2;

    static {
        try {
            geometry2 = geojson2Geometry(json2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Boolean b = geometry1.intersects(geometry2);

    public OverlapPolygon() throws IOException {
    }


    public static void main(String[] args) {
        System.out.println(b);
    }

}
