(ns uked.core)

(enable-console-print!)

(println "Greetings my Lord!")

(def hello-world
  {:initialState (fn [] #js {:greeting "Hello WOrld!"})
   :render (fn [component]
             (println component)
             (.element js/deku "div" (.. component -state -greeting)))})

(defn main-view
  ""
  [component]
  (let [app (.tree js/deku (.element js/deku (clj->js component)))]
    (.render js/deku app (.-body js/document))))

(main-view hello-world)
