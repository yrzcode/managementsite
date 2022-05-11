package com.test.managementsite.data;

import java.util.HashMap;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record MemberForm (
        @NotBlank(message = "*名前を入力してください")
        @Size(max = 50, message = "*名前は50桁以内で入力してください")
        String name,
        String sex,

        @NotBlank(message = "*住所を入力してください")
        @Size(max = 255, message = "*住所は255桁以内で入力してください")
        String address,

        @NotBlank(message = "*年齢を入力してください")
        @Size(max = 3, message = "*年齢は3桁以内の数字を入力してください")
        @Pattern(regexp = "[1-9][\\d]{0,2}", message = "*年齢は3桁以内の数字を入力してください、先頭の「0」を省略してください")
        String age,

        @NotBlank(message = "*電話番号を入力してください")
        @Pattern(regexp = "[\\d]{7}", message = "*電話番号は7桁の数字を入れてください")
        String phone
        ) {
		
	public HashMap<String, String> getInsertInfoMap() {
		HashMap<String, String> infoMap = new HashMap<>();
		
		infoMap.put("名前", name);
		infoMap.put("性別", sex);
		infoMap.put("年齢", age);
		infoMap.put("住所", address);
		infoMap.put("電話", phone);

		return infoMap;
	}
	
}



