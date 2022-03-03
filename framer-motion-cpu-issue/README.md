# Framer motion cpu usage issue

Here you see the Chrome tab rendering nothing but text and being idle use 12 percent CPU.
If profiling this in Chrome you will quickly spot framer-motion.js as the culprit.
Since this loader is so simple and more or less straight from the getting started docs
where `repeat:Infinity` is being used, it seems it should not be like this.

I would have expected that the cpu usage should fall to 0 when the react component 
has been unmounted, but it seems FM keep the render loop going for infinity.

![cpu usage 12%](./.assets/cpu-usage.png)

## To reproduce
### 1. View example in a browser
You can either check out the [example website](https://fatso83.github.io/issue-reproductions/framer-motion-cpu-issue/) or install the code locally on your own machine:

```
npm i
npx vite
```
Now, open the link and watch the animation take place. 

### 2. Check cpu usage in Chrome Task Manager
Then open Chrome's Task Manager and check out the cpu usage for the current tab after the animation has subsided.  It should stay at a non-zero number, which is OS and computer dependant. On my Linux box it is a constant 12%, on my M1 Macbook it is about 3%. If you change the code so that `repeat=3`, the cpu should quickly die off and idle around 0%.
