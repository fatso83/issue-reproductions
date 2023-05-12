# Vite Reproduction Issue: no tree shaking of unused imports

**EDIT:** While initially true, I restructured the library to 
simply expose a sub-export with the react dependency and
also enabled library mode in Vite to avoid the issue.
See [this commit](https://github.com/fatso83/retry-dynamic-import/commit/838aa798460417d1059db1927fa6215d82de7403) for details.

---
> Original description

This reproduction shows that Vite pulls in dependencies
not _directly_ used in the exports it uses.

Try running `npm run dev` and show the Network tab in your DevTools.
The `@fatso83/retry-dynamic-import@1.0.7` weighs in at a hefty 77 KB
even though `main.js` is only referencing the non-react export.
Same thing happens with production build, except it then just
pulls in the 7KB React production build.

What this means it does not tree-shake away the unused imports, as
some webpack plugins would have done.
<img width="1133" alt="Skjermbilde 2023-05-12 kl  09 15 10" src="https://github.com/fatso83/issue-reproductions/assets/618076/73ff69ea-17d0-4067-ab61-4b924f36c442">
