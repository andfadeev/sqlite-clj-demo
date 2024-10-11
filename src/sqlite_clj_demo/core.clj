(ns sqlite-clj-demo.core
  (:require [clojure.java.io :as io]
            [aero.core :as aero]
            [com.stuartsierra.component :as component]
            [sqlite-clj-demo.database :as database])
  (:gen-class))

(defn read-config
  []
  (aero/read-config
    (io/resource
      "config.edn")))

(defn build-system
  [config]
  (component/system-map
    :db (database/datasource-component config)))

(defn -main [])
