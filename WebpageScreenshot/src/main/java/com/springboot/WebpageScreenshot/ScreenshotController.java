package com.springboot.WebpageScreenshot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class ScreenshotController {

    @Autowired
    private ScreenshotService screenshotService;

    @GetMapping("/screenshot")
    public String takeScreenshot(@RequestParam String url, @RequestParam String outputPath) throws URISyntaxException {
        screenshotService.takeScreenshot(url, outputPath);
        return "Screenshot saved to " + outputPath;
    }

}
