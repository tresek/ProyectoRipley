package utils;

import java.util.List;

public class UtilTest {
	
	public Integer getIdExcel(String searchName, List<List<String>> excel ) {
		int cont = 0;
		int result = 0;
		for (List<String> fila : excel) {
			cont++;
			for (String id : fila) {
				if (id.equalsIgnoreCase(searchName)) {
					result = cont;
				}
			}
		}
		return result;
	}
}
