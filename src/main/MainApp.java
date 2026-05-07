package main;

import java.util.*;

public class MainApp {

static final String RESET = "\u001B[0m";
static final String RED = "\u001B[91m";
static final String GREEN = "\u001B[92m";
static final String YELLOW = "\u001B[93m";
static final String BLUE = "\u001B[94m";
static final String PURPLE = "\u001B[95m";
static final String CYAN = "\u001B[96m";

    static Scanner sc = new Scanner(System.in);

    static String passengerName;
    static double selectedDistance;
    static String selectedCar;
    static double finalFare;
    static int rating;
    static double tip;

    public static void main(String[] args) {

        printBanner();
        System.out.println("\nRide Beyond Boundaries");
        System.out.println("\nPress ENTER to continue...");
        sc.nextLine();

        login();

        selectedDistance = selectRoute();

        selectedCar = selectCarType();

        double baseFare = calculateFare(selectedDistance, selectedCar);

        finalFare = applyOffers(selectedDistance, baseFare, selectedCar);

        showSelectedCarAgain(selectedCar);

        assignDriver();

        ratingAndTip();

        printCompleteRideDetails();

        printThankYouBanner();
    }

    // =====================================================

    static void printBanner() {
        System.out.println("████████╗██████╗ ██╗██████╗ ███╗   ███╗ █████╗ ████████╗███████╗");
        System.out.println("╚══██╔══╝██╔══██╗██║██╔══██╗████╗ ████║██╔══██╗╚══██╔══╝██╔════╝");
        System.out.println("   ██║   ██████╔╝██║██████╔╝██╔████╔██║███████║   ██║   █████╗");
        System.out.println("   ██║   ██╔══██╗██║██╔═══╝ ██║╚██╔╝██║██╔══██║   ██║   ██╔══╝");
        System.out.println("   ██║   ██║  ██║██║██║     ██║ ╚═╝ ██║██║  ██║   ██║   ███████╗");
        System.out.println("   ╚═╝   ╚═╝  ╚═╝╚═╝╚═╝     ╚═╝     ╚═╝╚═╝  ╚═╝   ╚═╝   ╚══════╝");
        System.out.println("                    TRIPMATE ");
    }

    // =====================================================

    static void login() {
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter your name: ");
        passengerName = sc.nextLine();

        System.out.print("Enter 10-digit phone number: ");
        String phone = sc.nextLine();

        int otp = new Random().nextInt(9000) + 1000;
        System.out.println("\nOTP (Simulation): " + otp);

        System.out.print("Enter OTP: ");
        int userOtp = sc.nextInt();
        sc.nextLine();

        if (userOtp == otp)
            System.out.println("\nLogin Successful ");
        else {
            System.out.println("Invalid OTP. Exiting...");
            System.exit(0);
        }
    }

    // =====================================================

