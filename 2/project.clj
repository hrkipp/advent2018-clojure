(defproject day2 "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot day2.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
