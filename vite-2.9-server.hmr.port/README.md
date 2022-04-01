
# Reproduction:

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
