# Repro case for Vite 2.9 capturing server.hmr.port

## EDIT: working solution from the Vite bug tracker
Seems like this was working due to relying on some undocumented bug in Vite
that was recently fixed. Lucky for me, someone posted a workaround in the 
[issue I created (#7562)](https://github.com/vitejs/vite/issues/7562).

Using that fix the port is no longer captured.
```diff
diff --git a/vite-2.9-server.hmr.port/vite.config.js b/vite-2.9-server.hmr.port/vite.config.js
index d5ea5b2..f24584e 100644
--- a/vite-2.9-server.hmr.port/vite.config.js
+++ b/vite-2.9-server.hmr.port/vite.config.js
@@ -4,7 +4,7 @@ module.exports = defineConfig({
   server: {
     port: 15888,
     hmr: {
-      port: 13001,
+      clientPort: 13001,
     },
   },
 });
```

## Automatic test

```
$ npm t

> vite-2.9-server.hmr.port@1.0.0 test
> ./test.sh

Firing up Vite ...
(!) Could not auto-determine entry point from rollupOptions or html files and there are no explicit optimizeDeps.include patterns. Skipping dependency pre-bundling.
Stopping the background process (1134474)

😢 Vite has captured port server.hmr.port (13001)

Finished!
Terminert
```

## Showing it worked in Vite 2.8
```
npm i vite@2.8
npm t

> vite-2.9-server.hmr.port@1.0.0 test
> ./test.sh

Firing up Vite ...
Stopping the background process (1133689)

😊 Nothing listens on server.hmr.port. As G*d/Evan intended!

Finished!
Terminert
```


# Manual reproduction:

In one window, do `npx vite`. It should say something like:
```
  vite v2.9.1 dev server running at:

  > Local: http://localhost:15888/
  > Network: use `--host` to expose

  ready in 114ms.
```

Now verify it is running on port 13001                  
```
# This is netstat on GNU. BSD will be slightly different
$ netstat -tapn | grep 13001
tcp6       0      0 :::13001                :::*                    LISTEN      1123181/node
```

It did not use to do this
