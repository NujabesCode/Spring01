package com.dongsung.ch02;
/*
 �ڹ��� ���÷���(Reflection)�� ���� ���� ���α׷��� Ŭ����, 
 �޼ҵ�, �ʵ� ���� ������ �������� �˻��ϰ� ������ �� �ֵ��� �ϴ� 
 ����̴�.
*/
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

/* ������MVC������ ��� �����ϴ��� ������ ���ؼ� �˾ƺ���.
�������� ���������� � ���� �ϱ淡 �Ű������� �����ֱ⸸ �ϸ� �˾Ƽ� ó���ϴ���
�ñ������ĵ�, �װ� �˾ƺ���.
������ �ҽ��� ���� ���� ReflectionAPI�� �Ű������� �̸��� �˾Ƴ����� �Ѵ�.
ReflectionAPI�� jdk1.8 ���ĺ��� �����ϴ�.
�ٵ� �������� jdk1.8 �������� �־���. �׶��� classfile�κ��� ���Դ�.
�׷��ٰ� ���и� �ϸ� classfile�� ���� �о �Ű������� �̸��� ���´�.
�츮�� ù��° ����� ���ؼ� �Ű������� �̸��� ���°Ŵ�.
*/

public class MethodInfo {
	public static void main(String[] args) throws Exception{
		
		//YoilTeller3 �� ���� YoilTellerMVC4�� �־��.
		
		//1.YoilTeller Ŭ������ ��ü�� ����
		Class ClassNew = Class.forName("com.dongsung.ch02.YoilProgramMVC4");
		Object obj = ClassNew.newInstance();
		
		//2. YoilProgram�� ��� �޼��� ������ �����ͼ� �迭�� ����.
		//3. �޼��尡 �������� �� �ֱ� ������, ��ȯ Ÿ���� �迭�� ����.
		Method[] methodArr = ClassNew.getDeclaredMethods();
		
		//4. �ݺ������� �޼��� �ϳ��� �о ���� ���.
		for(Method m : methodArr) {
			String name = m.getName(); // �޼����� �̸�
			Parameter[] paramArr = m.getParameters(); //�Ű����� ���
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType(); //�޼����� ��ȯŸ��
			
			//                                        ������ ���λ�, ���̻�
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) { //�ż����� �Ű������� ���������� �� �����ϱ� �ݺ��� ����.
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}

/*
  1. �Ʒ� �ܼ�â�� ���� �Ű����� �̸��� arg0�� arg1�� �Ǿ��ִ�.
  
  2. ���� ���� �ڷ��� �� ����  �Ű����� �̸��� request�� response�� �Ǿ��ִ�.
  
  3. �ٵ� ��  �̸��� arg0 arg1�� �ٲ������?
  
  4. �� ������ YoilTeller�� ������ �Ҷ�, �����Ϸ��� �Ű����� Ÿ���� �߿��ѵ�
     �Ű����� �̸��� ���� �߿��ϰ� ���� ���Ѵ� �׷��� ������ �ɶ� �Ű����� �̸���
     �������� �ʴ´�
  5. �ٵ� �츮�� �Ű������� �̸��� �ʿ��ϴ�. �׷��� �Ű����� �̸��� �����Ϸ���
  
  6. ������ �ɼǿ� parameters��� ������ �ɼ��� ��ߵȴ�.
     java c - parameters
              �Ű����� �̸� ���� �ɼ� 
              
  7. Window - > Prefernces -> compil �˻� -> java -> Compiler
     -> �� �Ʒ� store information about method parameters(usable via reflextion)
              
  8. �ڹ� 1.8 �̻� �������� �ٲ�� Ȱ��ȭ ��. 
  
  9-1. pom.xml <java-version>11</java-version> �ڹ� ���� 11�� ����
  9-2. maven-compiler-plugin
  
  
  10. pom.xml ���� ���� �������� ������Ʈ ��Ŭ�� Maven -> Update Project
  
  11. ���� �츮�� ���� MVC������Ʈ�� ���̺쿡�� ������ ��. pom.xml�� ���̺� ���� ������.
              
  12. �Ű����� �̸��� ��� ���� ����� �ΰ����� �ִµ�
  
       1.Reflection API�� �̿��ϴ� ��� : parameters �ɼ��� �ְ� ���;� ��
       2.class ������ ���� �д� ���
 
  13. 2�� ����� window -> show View -> other -> navi�˻�- >navigator ���� -> �׺�����ʹ� Ž���� ������.
  
  14. src�� �ְ� target�� �ִµ� src���� *.java ������ �ְ� target���� *.class ������ �ִ�
  
  15. yoilTeller3.class ������ ���� �ؼ��ؼ� ���´�.
  
  16. ���� class ������ ���̳ʸ� �����̶� ���� ��ư� �Ǿ��ִ�.
  
  17. �� �������� Local Variable table:�� �ִµ� �ű⿡ request�� response�� �ִ�.
  
  18. �������� ���� �о �˾Ƴ��°Ŵ�.
  
  14.  Class clazz = Class.forName("com.dongsung.ch02.YoilTellerMVC");
       ���� �� �Ű����� �� ������ Ȯ��.
 */             



/* [������]
java.lang.String main(java.lang.String year, java.lang.String month, java.lang.String day, org.springframework.ui.Model model)
boolean isValid(int year, int month, int day)
*/