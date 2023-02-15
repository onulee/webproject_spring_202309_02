package sp0214;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyInfo implements My {
	@Value("${my.userName}")
	private String name;
	@Value("${height}")
	private double height;
	@Value("${weight}")
	private double weight;
	@Value("#{${hobby}}")
	private ArrayList<String> hobbys;
	
	@Autowired
	private BMICalculator bmiCalculator;
	
	public void getInfo() {
		System.out.println("[ 개인 신상정보 ]");
		System.out.println("이름 : "+name);
		System.out.println("키 : "+ height);
		System.out.println("몸무게 : "+weight);
		System.out.println("취미 : "+hobbys);
		bmiCalculator.bmicalculation(weight, height);
	}

}
