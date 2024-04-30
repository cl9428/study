package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@RestController
@Slf4j
public class httpProxy {

    @GetMapping("/proxyChat")
    public String proxyChat() {
        log.info("hello");
        return "hello";
    }

    @GetMapping("/logInfo")
    public Object logInfo(@RequestParam("searchString") String searchString,String lineSum,String logFilePath) {

//        String logFilePath = "/Users/lc/IdeaProjects/demo/target/output.out"; // 替换为你的日志文件路径
//        String searchString = "ERROR"; // 替换为你想搜索的字符串

        ProcessBuilder processBuilder = new ProcessBuilder();
        // 设置命令，这里使用grep来搜索包含特定字符串的行
        processBuilder.command("bash", "-c", "grep -n"+lineSum +" '" + searchString + "' " + logFilePath);

        Process process = null;
        BufferedReader reader = null;
        StringBuilder out = new StringBuilder();

        try {
            // 启动进程
            process = processBuilder.start();

            // 获取进程的输出流
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line).append(System.lineSeparator()); // 使用StringBuilder拼接字符串，并添加换行符
                // 输出包含搜索字符串的行
                System.out.println(line);
            }

            // 等待进程结束
            int exitCode = process.waitFor();

            // 格式化输出退出码信息
            if (exitCode == 0) {
                System.out.println("Search completed successfully.");
            } else {
                System.out.printf("Search failed with exit code: %d%n", exitCode);
            }

            return out; // 返回拼接后的输出字符串

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 确保关闭BufferedReader
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 确保销毁Process对象
            if (process != null) {
                process.destroy();
            }
        }

        return "没有关键信息";
    }
}
