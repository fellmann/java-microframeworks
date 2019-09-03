const express = require("express");
const zipService = require("./zipService");

const app = express();

app.use(express.static("public"));
app.use(express.urlencoded({ extended: true }));

app.post("/generate", function (req, res) {
  res.contentType(`application/zip`);
  zipService.generateZip(req.body.name, res);
});

app.listen(3000, () => console.log(`Example app listening on http://localhost:3000 after ${Math.ceil(process.uptime() * 1000) / 1000}s`));
