(defproject square-clojure "0.1.0-SNAPSHOT"
  :description "Library to connect to square api"
  :url "https://github.com/mark-nery/square-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "2.3.0"]
                 [cheshire "5.6.3"]
                 [clj-time "0.13.0"]]
  :main ^:skip-aot square-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
