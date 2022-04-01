#!/bin/bash
PID=

is-vite-running(){
    (netstat -tapn | grep 15888 > debug.log) 2>/dev/null
}

is-hmr-captured(){
    (netstat -tapn | grep 13001 > debug.log) 2>/dev/null
}

wait-a-sec(){
    sleep 1
}

cleanup(){
    echo "Stopping the background process ($PID)"
    #kill $PID
    trap "exit" INT TERM
    trap "kill 0" EXIT
}

if is-vite-running; then
    echo "Something is running on port 15888. Is vite running? Kill it and retry."
    exit 1
fi

echo "Firing up Vite ..."
npx vite > /dev/null &
PID=$!

while ! is-vite-running; do
    wait-a-sec
done

if is-hmr-captured; then
    cleanup
    sleep .500
    echo -e "\n😢 Vite has captured port server.hmr.port (13001)\n"
else 
    cleanup
    sleep .500
    echo -e "\n😊 Nothing listens on server.hmr.port. As G*d/Evan intended!\n"
fi

echo 'Finished!'
