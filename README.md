#　このプログラムはjavaで作成されたテキストRPGです

##　更新点まとめ

itemクラスをインターフェースに変更

item_healクラスを基底クラスに変更、それに伴い名称を変更

    item_heal -> Heal

    item_heal_Low -> Heal_Low

itemのフィールドをHealに移動

remainingをdurabilityに名称変更

アイテム使用時の耐久地の減りを指定できるように変更

itemクラスにセッターゲッターを定義

itemクラスにメソッドを追加、アイテムの使用(use)、アイテムの耐久地の減少(decrementdurability)、アイテムの効果処理はサブクラスにstaticで実装する、これによりアイテムの効果をアイテム使用以外の方法で実行することが可能（罠とか、ゲーム中のイベントで使用する予定）

## readmeってこれでいいの？