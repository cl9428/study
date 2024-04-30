package com.example.demo.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class PhotoNamesReader {

    public static void main(String[] args) {
        // 文件夹路径
         String folderPath = "/Users/lc/Downloads/c3cdc68de0d94b59b3491b369d614aa7/image";
        // 筛选只读取照片文件
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg");
            }
        };

        // 获取文件夹中的所有照片文件名
        List<String> photoNames = new ArrayList<>();
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles(filter);
            if (files != null) {
                for (File file : files) {
                    photoNames.add(file.getName());
                }
            } else {
                System.out.println("文件夹为空");
            }
        } else {
            System.out.println("文件夹不存在");
        }

        // 打印照片文件名列表
        for (String name : photoNames) {
            System.out.println(name);
        }
    }
}
