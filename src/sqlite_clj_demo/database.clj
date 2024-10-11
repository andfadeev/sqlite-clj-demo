(ns sqlite-clj-demo.database
  (:require [clojure.tools.logging :as log]
            [next.jdbc.connection :as connection]
            [next.jdbc.date-time])
  (:import (com.zaxxer.hikari HikariDataSource)
           (org.flywaydb.core Flyway)))

(defn datasource-component
  [config]
  (connection/component
   HikariDataSource
   (assoc (:db config)
          :init-fn (fn [datasource]
                     (log/info "Database migrations started")
                     (.migrate
                      (.. (Flyway/configure)
                          (dataSource datasource)
                          (locations (into-array String ["classpath:database/migrations"]))
                          (table "schema_version")
                          (load)))
                     (log/info "Database migrations are done")))))
