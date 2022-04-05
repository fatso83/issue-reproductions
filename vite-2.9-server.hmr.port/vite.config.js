const { defineConfig } = require("vite");

module.exports = defineConfig({
  server: {
    port: 15888,
    hmr: {
      clientPort: 13001,
    },
  },
});
