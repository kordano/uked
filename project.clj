(defproject uked "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2755"]]

  :node-dependencies [[source-map-support "0.2.8"]
                      [express "4.12.3"]
                      [deku "0.2.17"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-npm "0.4.0"]]
  
  :source-paths ["src" "target/classes"]

  :clean-targets ["out/server" "out/server/uked.js" "public/js/compiled/out" "public/js/compiled/uked.js"]

  :cljsbuild
  {:builds
   [{:id "server"
     :source-paths ["src/server"]
     :compiler
     {:main uked.core
      :output-to "out/server/uked.js"
      :output-dir "out/server"
      :optimizations :simple
      :target :nodejs
      :cache-analysis true
      :source-map "out/server/uked.js.map"}}
    {:id "client"
     :source-paths ["src/client"]
     :compiler
     {:output-to "public/js/compiled/uked.js"
      :output-dir "public/js/compiled/out"
      :asset-path "js/compiled/out"
      :externs ["node_modules/deku/index.js"]
      :main uked.core
      :optimizations :none
      :source-map "public/js/uked.js.map"}}]})
