(defproject sqlite-clj-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [aero/aero "1.1.6"]
                 [com.stuartsierra/component "1.1.0"]
                 [org.xerial/sqlite-jdbc "3.46.1.3"]
                 [com.github.seancorfield/next.jdbc "1.3.955"]
                 [com.zaxxer/HikariCP "6.0.0"]
                 [org.flywaydb/flyway-core "10.19.0"]
                 [org.clojure/tools.logging "1.3.0"]
                 [org.slf4j/slf4j-simple "2.1.0-alpha1"]]
  :main ^:skip-aot sqlite-clj-demo.core
  :target-path "target/%s"
  :profiles {:kaocha {:dependencies [[lambdaisland/kaocha "1.91.1392"]]}}
  :aliases {"kaocha" ["with-profile" "+kaocha" "run" "-m" "kaocha.runner"]})
