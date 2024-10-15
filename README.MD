# 1: Tổng kết về mô hình MVC

- Các thành phần:
  - **MODEL:** code tại folder domain -> quản lý đối tượng, tác nhân tác động vào hệ thống (tables lưu trong DB)
  - **VIEW:** là các file html, jsp,... tạo giao diện cho người dùng thấy
  - **CONTROLLER:** Điều hướng hoạt động

# 2: DTO Design Pattern DTO (Data transfer object) 
- Là cách chúng ta biến đổi object này sang object khác. 
- *Ví dụ:* từ cát (sand) -> chúng ta biến đổi thành “thủy tinh” (transfer ở đây có nghĩa “biến đổi hình thù/định dạng”) 
- Transfer data (giống việc copy data từ usb vào máy tính) 
- Đổi với lập trình, chúng ta cần DTO để biến đổi class này thành class khác. 
- **Mục đích:** tăng thêm/hoặc giảm bớt các thuộc tính của class 
- **Ứng dụng:** 
- *Ví dụ:* tại server, chúng ta thao tác với User object -> có thông tin password 
Tuy nhiên, trước khi ném data về client, chúng ta “nên dấu đi/chém bớt đi” trường password -> đây chính là lúc DTO ra tay.

# 3: Luồng chạy của Spring Security
- **Bước 1:** Truy cập page Login, và nhấn nút submit.
  + Các thông tin gửi lên server bao gồm các fields sau:
    - username : đây là tên đăng nhập (có thể là email, số điện thoại, cccd...).
    - password : mật khẩu của user (plain password)
- **Bước 2:** Spring Security chạy Filter để lọc request
![Preview](https://github.com/nguyendat0908/Project-Java-MVC/blob/d45af1918a4e919cf3501a726a7d604a884f4266/src/main/webapp/resources/images/Screenshot%202024-08-28%20004319.png)
*Sử dụng UserDetailsService để lấy thông tin user:*
![Preview](https://github.com/nguyendat0908/Project-Java-MVC/blob/d45af1918a4e919cf3501a726a7d604a884f4266/src/main/webapp/resources/images/Screenshot%202024-08-28%20004326.png)
- **Bước 3:** Nạp user vào Context
![Preview](https://github.com/nguyendat0908/Project-Java-MVC/blob/d45af1918a4e919cf3501a726a7d604a884f4266/src/main/webapp/resources/images/Screenshot%202024-08-28%20004333.png)

# 4: Tại sao phải phân trang dữ liệu (Pagination) ?
- Vấn đề tồn đọng: lấy tất cả dữ liệu (Paginate)
- Nếu dữ liệu nhỏ (vài chục, vài trăm rows), không vấn đề gì? Tuy nhiên, vài ngàn, vài trăm ngàn, vài triệu ... sẽ là vấn đề
- Tại sao? Lấy càng nhiều data, càng tốn nhiều băng thông (tốc dộ truyền tải của mạng internet) và thời gian chờ đợi càng lâu, làm giảm trải nghiệm của người dùng.
- **Giari pháp đề ra:**
- Chỉ lấy số lượng data vừa đủ. Câu chuyện tương tự:
- Muốn download file nhanh -> tải file nhẹ thôi (file càng nặng, tải càng lâu, thời gian chờ đợi càng lớn)
- Muốn chờ đợi ít -> lấy ít data thôi nhé (và chỉ lấy data cần thiết, không dư thừa)

# 5: Quy trình code một Website với Spring
- **Bước 1:** Tạo dự án Spring với Spring Boot
- Truy cập: https://start.spring.io/
-> Cần lưu ý về version Java cũng như version của Spring Boot
- **Bước 2:** Thêm dependency
- Các thư viện cơ bản:
+ spring-boot-starter-web
+ spring-boot-devtools
- **Bước 3:** Tiến trình code dự án
Tổ chức code theo mô hình MVC và các cấu trúc thư mục.
Cấu hình Spring-security
- *Bước 3.1:* Làm tính năng CRUD users để có tài khoản đăng nhập hệ thống.
- Sử dụng Spring-security để hash password
- Tạo base các tính năng cơ bản của dự án
- *Bước 3.2:* Cấu hình Spring Session
- Làm tính năng Login/register cũng như cấu hình Security để truy cập website
-> Lưu ý: với method post cần csrf token. Nếu bạn không muốn truyền token tại form, có thể disable nó đi
- **Bước 4:** Xử lý các tính năng trong dự án của bạn
- Thực hành CRUD


