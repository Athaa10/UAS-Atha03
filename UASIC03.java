//Atha Maulidia, 244107060080, 03
import java.util.Scanner;

public class UASIC03 {
    static int jmlData03 = (9 % 3) + 4;
    static String[] dataNamaTim03 = new String[jmlData03];
    static int[][] skorTim03 = new int[jmlData03][2];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan03;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan03 = sc.nextInt();
            sc.nextLine();

            switch (pilihan03) {
                case 1:
                    tambahDataSkorTim();
                    break;
                case 2:
                    tampilkanTabelSkor();
                    break;
                case 3:
                    menentukanJuara();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan03 != 4);
    }

    static void tambahDataSkorTim() {
        for (int i = 0; i < jmlData03; i++) {
            System.out.print("\nMasukkan nama tim ke-" + (i + 1) + ": ");
            dataNamaTim03[i] = sc.nextLine();
            int skorLevel103;
            do {
                System.out.print("Masukkan skor " + dataNamaTim03[i] + "untuk Level 1"+ ": ");
                skorLevel103 = sc.nextInt();
                if (skorLevel103 < 0) {
                    System.out.println("Skor harus bilangan positif atau nol. Coba lagi.");
                } else if (skorLevel103 < 35) {
                    skorLevel103 = 0;
                }
            } while (skorLevel103 < 0);

            int skorLevel203;
            do {
                System.out.print("Masukkan skor " + dataNamaTim03[i] + "untuk Level 2"+ ": ");
                skorLevel203 = sc.nextInt();
                if (skorLevel203 < 0) {
                    System.out.println("Skor harus bilangan positif atau nol. Coba lagi.");
                }
            } while (skorLevel203 < 0);

            skorTim03[i][0] = skorLevel103;
            skorTim03[i][1] = skorLevel203;
            sc.nextLine();
        }
    }

    static void tampilkanTabelSkor() {
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
        int totalSkor03;
        for (int i = 0; i < jmlData03; i++) {
            totalSkor03 = skorTim03[i][0] + skorTim03[i][1];
            if (totalSkor03 % 2 == 0) {
                totalSkor03 -= 15;
            }
            System.out.printf("%-20s %-10d %-10d %-10d%n", dataNamaTim03[i], skorTim03[i][0], skorTim03[i][1], totalSkor03);
        }
    }

    static void menentukanJuara() {
        int maxScore03 = 0;
        String juara03 = "juara ";
        boolean seri03 = false;
        for (int i = 0; i < jmlData03; i++) {
            int totalSkor03 = skorTim03[i][0] + skorTim03[i][1];
            if (totalSkor03 % 2 == 0) {
                totalSkor03 -= 15;
            }

            if (totalSkor03 > maxScore03) {
                maxScore03 = totalSkor03;
                juara03 = dataNamaTim03[i];
                seri03 = false;
            } else if (totalSkor03 == maxScore03 && !juara03.islength()) {
                if (skorTim03[i][1] > skorTim03[islength(juara03)][1]) {
                    juara03 = dataNamaTim03[i];
                    seri03 = false;
                } else if (skorTim03[i][1] == skorTim03[islength(juara03)][1]) {
                    seri03 = true;
                }
            }
        }

        if (seri03) {
            System.out.println("Turnamen berakhir dengan seri!");
        } else {
            System.out.println("Selamat kepada Tim " + juara03 + " yang telah memenangkan kompetisi!");
        }
    }

}