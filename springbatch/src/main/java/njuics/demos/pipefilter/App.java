package njuics.demos.pipefilter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        String[] springConfig = { "spring/batch/jobs/job-hello-world.xml" };

        JobLauncher jobLauncher;
        Job job;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig)) {
            jobLauncher = (JobLauncher) context.getBean("jobLauncher");
            job = (Job) context.getBean("helloWorldJob");
        }

        try {

            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        System.out.println("Done");

    }
}
