(ns uked.core
  (:require [cljs.nodejs :as nodejs]))

;; (repl/connect "http://localhost:9000/repl")

(enable-console-print!)

(defn -main []
  (println "Hello world!"))

(set! *main-cli-fn* -main)

