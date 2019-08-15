package oop1314.lab07.examsample;

public interface Acceptor<T> {
	
	void accept(T newElement) throws ElementNotAcceptedException;
	void end() throws EndNotAcceptedException;
	
	public static class ElementNotAcceptedException extends Exception{
		private Object element;

		public ElementNotAcceptedException(Object element) {
			super();
			this.element = element;
		}

		public Object getElement() {
			return element;
		}
		
	}
	
	public static class EndNotAcceptedException extends Exception{}	

}
