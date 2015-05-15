(defproject uked "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2755"]]

  :node-dependencies [[source-map-support "0.2.8"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-npm "0.4.0"]]
  
  :npm-root :target-path
  
  :source-paths ["src" "target/classes"]

  :clean-targets ["out/server" "out/server/uked.js"]

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
      :source-map "out/server/uked.js.map"}}]})
