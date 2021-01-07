//package JavaII;
//
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//
//public class LoggerDemo {
//    private  static Logger logger = LogManager.getLogger("LoggerDemo.Class");
//    public void performLogging() {
//        logger.debug("This is a debug message");
//        logger.info("This is an info message");
//        logger.warn("this is warn message");
//        logger.error("this is an error message");
//        logger.fatal("This is a fatal message");
//    }
//
//    public void devide(int a,int b) {
//        try {
//            int x =a/b;
//        }catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//    }
//    public static void main(String[] args) {
//        LoggerDemo logger = new LoggerDemo();
//        logger.performLogging();
//        logger.devide(10,5);
//    }
//}
