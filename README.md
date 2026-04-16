Observation question
1. What is the root node in this program?
  Dalam program ini, root node adalah item final (Tier 3) yang menjadi tujuan akhir dari proses crafting/build, contoh item tier 3 seperti Antique Cuirass, Dominance
Ice, atau Athena's Shield. Node ini berada di puncak hierarki dan menjadi titik awal saat kita menelusuri resep ke bawah.

2. Which nodes are leaf nodes?
  Dalam program ini, Leaf nodes (daun) adalah item-item dasar (Tier 1) yang tidak memiliki komponen pembentuk lagi (children-nya kosong). Contohnya dalam program
ini adalah Vitality Crystal, Leather Jerkin, Magic Resist Cloak, Healing Necklace, dan Hero's Ring.

3. Why is children stored as a List<ItemNode> instead of a single variable?
  Karena struktur Tree merepresentasikan hubungan one-to-many. Sebuah item tier 2 atau item final di MLBB seringkali membutuhkan lebih dari satu jenis item
mentahan (misalnya Dreadnaught Armor butuh 2 Leather Jerkin). Jika kita hanya menggunakan satu variabel tunggal, strukturnya akan berubah menjadi Singly Linked List,
bukan Tree yang bercabang.

4. What is the difference between a linear structure and a tree structure in this example?
  Struktur linear (seperti Array atau Singly Linked List) hanya satu jalur lurus dari awal hingga akhir (one-to-one), yang artinya pemain hanya bisa membeli item
dalam satu urutan tanpa cabang. Sedangkan struktur Tree sendiri bersifat bercabang (one-to-many). Ini sangat cocok untuk sistem crafting item MLBB, di mana satu item
besar bisa dibuat dari berbagai kombinasi cabang item kecil yang berbeda secara bersamaan.

5. How does recursion help when working with trees?
  Tree pada dasarnya adalah struktur data yang rekursif. Menggunakan rekursi sangat membantu karena kita tidak perlu tahu seberapa dalam level crafting sebuah item.
Fungsi akan memanggil dirinya sendiri secara otomatis untuk terus menggali ke bawah sampai menemukan leaf node (Base Case), membuat kode seperti printTree,
countNodes, dan findPath menjadi sangat ringkas dan bersih dibandingkan menggunakan looping (perulangan) biasa.

6. What path is printed when searching for Corrosion Scythe?
  Dalam program untuk item Defense yang saya buat, ketika melakukan pencarian target untuk item dasar (misalnya Hero's Ring) dari root Dominance Ice, jalur yang
dicetak adalah: Dominance Ice -> Black Ice Shield -> Hero's Ring. Ini membuktikan algoritma pencarian menelusuri dari root ke leaf yang tepat.
