(ns uked.core
  (:require [cljs.nodejs :as node]))

(def DEFAULT-PORT 3000)

(node/enable-util-print!)
(enable-console-print!)

(def express (node/require "express"))

(defn -main [port]
  (let [app (express)]
    (.use app (.static express "public"))
    (.use app (.static express "node_modules/deku"))
    (.listen app (or port DEFAULT-PORT)
             (fn []
               (println
                (str "Server started at http://localhost:" (or port DEFAULT-PORT)))))))

(set! *main-cli-fn* -main)

