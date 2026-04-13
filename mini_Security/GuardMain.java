package java_project;

class Sensor { 
	private String name; // 센서 이름
	private boolean isActive; // 센서 활성화 여부
	private int meter; // 센서의 기본 측정 수치 및 거리
	public Sensor (String name, boolean isActive,int meter){ 
		this.name = name;
		this.isActive = true; // 기본을 true로 저장
		this.meter=meter;
	}
	public void operate() {
		if (isActive == true){
			System.out.println("이 센서에 이름은 "+name+"입니다.\n현재 가동중입니다.");
		} else {
			System.out.println("시스템이 가동되지 않습니다.");
		}
	}
}

class PIRSensor extends Sensor{
	private int detectionRange; // 적외선 센서가 감지한 범위
	public PIRSensor(String name, boolean isActive, int detectionRange){
		super(name, isActive, detectionRange);
		this.detectionRange=detectionRange;
	}
	@Override
	public void operate() {		
		System.out.println("[알림] 적외선으로 움직임을 포착했습니다 경보를 울립니다.\n 전방 : "+detectionRange+"m 방면");
		}
}
class SoundSensor extends Sensor {
	private int threshold; // 경보를 울릴 기준이 되는 소음 수치
	public SoundSensor (String name, boolean isActive, int threshold){
		super(name, isActive, threshold);
		this.threshold=threshold;
	}
	@Override
	public void operate() {
		System.out.println("[알림] 일정 데시벨 이상의 소음을 감지했습니다. 주변을 확인하세요.\n 현재 데시벨 : "+threshold);
	}
}

public class GuardMain {
	public static void main(String[] args) {
		System.out.println("===== 무인 경비 시스템 가동 =====");
		Sensor security = new Sensor("cam", true, 50);
		security.operate(); // 부모 operate를 실행
		SoundSensor sound = new SoundSensor("cam", true, 100);
		System.out.println();
	
		sound.operate();
		System.out.println("==================");
		PIRSensor pir = new PIRSensor("cam", true, 500);
		pir.operate();
		System.out.println();
		System.out.println("=====시스템 점검 완료=====");
	}
}
