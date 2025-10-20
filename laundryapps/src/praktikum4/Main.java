package praktikum4;

public class Main {
	public static void main(String[] args) {
		Book novel = new Novel("Laskar Pelangi", "Andrea Hirata", "Drama");
		Book magazine = new Magazine("National Geographic", "Various Authors", "Science");
		Book textbook = new Textbook("Pemograman Java", "Anonimous", "Informatika");
		
		User user = new User();
		System.out.println("=== Detail Buku ===");
		user.viewBookDetails(novel);
		System.out.println();
		user.viewBookDetails(magazine);
		System.out.println();
		user.viewBookDetails(textbook);
		System.out.println();
		
		// Meminjam Buku
		
		System.out.println("=== Proses Peminjaman Buku ===");
		user.borrowBook(novel);
		user.borrowBook(magazine);
		
		//Menampilkan status ketersediaan
		System.out.println("\nStatus Buku Setelah dipinjam:");
		System.out.println(novel.getTitle() + " tersedia: " + novel.isAvailable());
		System.out.println(magazine.getTitle() + " tersedia: " + magazine.isAvailable());
		
		//Mengembalikan Buku
		System.out.println("\n=== Proses Pengembalian Buku ===");
		user.returnBook(novel);
		
		//Menampilkan status ketersediaan buku setelah pengembalian
		System.out.println("\nStatus Buku setelah dikembalikan:");
		System.out.println(novel.getTitle() + " tersedia: " + novel.isAvailable());
		
		
	}

}
