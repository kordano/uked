(ns uked.core
  (:require [cljs.nodejs :as node]))

(node/enable-util-print!)

(def express (node/require "express"))

(defn respond! [req res]
  (.send res "Greetings"))

(defn -main []
  (let [app (express)]
    (.get app "/" respond!)
    (.listen app 3000 (fn [] (println "Server started at localhost:3000")))))


(set! *main-cli-fn* -main)

