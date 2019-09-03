const archiver = require("archiver");

module.exports = {
  generateZip: (name, out) => {
    const archive = archiver("zip");
    archive.pipe(out);
    var text = Buffer.from("Hello, " + name + "!");
    archive.append(text, { name: "greeting.txt" });
    archive.finalize();
  }
};
