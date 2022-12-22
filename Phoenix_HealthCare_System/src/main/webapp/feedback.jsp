<%@ page import="Connection_Provider.Message" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Rating Sheet</title>
    <link rel="stylesheet" href="css/style2.css" />
    <script src="https://kit.fontawesome.com/64d58efce2.js"crossorigin="anonymous"></script>
<title>Rating Sheet</title>
</head>
<body>
 <div class="container">
      <span class="big-circle"></span>
      <img src="img/shape.png" class="square" alt="" />
      <div class="form">
        <div class="contact-info">
          <h3 class="title">Let's get in touch</h3>
          <p class="text">
           If you have any question or queries a member of staff will always be happy to help.
           Feel free to contact us by telephone or email and we will be sure to get back to you 
          as soon as possible.
          </p>

          <div class="info">
            <div class="information">
              <img src="img/location.png" class="icon" alt="" />
              <p>65 Cherry Drive Uniondale, NG 441401</p>
            </div>
            <div class="information">
              <img src="img/email.png" class="icon" alt="" />
              <p>phoenix@outlook.com </p>
            </div>
            <div class="information">
              <img src="img/phone.png" class="icon" alt="" />
              <p>+123-456-7890</p>
            </div>
          </div>

          <div class="social-media">
            <p>Connect with us :</p>
            <div class="social-icons">
              <a href="#">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="#">
                <i class="fab fa-twitter"></i>
              </a>
              <a href="#">
                <i class="fab fa-instagram"></i>
              </a>
              <a href="#">
                <i class="fab fa-linkedin-in"></i>
              </a>
            </div>
          </div>
        </div>

        <div class="contact-form">
          <span class="circle one"></span>
          <span class="circle two"></span>

          <form action="feedback" method="post" >
            <h3 class="title">Rating Sheet</h3>
             <% Message m = (Message)session.getAttribute("msg");
          if(m!=null){
          %>
          <div class="alert alert-dark" role="alert">
               <%= m.getContent() %>
         </div>
          <%
          session.removeAttribute("msg");
          }
          %>
            <div class="input-container">
              <input type="text" name="username" class="input" />
              <label for="">Username</label>
              <span>Username</span>
            </div>
            <div class="input-container">
              <input type="email" name="email" class="input" />
              <label for="">Email</label>
              <span>Email</span>
            </div>
            <div class="input-container">
              <input type="text" name="phone" class="input" />
              <label for="">Phone</label>
              <span>Phone</span>
            </div>
            <div class="input-container textarea">
              <textarea name="message" class="input"></textarea>
              <label for="">Your Feedback</label>
              <span>Message</span>
            </div>
            <input type="submit" value="Send" class="btn" />
          </form>
        </div>
      </div>
    </div>

    <script src="js/app2.js"></script>
</body>
</html>