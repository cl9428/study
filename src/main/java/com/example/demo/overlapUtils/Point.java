package com.example.demo.overlapUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Geometry;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    private double x;
    private double y;
}