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

Reflection

  Dalam merepresentasikan sistem crafting atau pembelian item di dalam game Mobile Legends, struktur data Tree jauh lebih ideal dan logis dibandingkan Array. Karena array menyimpan data secara linear (one-to-one), sehingga hanya mampu merepresentasikan satu jalur pembelian lurus tanpa ada opsi percabangan untuk membeli item mentahan. Sedangkan, Tree sendiri bercabang, yang mana sangat cocok untuk digunakan dalam sistem kombinasi resep di dalam game, Karena satu item final (sebagai root) bisa memiliki banyak komponen item dasar yang berbeda (sebagai children), sehingga kita dapat membuat berbagai variasi resep yang kompleks secara dinamis dan efisien.

  Praktikum ini membantu memperdalam pemahaman saya tentang implementasi rekursi, khususnya pada bagian pembuatan method seperti countNodes, printTree, dan findPath. Saya menyadari bahwa rekursi sangat bagus diimplementasikan untuk menelusuri Tree, karena kita tidak perlu mencari tau secara pasti seberapa dalam tingkat (level) dari resep tersebut, fungsi akan secara otomatis memanggil dirinya sendiri hingga mencapai titik akhir atau leaf node (base case). Adapun tantangan terbesar yang saya hadapi saat melakukan tracing struktur pohon ini adalah penyesuaian logika arah. Saat bermain game, kita terbiasa berpikir dari bawah ke atas (mulai dari membeli mentahan untuk menjadi item besar), namun saat melakukan tracing dan pencarian di dalam kode Tree, alur berpikirnya harus dibalik (dari item final dipecah ke mentahannya).
