(ns hentai-poi.core
  (:import
   (java.io FileOutputStream FileInputStream)
   (java.util Date Calendar)
   (org.apache.poi.hssf.usermodel HSSFWorkbook)
   (org.apache.poi.ss.usermodel Workbook Sheet Cell Row WorkbookFactory DateUtil
                                IndexedColors CellStyle Font CellValue)
   (org.apache.poi.ss.util CellReference AreaReference CellRangeAddress RegionUtil)))

;;;
;;; クリエイターかるたを読んでみよう
;;;
(defn system-engineer-column?
  "クリエイターかるたの10列目がカオス"
  [cell]
  (= (.getColumnIndex cell) 9))

(defn read-all-cells
  "ワークシート(2003形式だけだぜくそがぁ。全部なめなめするぜぇ〜ワイルドだろ〜"
  [wb sheet-at]
  (let [sheet (-> wb (.getSheetAt sheet-at))]
    (for [row (iterator-seq (.rowIterator sheet))
          cell (iterator-seq (.cellIterator row))]
      cell)))

(defn read-hoge-xls
  "クリエイターかるたを Excel2003形式 .xls ファイルにしたものを読み込んで、
カオスなものをフィルタリング、その結果から文字列を抽出"
  [infile sheet-at column-filter-func]
  (with-open [input (FileInputStream. infile)]
    (let [wb (WorkbookFactory/create input)
          all-cells (read-all-cells wb sheet-at)]
      (->> all-cells
           (filter column-filter-func)
           (map #(str (.getRowIndex %) "\n" (.getStringCellValue %) "\n"))))))

(defn we-are-very-happy
  "Yeah!! Enjoy your engineer life!!!"
  []
  (doseq [s (read-hoge-xls "クリエイターかるた.xls" 0 system-engineer-column?)]
    (println s)))
