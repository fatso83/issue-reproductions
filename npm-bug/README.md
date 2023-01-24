# Bug in v9 of NPM on global installs

## NPM 8: global install 
> Fails
```
$ n 18
   installed : v18.13.0 (with npm 8.19.3)

$ rm -r node_modules/ package-lock.json 2>/dev/null;npm i -g
npm ERR! code 127
npm ERR! path /Users/carlerik/dev/test-npm-bug
npm ERR! command failed
npm ERR! command sh -c -- npm exec mkdirp ~/.config/@fatso83/fetch-todays-calendar ~/.local/share/@fatso83/fetch-todays-calendar
npm ERR! sh: mkdirp: command not found

npm ERR! A complete log of this run can be found in:
npm ERR!     /Users/carlerik/.npm/_logs/2023-01-24T14_26_46_955Z-debug-0.log
```

## NPM 8: Local install followed by global install
> Success

```
$ n 18
   installed : v18.13.0 (with npm 8.19.3)

$ rm -r node_modules/ package-lock.json 2>/dev/null;npm i;npm i -g

> preinstall
> npm exec mkdirp ~/.config/@fatso83/fetch-todays-calendar ~/.local/share/@fatso83/fetch-todays-calendar


added 1 package, and audited 2 packages in 1s

1 package is looking for funding
  run `npm fund` for details

found 0 vulnerabilities

up to date, audited 3 packages in 296ms

found 0 vulnerabilities
```

## NPM 9: global install 
> Failure 
```
$ n 19
   installed : v19.4.0 (with npm 9.2.0)

$ rm -r node_modules/ package-lock.json 2>/dev/null;npm i -g
npm ERR! code 127
npm ERR! path /usr/local/lib/node_modules/npm-bug-v8
npm ERR! command failed
npm ERR! command sh -c npm exec mkdirp ~/.config/@fatso83/fetch-todays-calendar ~/.local/share/@fatso83/fetch-todays-calendar
npm ERR! sh: mkdirp: command not found

npm ERR! A complete log of this run can be found in:
npm ERR!     /Users/carlerik/.npm/_logs/2023-01-24T14_28_12_604Z-debug-0.log
```

## NPM 9: local install followed by global install 
> Failure 
```
$ n 19
   installed : v19.4.0 (with npm 9.2.0)

$ rm -r node_modules/ package-lock.json 2>/dev/null;npm i;npm i -g

> preinstall
> npm exec mkdirp ~/.config/@fatso83/fetch-todays-calendar ~/.local/share/@fatso83/fetch-todays-calendar


added 1 package, and audited 2 packages in 6s

1 package is looking for funding
  run `npm fund` for details

found 0 vulnerabilities
npm ERR! code 127
npm ERR! path /usr/local/lib/node_modules/npm-bug-v8
npm ERR! command failed
npm ERR! command sh -c npm exec mkdirp ~/.config/@fatso83/fetch-todays-calendar ~/.local/share/@fatso83/fetch-todays-calendar
npm ERR! sh: mkdirp: command not found

npm ERR! A complete log of this run can be found in:
npm ERR!     /Users/carlerik/.npm/_logs/2023-01-24T14_29_15_438Z-debug-0.log

```

## NPM 9: local install followed by global install _as NPM script_
> Success! This should be the same as the one above that fails, right?
```
$ npm --version
9.2.0

$ npm run local-global

> local-global
> rm -r node_modules/ package-lock.json 2>/dev/null;npm i;npm i -g


> preinstall
> npm exec mkdirp ~/.config/@fatso83/fetch-todays-calendar ~/.local/share/@fatso83/fetch-todays-calendar


added 1 package, and audited 2 packages in 1s

1 package is looking for funding
  run `npm fund` for details

found 0 vulnerabilities

changed 2 packages in 310ms

1 package is looking for funding
  run `npm fund` for details
```
