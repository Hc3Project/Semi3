package com.kh.semi.common;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollaborativeFiltering {

	public HashMap<Integer, Double> cfCalc(int[][] itemMatrix, int userNum) {
		// 예측값을 저장할 배열 생성
		HashMap<Integer, Double> hMap = new HashMap<Integer, Double>();
//		Double[] estArr = new Double[itemMatrix[0].length];
		
		// 평가 항목에 대한 반복
		for(int i=0; i<itemMatrix[0].length; i++) {
			// 평점이 존재한다면 다음 평가 항목으로 넘어간다.
			if(itemMatrix[userNum][i]!=0) continue;
			
			// 평점이 존재하지 않는다면 예측을 시작한다.
			double targetMean = mean(itemMatrix, userNum, 0);
			double denominator = 0;
			double numerator = 0;
			double estimate = 0;
			
			// 타평가자에 대한 반복
			for(int j=0; j<itemMatrix.length; j++) {
				// 자기상관계수는 1 이므로 무시한다.
				if(j == userNum) continue;
				
				int x = 0;
				int x2 = 0;
				int y = 0;
				int y2 = 0;
				int xy = 0;
				double cnt = 0;
				double corr = 0;
				
				// 타겟과 타평가자와의 비교를 위한 반복
				for(int k=1; k<itemMatrix[j].length; k++) {
					// 추정하려는 유저와 이웃하는 유저의 평가 항목이 서로 존재한다면
					if(itemMatrix[userNum][k] != 0 && itemMatrix[j][k] != 0) {
						x += itemMatrix[userNum][k];
						x2 += (int)Math.pow(itemMatrix[userNum][k], 2);
						y += itemMatrix[j][k];
						y2 += (int)Math.pow(itemMatrix[j][k], 2);
						xy += itemMatrix[userNum][k] * itemMatrix[j][k];
						cnt++;
					}
				}
				double devX = deviation(x, x2, cnt);
				double devY = deviation(y, y2, cnt);
				double cov = covariance(x, y, xy, cnt);
				corr = cov / (devX * devY);
				if(!Double.isNaN(corr)) {
					denominator += (itemMatrix[j][i] - x/cnt) * corr;
					numerator += Math.abs(corr);
				}
			}
			estimate = targetMean + denominator / numerator;
//			estArr[i] = estimate;
			hMap.put(i, estimate);
		}
//		return estArr;
		return (HashMap<Integer, Double>) sortByValue(hMap, true);
	}
	
	public double mean(int[][] arr, int user, int exIdx) {
		double sum = 0;
		int cnt = 0;
		
		for(int i=1; i<arr[user].length; i++){
			if(arr[user][i] == 0 || i == exIdx) continue;
			sum += arr[user][i];
			cnt++;
		}
		return sum/cnt;
	}
	
	public double deviation(int x, int x2, double n) {
		double pre = x2 - Math.pow(x, 2) / n;
		return Math.sqrt(pre);
	}
	
	public double covariance(int x, int y, int xy, double n) {
		double pre = xy - x*y/n;
		return pre;
	}
	
	// hashmap sorting
	public static Map<Integer, Double> sortByValue(final Map map, boolean isASC) {
		List list = new LinkedList(map.entrySet());
		
	    Collections.sort(list, new Comparator() {
	        public int compare(Object o1, Object o2) {
	            return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());          
	        }
	    });

	    if(isASC) {
			Collections.reverse(list);
		}
	    
	    HashMap sortedHashMap = new LinkedHashMap();
	    
	    for (Iterator it = list.iterator(); it.hasNext();) {
	        Map.Entry entry = (Map.Entry) it.next();
	        sortedHashMap.put(entry.getKey(), entry.getValue());
	    } 
	    
	    return sortedHashMap;
	}
	
}
