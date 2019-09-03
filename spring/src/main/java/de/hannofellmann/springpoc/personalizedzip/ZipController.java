package de.hannofellmann.springpoc.personalizedzip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ZipController {
    private static ZipService zipService = new ZipService();

    @PostMapping(path = "/generate", produces = "application/zip")
    public void generate(@RequestParam String name, HttpServletResponse res) throws IOException {
        res.setContentType("application/zip");
        zipService.writePersonalizedZip(name, res.getOutputStream());
    }
}
