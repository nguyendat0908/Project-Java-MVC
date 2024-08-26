#1: Tổng kết về mô hình MVC

- Các thành phần:
**MODEL:** code tại folder domain -> quản lý đối tượng, tác nhân tác động vào hệ thống (tables lưu trong DB)
**VIEW:** là các file html, jsp,... tạo giao diện cho người dùng thấy
**CONTROLLER:** Điều hướng hoạt động

# 2: DTO Design Pattern DTO (Data transfer object) 
- Là cách chúng ta biến đổi object này sang object khác. 
- *Ví dụ:* từ cát (sand) -> chúng ta biến đổi thành “thủy tinh” (transfer ở đây có nghĩa “biến đổi hình thù/định dạng”) 
- Transfer data (giống việc copy data từ usb vào máy tính) 
- Đổi với lập trình, chúng ta cần DTO để biến đổi class này thành class khác. 
- **Mục đích:** tăng thêm/hoặc giảm bớt các thuộc tính của class 
- **Ứng dụng:** 
- *Ví dụ:* tại server, chúng ta thao tác với User object -> có thông tin password 
Tuy nhiên, trước khi ném data về client, chúng ta “nên dấu đi/chém bớt đi” trường password -> đây chính là lúc DTO ra tay.



