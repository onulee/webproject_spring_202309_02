package sp0214;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyInfo2 implements My {
	@Value("${my.userName}")
	private String name;
	@Value("${height}")
	private double height;
	@Value("${weight}")
	private double weight;
	@Value("${phone}")
	private String phone;
	@Value("${gender}")
	private String gender;
	@Value("${test}")
	private String test;
	@Value("#{${hobby}}")
	private ArrayList<String> hobbys;
	@Autowired
	private BMICalculator bmiCalculator;
	
	@Override
	public void getInfo() {
		System.out.println("[ 개인 신상정보 ]");
		System.out.println("이름 : "+name);
		System.out.println("키 : "+ height);
		System.out.println("몸무게 : "+weight);
		System.out.println("전화번호 : "+phone);
		System.out.println("성별 : "+gender);
		System.out.println("추가진단옵션 : "+test);
		System.out.println("취미 : "+hobbys);
		bmiCalculator.bmicalculation(weight, height);
		
	}

}
