package practice.parttimer;


public class PartTimer {

    private static final int HOUR_RATE = 9860; // 시급
    public static int TOTAL_PART_TIMERS = 0; // 전체 직원수

    private String nickName;
    private String workPlace = "113동";
    private int totalWage = 0;

    public PartTimer(String nickName){
        this.nickName = nickName;
        TOTAL_PART_TIMERS++; // 전체 직원수 +1 증가
    }

    public PartTimer(String nickName, String workPlace){
//        this.nickName = nickName;
//        TOTAL_PART_TIMERS++; // 전체 직원수 +1 증가
        this(nickName); // 생성자 안에서 호출 (생성자 위임) : 먼저 호출할 생성자 지정, delegation
        // 단 생성자 안에서 무조건 첫줄에 실행되어야함
        this.workPlace = workPlace;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    // 근무 시간에 따른 급여 계산
    public int calcTotalWage(int hour){
        totalWage = HOUR_RATE * hour;
        return totalWage;
    }

    // 근무시간 + 상여금에 따른 급여 계산
    public int calcTotalWage(int hour, int bonus){
        totalWage = HOUR_RATE * hour + bonus;
        return totalWage;
    }

} // end cldass
