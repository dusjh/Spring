package polymorphism3;

public class BeanFactory {
	public Object getBean(String beanName) {
		Object bean = null;
		if("samsung".equals(beanName)) {
			bean = new SamsungTV();
		} else if("lg".equals(beanName)) {
			bean = new LgTV();
		}
		return bean;
	}
}
