import "./style.css";

import { dynamicImportWithRetry } from "@fatso83/retry-dynamic-import";

document.querySelector("#app").innerHTML = `
  <h1>Hello Vite!</h1>
  <a href="https://vitejs.dev/guide/features.html" target="_blank">Documentation</a>
`;

const myModule = dynamicImportWithRetry(() => import("./my-module"));

(async () => console.log("answer", (await myModule).default))();
