package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AjaxStatusBean {
	
	
	public void test(){
		for (int i = 0; i < 999; i++) {
			for (int j = 0; j < 999; j++) {
				System.out.println(i);
			}
			
		}
	}
}
