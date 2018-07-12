package servlet;

import entity.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/13.
 */
@WebServlet(name = "AddVideoServlet")
public class AddVideoServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Video video = new Video();

        String filename = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置上传文件的大小限制为1M
            factory.setSizeThreshold(64 * 4096 * 4096);

            List items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {

                    // 根据时间戳创建头像文件
                    filename = System.currentTimeMillis() + ".mp4";

                    //通过getRealPath获取上传文件夹，如果项目在e:/project/j2ee/web,那么就会自动获取到 e:/project/j2ee/web/uploaded
                    String photoFolder = request.getServletContext().getRealPath("res/video");

                    File f = new File(photoFolder, filename);
                    f.getParentFile().mkdirs();

                    // 通过item.getInputStream()获取浏览器上传的文件的输入流
                    InputStream is = item.getInputStream();

                    // 复制文件
                    FileOutputStream fos = new FileOutputStream(f);
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.close();

                } else {
                    String name = item.getFieldName();
                    String value = item.getString();
                    value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                    if (name.equals("pointId"))
                        video.setPointId(Integer.parseInt(value));
                }

            }
            video.setPath(filename);
            courseService.addVideo(video);

            Point point = courseService.getPoint(video.getPointId());
            request.setAttribute("point", point);

            List<Video> videoList = courseService.getVideoByPoint(video.getPointId());
            request.setAttribute("videoList",videoList);

            int userId = user.getId();
            CourseDetails courseDetails = (CourseDetails) request.getSession().getAttribute("courseDetail");
            String userstate = courseService.getUserAndCourseState(userId, courseDetails.getCourse().getId());
            request.setAttribute("userState", userstate);

            RequestDispatcher dispatcher = request.getRequestDispatcher("page/point.jsp");
            dispatcher.forward(request, response);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
