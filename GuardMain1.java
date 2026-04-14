package mini_Security;
import java.util.Scanner;
import java.util.Random;

class Sensor {
	private String name;
	private boolean isActive;
	private int meter;
	public Sensor (String name, boolean isActive,int meter){
		this.name = name;
		this.isActive = true;
		this.meter=meter;
	}
	public void operate() {
		if (isActive == true){
			System.out.println("센서명 :  "+name+"\n상태 : 현재 가동중\n탐지 거리 : "+meter);
		} else {
			System.out.println("시스템이 가동되지 않습니다.");
		}
	}
}

class PIRSensor extends Sensor{
	private int detectionRange;
	public PIRSensor(String name, boolean isActive, int detectionRange){
		super(name, isActive, detectionRange);
		this.detectionRange=detectionRange;
	}
	@Override
	public void operate() {
		if (detectionRange > 50) {		
			System.out.println("[알림] 적외선으로 움직임을 포착했습니다 경보를 울립니다.\n 전방 : "+detectionRange+"m 방면");	
			System.out.println("========================");
			System.out.println();
		} else {
			System.out.println("주변 이상 없습니다.\n"+"현재 적외선 탐지 감도 : "+detectionRange);
			System.out.println("========================");
			System.out.println();
		}
	}
}
class SoundSensor extends Sensor {
	private int threshold;
	public SoundSensor (String name, boolean isActive, int threshold){
		super(name, isActive, threshold);
		this.threshold=threshold;
	}
	@Override
	public void operate() {
		if (threshold > 100) {
			System.out.println("[알림] 일정 데시벨 이상의 소음을 감지했습니다. 주변을 확인하세요.\n 현재 데시벨 : "+threshold);
			System.out.println("========================");
			System.out.println();
		} else {
			System.out.println("주변 소음 이상 없습니다.\n"+"현재 소음 : "+threshold);
			System.out.println("========================");
			System.out.println();
		}
	}
}

public class GuardMain1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("전원을 켤까요?(Y/N)");
		String ans = scanner.nextLine();
		if (ans.equals("N") || ans.equals("m")){
			 System.out.println("프로그램을 종료합니다.");
			 System.exit(0);
		} else if(ans.equals("Y") || ans.equals("y")){
			System.out.println("프로그램을 시작합니다! 로딩중...");
		}
		else {
			System.out.println("프로그램을 닫습니다.");
			System.exit(0);
		}		
		System.out.println("=====장비 초기 세팅=====");
		System.out.print("장비 이름을 입력하세요 : ");
		String sennm = scanner.nextLine();
		System.out.print("장비 탐지 거리를 알려주세요(미터 단위로 입력해주세요) : ");
		int met = scanner.nextInt();
		System.out.println("========================");
		System.out.println();

		scanner.nextLine();
		
		while (true) 
		{
		
		System.out.println("===원하는 메뉴의 번호를 선택해주세요===");
		System.out.println("1. 시스템 작동 | 2. 장비 제원 | 3. 종료");
		int cho = scanner.nextInt();

		if (cho == 1) {	
		System.out.println("===== 무인 경비 시스템 가동 =====\n");
		
		Random random = new Random();
		Random random1 = new Random();
		int value = random.nextInt(200);
		int value1 = random.nextInt(100);
		SoundSensor sound = new SoundSensor("cam", true, value);
		PIRSensor pir = new PIRSensor("cam", true, value1);
		sound.operate();
		pir.operate();
		}		
		else if (cho == 2) {
			Sensor security = new Sensor(sennm, true, met);
			security.operate();
		}

		else if(cho == 3) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		}
	
		
	scanner.close();
	}
}
