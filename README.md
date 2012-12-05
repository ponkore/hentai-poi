# hentai-poi

これは、[変態アドベントカレンダー2012](http://atnd.org/events/33835) の６日目の記事のプログラムです。

## Usage

クリエイターかるたというものが、[ここ](https://docs.google.com/spreadsheet/ccc?key=0Av3kSpsCYs-4dDJtYVRlZEZSbVltOUl4X0RQNjZYSFE&pli=1#gid=0) で公開されています。GoogleDrive 上のドキュメントですので、メニューから [ファイル] - [形式を指定してダウンロード] で手元にダウンロードしてください (.xlsx か .ods 形式) 。
ただし、このプログラムは **Excel2003 形式** しか対応しておりませんので、LibreOffice とかで Excel2003形式 ( .xls ) に変換してください。

あとは、

    ; nREPL 0.1.6-preview
    user> (require 'hentai-poi.core)
    nil
    user> (ns hentai-poi.core)
    hentai-poi.core> (we-are-very-happy)
    1
    １０・レンダリング中のささやかな自由
    
    4
    システムエンジニア（プログラマ）
    
    5
    アイツも鬱か
    
    hentai-poi.core>

こんな感じです。

## License

Copyright © 2012 @ponkore

Distributed under the Eclipse Public License, the same as Clojure.
