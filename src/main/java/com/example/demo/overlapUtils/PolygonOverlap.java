package com.example.demo.overlapUtils;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class PolygonOverlap {
    public static boolean doPolygonsOverlap(List<Point> polygon1, List<Point> polygon2) {
        // 获取每个图形的所有边
        List<Vector2D> edges1 = getEdges(polygon1);
        List<Vector2D> edges2 = getEdges(polygon2);

        // 对于每对边，找到一个潜在的分离轴
        for (Vector2D edge1 : edges1) {
            for (Vector2D edge2 : edges2) {
                Vector2D axis = edge1.perpendicular().normalize();

                // 将每个图形的所有顶点投影到分离轴上
                Range range1 = projectPolygonOntoAxis(axis, polygon1);
                Range range2 = projectPolygonOntoAxis(axis, polygon2);

                // 如果这两个范围没有交集，那么这两个图形就在该轴上被分离了
                if (!range1.overlaps(range2)) {
                    return false;
                }
            }
        }

        // 如果所有的分离轴都不能将两个图形分离，那么它们就一定有重叠的部分
        return true;
    }

    private static List<Vector2D> getEdges(List<Point> polygon) {
        List<Vector2D> edges = new ArrayList<>();
        int numVertices = polygon.size();
        for (int i = 0; i < numVertices; i++) {
            Point vertex1 = polygon.get(i);
            Point vertex2 = polygon.get((i + 1) % numVertices);
            edges.add(new Vector2D(vertex2.getX() - vertex1.getX(), vertex2.getY() - vertex1.getY()));
        }
        return edges;
    }

    private static Range projectPolygonOntoAxis(Vector2D axis, List<Point> polygon) {
        double minProjection = Double.MAX_VALUE;
        double maxProjection = -Double.MAX_VALUE;

        for (Point vertex : polygon) {
            double projection = axis.dotProduct(vertex.getX(), vertex.getY());
            minProjection = Math.min(minProjection, projection);
            maxProjection = Math.max(maxProjection, projection);
        }

        return new Range(minProjection, maxProjection);
    }

    private static class Vector2D {
        private final double x;
        private final double y;

        public Vector2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Vector2D perpendicular() {
            return new Vector2D(-y, x);
        }

        public Vector2D normalize() {
            double length = Math.sqrt(x * x + y * y);
            return new Vector2D(x / length, y / length);
        }

        public double dotProduct(double x, double y) {
            return this.x * x + this.y * y;
        }
    }

    private static class Range {
        private final double min;
        private final double max;

        public Range(double min, double max) {
            this.min = min;
            this.max = max;
        }

        public boolean overlaps(Range other) {
            return this.max > other.min && this.min < other.max;
        }
    }
}