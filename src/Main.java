import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] plates = new String[1000];
        int currentIndex = 0;
        do {
            System.out.println("*******Quan ly bien so xe******");
            System.out.println("1. Them cac bien so xe");
            System.out.println("2. Hien thi danh sach bien so xe");
            System.out.println("3. Tim kiem bien so xe");
            System.out.println("4. Tim bien so xe theo ma tinh");
            System.out.println("5. Sap xep bien so xe tang dan");
            System.out.println("6. Thoat");
            System.out.println("Moi nhap lua chon");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhap vao so bien so xe can nhap:");
                    int countPlates = Integer.parseInt(sc.nextLine());
                    //Kiem tra dinh dang cua bien so xe
                    String PlateRegex = "[0-9]{2}[A-Z]{1}\\-[0-9]{3}\\.[0-9]{2}";
                    for (int i = 0; i < countPlates; i++) {



                        do {
                            String plateNumber;
                            boolean valid = true;
                            System.out.printf("Nhap vao bien so xe thu %d co dinh dang nhu sau (30F-123.45) :", (i + 1));
                            plateNumber = sc.nextLine();
                            if (!plateNumber.matches(PlateRegex)) {
                                valid = false;
                                System.out.println("Bien so xe khong dung dinh dang. Vui long nhap dung dinh dang.");

                            } else {
                                for (int j = 0; j < currentIndex; j++) {
                                    if (plates[j].equals(plateNumber)) {
                                        valid = false;
                                        System.out.println("Bien so xe da ton tai. Vui long nhap lai:");
                                        break;
                                    }
                                }
                                if (valid) {
                                    plates[currentIndex] = plateNumber;
                                    System.out.println("Nhap bien so xe thanh cong");

                                    currentIndex++;
                                    break;
                                }
                            }
                        } while (true);

                    }


                    break;
                case 2:
                    System.out.println("Danh sach bien so xe:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%s\t", plates[i]);
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("Nhap bien so xe ban muon tim:");
                    String plateSearch = sc.nextLine();
                    for (int i = 0; i < currentIndex; i++) {
                        if (plates[i].equals(plateSearch)) {
                            System.out.printf("Da tim thay bien so xe %d trong danh sach", plateSearch);
                        } else {
                            System.out.println("Khong tim thay bien so xe ban vua nhap");

                        }
                        System.out.println("\n");
                    }
                    break;

                case 4:
                    System.out.println("Nhap ma tinh cua bien so xe ban can tim:");
                    String Search = sc.nextLine();
                    boolean Exists = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (plates[i].startsWith(Search)) {
                            System.out.printf("Danh sach cac bien so xe co ma tinh, " + Search+ "\t" );
                            System.out.println(plates[i]);
                            Exists = true;

                        }
                    }
                    if (!Exists) {
                        System.out.println("Bien so xe ban muon tim khong ton tai");
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    Arrays.sort(plates, 0, currentIndex); // Sắp xếp mảng biển số xe
                    System.out.println("Sắp xếp biển số xe theo thứ tự tăng dần:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%s\t", plates[i]);
                    }
                    System.out.println();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Vui long nhap lua chon tu 1-6");
            }
        } while (true);

    }
}