    static double selectRoute() {

        System.out.println("\nSelect Route:");
        System.out.println("1. Hyderabad --> Agra (1248 KM)");
        System.out.println("2. Hyderabad --> Bangalore (570 KM)");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) return 1248;
        else return 570;
    }

    // =====================================================

    static String selectCarType() {

        System.out.println("\n========= SELECT CAR =========");

        System.out.println("\n1. HATCHBACK");
        printHatchback();
        System.out.println("Offer: 5% Discount ");

        System.out.println("\n2. SUV");
        printSUV();
        System.out.println("Offer: 8% Discount ");

        System.out.println("\n3. LUXURY SEDAN");
        printLuxury();
        System.out.println("Offer: Complimentary Water Bottle ");

        System.out.print("\nEnter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) return "HATCHBACK";
        else if (choice == 2) return "SUV";
        else return "LUXURY SEDAN";
    }

    // =====================================================

    static void printHatchback() {
            System.out.print(GREEN);
            System.out.println("██╗  ██╗ █████╗ ████████╗ ██████╗██╗  ██╗██████╗  █████╗  ██████╗██╗  ██╗");
            System.out.println("██║  ██║██╔══██╗╚══██╔══╝██╔════╝██║  ██║██╔══██╗██╔══██╗██╔════╝██║ ██╔╝");
            System.out.println("███████║███████║   ██║   ██║     ███████║██████╔╝███████║██║     █████╔╝ ");
            System.out.println("██╔══██║██╔══██║   ██║   ██║     ██╔══██║██╔══██╗██╔══██║██║     ██╔═██╗ ");
            System.out.println("██║  ██║██║  ██║   ██║   ╚██████╗██║  ██║██████╔╝██║  ██║╚██████╗██║  ██╗");
            System.out.println("╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝    ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝");
        System.out.println("\n" +
                "\n" +
                "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\n" +
                "MWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNNNNXXXXXXKKKXXKKXXXXNNWWWWWWWWWWWWWWWWWWWWWWWWWWWWWMWW\n" +
                "WWWWWWWMWWWWMWWWWMWWWWWWWWMWWWWWWWNXKOxddolcc::;;;;,,,,,,,,,,,;;;::cclodddxO0KXWMWWWWMWWWWMWWWWMWWWW\n" +
                "MWWWWMWWWWMWWWMWWWWMWWWWMWWWWMWXOdc;,,,'...''........................,:cc::cclodkKWMWWWMWWWWWWWWWMWW\n" +
                "WWWWWWWWWWWWWWWWWWWWWWWWWWWWNOo:,,;clo:'..;od:'...........'',,,;,...;lddol:coddl:ckXWWWWWWWWWWWWWWWW\n" +
                "WWWWWWWWWWWWWWWWWWWWWWWWWWXxc'':loxkxl'..,okd;....... ...cxxxxxd;..'cdxkxo::oxxdo::oKWWWWWWWWWWWWWWW\n" +
                "WWWWWWWWWWWWWWWWWWWWWWWWKd;',cdxkkkkl'..'okkc.        ...:xkkkkc. .,cldkkdl;cdkkdlc:l0WWWWWWWWWWWWWW\n" +
                "WWWWWWWWWWWWWWWWWWWWXOxl,.':oxxxxddo,...;odo;.       .....',:lc. ..,cccllllc:oxkkdoc;lKWWWWWWWWWWWWW\n" +
                "MWWWWMWWWWMWWWWMWWNKl'.....''''''''......................... ......,,......,;:ccc:;'.':kNWWWWWWWWMWW\n" +
                "WWWMWWWMWWWWWWNKkdc,'...............................................       ........''',:kNMWWWWMWWWW\n" +
                "MWWWWWWWWWWXkdl;'................................................    .......'.',;;;;,',;oKWWMWWWWWWW\n" +
                "WWWWWWWWWXd;.................           ............................'',,;;;;;'.,;;;;,''.:0WWWWWWWWWW\n" +
                "WWWWWWWWNx;........................ .......  .....''''''.........,;,,,,,,,,,,'',;;;:;'..,xXWWWWWWWWW\n" +
                "WWWWWWWNOolc.         .,;;.            .....'''.,clloxxc..   ...',;,...''',,,;;;;:::;....,kWWWWWWWWW\n" +
                "WWWWWWN0dooc.         'lo:.           ..',,;;;,'';:cllc'.   ......',''',,,;;;;;;::::'..'..cXWWWWWWWW\n" +
                "MWWWWMXl',,'...........''....        ...',',''''........   ...... .''...',;;;;;,,,,,..';;.:KMWWWWMWW\n" +
                "WWWMWW0;..'',,';cdddddoollllccc;'......                   ...,ll,. ......'''...........'::lKWWWMWWWW\n" +
                "WWWWWWx'..',,,,ckXNNNNNNNNXXXXXx,......                   ....lo'..............       .cxxkXWWWWWWWW\n" +
                "WWWWWNd'.....'',;clllllllllllll:.....                    ..''.,;.,;...             .  .:llkNWWWWWWWW\n" +
                "WWWWWNd.............................  .    .''......  ... .lo;,:oOd'           ....   .lolkNWWWWWWWW\n" +
                "WWWWWWx'..............................     ......... ..   .cdc:loc,.    ....',:c:.    .lod0WWWWWWWWW\n" +
                "WWWWWWKl.   .........................             ......  ....,;,........',;:cloo,     'cxXWWWWMWWWW\n" +
                "MWWWWMWKc.           .;;;,''........                       ..cc,lo,....'',,,;;;;:;,'''';lkKNWWWWWMWW\n" +
                "WWWWWWWWXo'.        .:lcc:;;,''........                    .;x:.:o;',;cloddxkkOO0KKKXXNNNWWWWWWWWWWW\n" +
                "WWWWWWWWNXOdlcc::;;:::;;;;,,,,,,,,,'''''''''..........      .;:c:,,:oxk0KXXXNNNNWWWWWWWWWWWWWWWWWWWW\n" +
                "WWWWWWWWWWWWWWWNNNXXKK000OOOOkkkkxxxxxxddddooooollllc:,'......,:coxOKXNNWWWWWWWWWWWWWWWWWWWWWWWWWWWW\n" +
                "WWWWWWWWWWWWWWWWWWWNNWWNNNNNNNNNNXXXXXXXXXKKKKKK0000000000000KKXNNWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
              System.out.println("Compact & Budget Friendly");
              System.out.print(RESET);
    }

    static void printSUV() 
    {
            System.out.print(BLUE);
            System.out.println("███████╗██╗   ██╗██╗   ██╗");
            System.out.println("██╔════╝██║   ██║██║   ██║");
            System.out.println("███████╗██║   ██║██║   ██║");
            System.out.println("╚════██║██║   ██║╚██╗ ██╔╝");
            System.out.println("███████║╚██████╔╝ ╚████╔╝ ");
            System.out.println("╚══════╝ ╚═════╝   ╚═══╝  ");
        System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWWWWNWNNNNNNNNXXXXKKK00000000000000000KKKKKKKKKXXXXXNNNNNNNNNNNNNNNWWWWWWNWMWWWWMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWXOdclkXNXKOkxdoollccc::;;;,,,'''''''''''''''',,,,,,,,;;;;:::cccloOXNNNNNNNN0xooodONWWWMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKd:'..;oxxo:,'.......................................................:kXNNNNNNKx;   .cONWMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNOo;. .;loo:'.................................................            .:ONNNNNNNXx;.  .:kNMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXkl,. .;lol;................                                                   .xXNNNNNXNXk;.  .;kNMWWMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWKxc'  .,oxkdc:,.                                                                   'ONNNNNNNNNXk:.  .;ONMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXOd;.  .,lkxlo0KKKKc                                           ...........''',,;;;;:::cxKNXNNNNNNNNNXOc'  .:ONWW\n" +
                "MMMMMMMMMMMMWMMWWWWWWNNNNNNNNNNNXXXXXKOdoooddOXKd;:dOOkOOo,',,,,,;;;;::::::cccccccllloooooddddxxxkkkkOOOO000KKKKKXXXXNNNNNNNNNNNNXNNNNNNNNNNKd'...'oKW\n" +
                "MMWWNNNNNNXNXXXXXXXXXXXXXXXXXXXXXXXXXXNXNXXXXNNXXXXXXXXXXXXXXXXXNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNXNNNNNNNNNNXXNNNNNNNNNNNNNNNNNNNNNNNNNNOc..,,,,,oX\n" +
                "MWNXXXXXKKKK00KXNXXXNNNNNNNNNNNNNNNNNNNNNNXXNNNNNNNNNNNNNNNNNNNNNNNNNNXNNNNNNNNNXXXNNNNNNNNNNNNNNNNXNNX00000000KXNNXNNNXXXXXXXXXXXXXXXKKXXKx;.',,,,,:O\n" +
                "0cx0kxxdddoolco0XXXKK0Okxxxxxxxxkk0KKXXKXX0KKKKKKKKKKKKKKKKKKKKKKKKKKKOOOOO0OOOKK0KKKKKKKKKKKKKKKKKKKK0OkkkkkOOkkxxddoooooodxOO0000OOOOOO00OOxddddddkX\n" +
                "c.cl::::::::cdOO0koc,..............,cxOO0OkO0OOOOOOOOOOOOOOOOOOO00OO00OOOOOOOOO0OOO0OOOOOOOOOOOOOO00OOO00O0Oxl;'.............';lkOO0O0OO00OOO00OOO0O0N\n" +
                ",;o::cclllook00Od,...     .         ..ck0OkO0OOO00000000000OOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkkkkkkkkkkkOOOO0kc..         .       .'oO0OOOO0OOOOOOOOOOO0N\n" +
                ",o0OO000OO00O0Ol..    ...........     .:kOkOOOOOOOOOkkkkkkkkkkkxxxxxxxxxxxxxxxxxdxxxxxxxxxxxxxxxxxxxxxxkkx;..    ...........     .lOO0OO0OOOOOOO0OOOOK\n" +
                "cO0OOOOOO0OOO0x'.  .......'','......   .cxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdxxxxxxxxxxxxxxxxxxxxxxxd:..   .. ...,,,'......   .o0O00OOOOOOOOOO00O0\n" +
                "dc;;,,;oO0OO0Oc.  .....'.,dxxo'.'....  .'oddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdxxxxxxxxxxxxxxxxxxxxxxxl..  .......;xxxl.......  .;k00O00OOOOO00Okxox\n" +
                "c.......lOOO0x,. ....:;. .:xd;  .;:. .  .:ddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddxxxxxxxxxxxxxxxxxxxxxxx:.  . .':'. .lxo, ..:;. .  .oOOOkkkxxxxdl;'..:\n" +
                "k:'....'cO0O0o. ....cxdc;''lc..:ldxc.   .,odddddddddddddddddddddooooooooooooooolllollllllllllllcccccccc:'. .. 'oxoc,.;o:.':oxx;. . ..,,'''...........o\n" +
                "Kd:,'',,:::::,. .. 'lllllc;::;cllllc'    .'''''''''''''''''..............................................  ...;ollll:;:;;lllco:. .  .............,;cdK\n" +
                "MWXkoc:,......  .. .'....;::::;....'. .  ................................................................  ...''...':c;:c,....'.     ....,;cldkOKXWMMM\n" +
                "MMMMMMWNK0kxdooo:. .''':oxl..ldo:..'....'',;;;;;;;;;;;;;;;;;;;;;;;;;;;;:::::::::::::::::::::::::::::::::;;;,. .'.'cod:.,ddl;.'...'clodkOKXWMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMNo...'lxkd'..,dxxl....l0XXNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNWK:. .,okkl...:xkx:.. 'kWMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMNx,...':;....;:'...'xNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWMXo. ..;:,...':;....;0WMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMWKd:.. ...... ..;xXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMW0o,.. .....  .':kNMMMMMMMMMMMMMMMMMMMMMM\n" +
                "MMMMMMMMMMMMMMMMMMMMMNOl,.. ...,lkNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXxc'......;d0NMMMMMMMMMMMMMMMMMMMMMMMM");
        System.out.println("Spacious & Powerful");
        System.out.print(RESET);
    }

    static void printLuxury() {
            System.out.print(RED);
            System.out.println("██╗     ██╗   ██╗██╗  ██╗██╗   ██╗██████╗ ██╗   ██╗    ███████╗███████╗██████╗  █████╗ ███╗   ██╗");
            System.out.println("██║     ██║   ██║╚██╗██╔╝██║   ██║██╔══██╗╚██╗ ██╔╝    ██╔════╝██╔════╝██╔══██╗██╔══██╗████╗  ██║");
            System.out.println("██║     ██║   ██║ ╚███╔╝ ██║   ██║██████╔╝ ╚████╔╝     ███████╗█████╗  ██║  ██║███████║██╔██╗ ██║");
            System.out.println("██║     ██║   ██║ ██╔██╗ ██║   ██║██╔══██╗  ╚██╔╝      ╚════██║██╔══╝  ██║  ██║██╔══██║██║╚██╗██║");
            System.out.println("███████╗╚██████╔╝██╔╝ ██╗╚██████╔╝██║  ██║   ██║       ███████║███████╗██████╔╝██║  ██║██║ ╚████║");
            System.out.println("╚══════╝ ╚═════╝ ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝   ╚═╝       ╚══════╝╚══════╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝");
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNNXXK0OOkxxdoolllllcccclllllooodxxkO0KXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNX0kdlc;,.....            .....''',;;,',,,,,''',;ldOXWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXK00K00kxxdooolccc;.   .',;;;;;;,,,,,;kWKc.''',,,,,,,'...;lx0NWMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWXKO00KXWMMMMMMMMMMWWN0l'.',;,..           lWNc          ..,,;;'..,cxKNMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWN0OOO0XWMMMMMMMMMMMMWKdl;.',,'.               ;KWx.              ';,,;'..,lONMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWXOkkOKNMMMMMMMMMMMMWMNOc...',,.                  .OM0'               .. .;:;. .,lONMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNKOkkOXMMWMMMMMMMMMMMMWKd,..,;,'.                    .xWXc               ..   .,c;.  .,oxOO0XNWMMMWMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNNXK0OdodOXWMMMMMMMMMMMMMMMW0l...,'.  ...',.                 lWWd.           ....''...':xc        ..',:ldOXWMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMWNXK0Okxdolc:;'....  ..',;ccloddxkkOO0KKk:. .,,l:       ;:.    ......''',,;dXNOc;;;;;;;,;;,,,,,,,,,,,,;.                'dXMMM\n" +
                    "MMMMMMMMMMMMMWWNX0Oxdlc:;'...                         ........... .:c;,d0xooooddxdc;::;::;;;;;;;;;,,,,......            .;cll:.               ...,dXMM\n" +
                    "MMMMMMMNX0kdl:,'..                        ..................      ......';ccccc:'.           .,::cc,.            ...   .';;;,..              .dKNX0kXM\n" +
                    "MMMN0xc,..                      ....''..........                                       .....':dxddo:,''...........                            'cx0KOkX\n" +
                    "MW0c,...                  ...........                               ....'',;;;:::::::::::;:;;;,,'......                         ..''...          ...,x\n" +
                    "MKdoooollc:;,,.       .';coddxx;        ......        ..'',;;:::::cccccccc:::;,,'....                .                       .',,''..'''.            .\n" +
                    "Xxdxdxxxxdl:;c'  .,lxOKXNWWWWXo.    .',,,,''''''.    .',;;;,''....                                   .                     .,,..';llc;.....           \n" +
                    "kdxdxddxdo:;;..;dKNWMMMMMWN0o'    .,;'.  ..... ..,.                                                 ..                    .,. ,okxcoxdxo....          \n" +
                    "odoooollc:;' .oKNNXK0Okdl:'.     ';.  'lxkxxkkd;. .'.                                               ..                   .'..cOl,,''..:xx, ..        .\n" +
                    ";dddool:;'.   .......           ',. .okol:..:clkx' .'.                                                                   .. ;x:,',;,''.'xx...        ,\n" +
                    ". ....                         ',  .xO:..;'.;..:OO, .'                                                                  .'..dx,',ccc:'..ck;.'''...   l\n" +
                    "c                             .'. .ok;','',;,',',kx..'.                                                                 .' .dl.';oocc,..:k:.,'.    .:K\n" +
                    "k.        ...........         .'  'ko..';lkkl;'..d0, ..                                  ......''',,,,,,,''''''.....    .' .od,'';lc;'''lk'..  .':oONM\n" +
                    "O,       ...        ..        '.  'Oo',,;dKKo;'',x0, ..                 ...........''''''',,,,,'''''.......             ..  ,kl..,,''..ckc.,:cd0NWMMMM\n" +
                    "d'......';.....  .. .''.      ..  .xd..,,;::,',..xx. ..                                                      .......'.  ..   ;xoc'''.:ldc.cKNWMMMMMMMM\n" +
                    "Kd:,,'..','',,,,,,,;;;:,.     ..   :Oo,. ',';..;x0:  '.                ..........'',,;;;::cccllloooddxxkkkOO000KKKXXN0:.      .lxdxddxo'.lXMMMMMMMMMMM\n" +
                    "MMWNX0Oxdolc;;,'................    cOo'.,. ,;'dO:.'ldollloodddxxxkkOO000KKKKXXNNNNWWWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMXx;.      .',,'..cOWMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMWWWNXXKKK0000KKKKd'      'dOOkocdOko'.:0WMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNKkxddoolllldkKWMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMNk;.      .;looc;..,dXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWN0dc;,,'''..',;lkXMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWWNNNNNNNWWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n");
        System.out.println("Premium & Comfortable");
        System.out.print(RESET);
    }

    // =====================================================

    static double calculateFare(double distance, String carType) {

        double rate = 0;

        if (carType.equals("HATCHBACK")) rate = 8;
        else if (carType.equals("SUV")) rate = 12;
        else rate = 18;

        return distance * rate;
    }

    // =====================================================

    static double applyOffers(double distance, double fare, String carType) {

        if (carType.equals("HATCHBACK"))
            fare = fare * 0.95;
        else if (carType.equals("SUV"))
            fare = fare * 0.92;

        if (distance > 1000) {
            System.out.println("\nLong Distance Bonus Discount Applied!");
            fare = fare * 0.90;
        }

        System.out.println("Final Fare: " + fare);
        return fare;
    }

    // =====================================================

    static void showSelectedCarAgain(String carType) {

        System.out.println("\n======= YOU SELECTED =======");

        if (carType.equals("HATCHBACK")) {
            System.out.println("HATCHBACK");
            printHatchback();
        } else if (carType.equals("SUV")) {
            System.out.println("SUV");
            printSUV();
        } else {
            System.out.println("LUXURY SEDAN");
            printLuxury();
        }
    }

    // =====================================================

    static void assignDriver() {

        System.out.println("\nAssigning Driver...");
        System.out.println("Driver Assigned: Ravi Kumar ");
        System.out.println("Vehicle Number: TS09AB1234");

        System.out.println("\n===== HAPPY JOURNEY =====");

            System.out.println("██╗  ██╗ █████╗ ██████╗ ██████╗ ██╗   ██╗    ████████╗██████╗  █████╗ ██╗   ██╗███████╗██╗     ");
            System.out.println("██║  ██║██╔══██╗██╔══██╗██╔══██╗╚██╗ ██╔╝    ╚══██╔══╝██╔══██╗██╔══██╗██║   ██║██╔════╝██║     ");
            System.out.println("███████║███████║██████╔╝██████╔╝ ╚████╔╝        ██║   ██████╔╝███████║██║   ██║█████╗  ██║     ");
            System.out.println("██╔══██║██╔══██║██╔═══╝ ██╔═══╝   ╚██╔╝         ██║   ██╔══██╗██╔══██║╚██╗ ██╔╝██╔══╝  ██║     ");
            System.out.println("██║  ██║██║  ██║██║     ██║        ██║          ██║   ██║  ██║██║  ██║ ╚████╔╝ ███████╗███████╗");
            System.out.println("╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝        ╚═╝          ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝╚══════╝");

    }

    // =====================================================

    static void ratingAndTip() {

        System.out.print("\nRate your ride (1-5): ");
        rating = sc.nextInt();

        System.out.print("Enter Tip Amount (0 if none): ");
        tip = sc.nextDouble();

        finalFare += tip;
    }

    // =====================================================

    static void printCompleteRideDetails() {

        System.out.println("\n========== COMPLETE RIDE DETAILS ==========");
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Distance       : " + selectedDistance + " KM");
        System.out.println("Car Type       : " + selectedCar);
        System.out.println("Total Paid     : Rupees" + finalFare);
        System.out.println("Rating Given   : " + rating );
    }

    // =====================================================

    static void printThankYouBanner() {

        System.out.println("\n========== THANK YOU ==========");
        System.out.println("████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗    ██╗   ██╗");
        System.out.println("╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝    ██║   ██║");
        System.out.println("   ██║   ███████║███████║██╔██╗ ██║█████╔╝     ██║   ██║");
        System.out.println("   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗     ██║   ██║");
        System.out.println("   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗    ╚██████╔╝");
        System.out.println("   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝     ╚═════╝ ");
        System.out.println("\nThank You For Choosing TRIPMATE ");
    }
}