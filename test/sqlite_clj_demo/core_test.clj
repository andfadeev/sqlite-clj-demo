(ns sqlite-clj-demo.core-test
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as component]
            [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]
            [sqlite-clj-demo.core :as core]))


(def ^:dynamic *test-system* nil)

(defn with-system
  [test-fn]
  (binding [*test-system* (-> (core/read-config)
                              (core/build-system)
                              (component/start-system))]
    (try
      (test-fn)
      (finally
        (component/stop *test-system*)))))

(use-fixtures :each with-system)

(deftest a-test
  (let [db (:db *test-system*)]
    (sql/insert! (db) :users {:id 1
                              :name "Andrey"})
    (is (= {:id 1
            :name "Andrey"} (sql/get-by-id (db) :users 1 jdbc/unqualified-snake-kebab-opts)))))
