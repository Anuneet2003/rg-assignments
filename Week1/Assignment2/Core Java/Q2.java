// 2) What will be the output for following code?
// class Super
// {
// static void show()
// {
// System.out.println("super class show method");
// }
// static class StaticMethods
// {
// void show()
// {
// System.out.println("sub class show method");
// }
// }
// public static void main(String[]args)
// {
// Super.show();
// new Super.StaticMethods().show();
// }
// }




// Output:
// super class show method
// sub class show method
