(ns uked.core
  (:require [cljs.nodejs :as node]))

(node/enable-util-print!)
(enable-console-print!)

(def express (node/require "express"))

(defn -main [port]
  (let [app (express)]
    (.use app (.static express "public"))
    (.listen app port
             (fn []
               (println (str "Server started at http://localhost:" port))))))

(set! *main-cli-fn* -main)

