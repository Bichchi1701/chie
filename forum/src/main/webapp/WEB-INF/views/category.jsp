<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%
	//String contextPath =pageContext.getRequest().getServletContext();
String contextPath = request.getContextPath();
%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
.u_image {
	width: 200px;
	height: 150px;
	background: url(<%=contextPath%>/resources/images/avatar.png) no-repeat;
	border-radius: 3px;
	float: left;
	position: relative;
	overflow: hidden;
	margin-right: 40px;
}
</style>

</head>

<body>
	<div class="box-bg">
		<div class="upload_form">
			<h1 class="title3 bold text-center up-title">UPLOAD CODE CHIA SẺ
				& KIẾM TIỀN CÙNG SHARECODE.VN</h1>
			<div class="up-note hidden-xs">
				<!--  
                <div class="col-md-6 up-left"> 
                    <div class="title3 orange">Lợi ích Sharecode.vn đem lại</div>
                 
                    <ul class="introduce-list">
                        <li>Tiếp cận <span class="green">trăm nghìn khách hàng</span> tiềm năng mỗi ngày</li>
                        <li>Code được marketting đưa lên <span class="green">top 5 google</span></li>
                        <li>Hưởng <span class="green">70% doanh thu</span> trên mỗi code được bán</li>
                        <li>Bạn <span class="green">tự đặt phí</span> cho source code của mình</li>
                    </ul>
                </div>
              
                <div class="col-md-6 up-right">
                    <div class="title3 orange">Mẹo giúp bạn tăng doanh thu</div>
                    <ul class="introduce-list">
                        <li><a href="https://sharecode.vn/cau-hoi/meo-giup-ban-tang-doanh-thu-ban-source-code-9.htm#meo-nhap-thong-tin">Cách nhập thông tin đầy đủ, rõ ràng và hữu ích</a></li>
                        <li><a href="https://sharecode.vn/cau-hoi/meo-giup-ban-tang-doanh-thu-ban-source-code-9.htm#meo-gia-hop-ly">Đưa ra mức phí hợp lý và có sức thu hút</a></li>
					</ul>
				</div>
				  -->
				<form id="contactForm" action="<c:url value ="/insertsource"/>" method="POST">
					style="text-align: center;">
					<div class="up-box">
						<div id="mainbody_contentbody_contentpage_panDefaultButton"
							onkeypress="javascript:return WebForm_FireDefaultButton(event, &#39;mainbody_contentbody_contentpage_btnUpload&#39;)">

							<div class="form-horizontal">
								<div class="form-group"></div>
						
								<div class="form-group">
									<label class="col-md-2 control-label bold">Tiêu đề code
										<span class="text-error">*</span>
									</label>
									<div class="col-md-7">
										<input name="sourcename" type="text" maxlength="200"
											id="mainbody_contentbody_contentpage_txtTitle"
											class="form-control" onblur="ValidateTitle()"
											placeholder="Tối thiểu 20 kí tự" /> <span
											class="glyphicon glyphicon-ok form-control-feedback success-ic"
											aria-hidden="true" id="successTitle"></span>
									</div>
									<div class="col-md-3 note-col">
										<div class="form-control-static">
											<span id="title_error" class="text-error "></span> <span
												class="text-nowrap title5">Quyết định 80% SEO <span
												data-toggle="tooltip" data-placement="top"
												title="Tiêu đề tối thiểu 20 kí tự, Tiêu đề cần chứa 'Từ khóa' trọng tâm, tiêu đề càng hấp dẫn sẽ thu hút nhiều lượt xem."><i
													class="fa fa-info-circle" aria-hidden="true"></i></span></span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label bold">Danh mục <span
										class="text-error">*</span></label>
									<div class="col-md-4">
										<select name="ctgname"
											name="ctl00$ctl00$ctl00$mainbody$contentbody$contentpage$ddlCategoryLang"
											id="mainbody_contentbody_contentpage_ddlCategoryLang"
											class="form-control" onblur="ValidateCate()"
											onchange="ValidateCate()">
											<option value="">--Chọn danh mục--</option>
											<c:forEach var="category" items="${listCategory}">
												<option>${category.getCtgname()}</option>
											</c:forEach>
										</select> <span
											class="glyphicon glyphicon-ok form-control-feedback success-ic3"
											aria-hidden="true" id="successCate"></span>

									</div>
									<div class="col-md-6">
										<div class="form-control-static">
											<span id="lang_error" class="text-error">&nbsp;</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label bold">Mô tả ngắn <span
										class="text-error">*</span></label>
									<div class="col-md-7">
										<textarea name="title" rows="2" cols="20"
											id="mainbody_contentbody_contentpage_txtSubTitle"
											class="form-control up-textarea" onblur="ValidateSub()"
											placeholder="Tối thiểu 70 kí tự" maxlength="200"
											style="height: 60px;">
					</textarea>
										<span
											class="glyphicon glyphicon-ok form-control-feedback success-ic3"
											aria-hidden="true" id="successSub"></span>
									</div>
									<div class="col-md-3 note-col">
										<span id="subdetail_error" class="text-error"></span> <span
											class="text-nowrap title5">Tối ưu từ 70 - 200 kí tự <span
											data-toggle="tooltip" data-placement="top"
											title="Để có thứ hạng cao trên kết quả tìm kiếm bạn cần viết mô tả hấp dẫn về code, chứa từ khóa, những ưu điểm và tính năng...để thu hút người mua"><i
												class="fa fa-info-circle" aria-hidden="true"></i></span></span>&nbsp; <span
											class="text-nowrap orange"><b id="lblcountSubTitle">0</b>
											Kí tự</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label bold">Link
										download <span class="text-error">*</span>
									</label>
									<div class="col-md-7">
										<input type="file" name="size"> <span
											class="glyphicon glyphicon-ok form-control-feedback success-ic"
											aria-hidden="true" id="successLink"></span>
									</div>
									<div class="col-md-3">
										<span id="link_error" class="text-error"></span>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label bold">Đặt phí tải</label>
									<div class="col-md-10">
										<div class="btn-group" data-toggle="buttons">
											<label class="btn btn-warning active" id="lblCheckFree">
												<input type="radio" name="price" id="idFree" value="Free"
												checked> Miễn phí (0 Xu)
											</label> <label class="btn btn-warning" id="lblCheckCode"> <input
												type="radio" name="price" id="idCode" value="Code">
												Tham khảo (2Xu - 99Xu)
											</label> <label class="btn btn-warning" id="lblCheckCodeOK">
												<input type="radio" name="price" id="idCodeOK"
												value="CodeOK"> Chất lượng (>= 100 Xu)
											</label>
										</div>
									</div>
								</div>
								<div class="form-group" id="boxPrice">
									<div class="col-sm-6 col-md-offset-2 col-md-4">
										<div class="input-group">
											<div class="input-group-btn">
												<button type="button"
													class="btn btn-default dropdown-toggle up-dropdown"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													Chọn <span class="caret"></span>
												</button>
												<ul class="dropdown-menu dropdown-menu-left">
													<li id="li5" name="price">5 Xu</li>
													<li id="li10" name="price">10 Xu</li>
													<li id="li15" name="price">15 Xu</li>
													<li id="li20" name="price">20 Xu</li>
													<li id="li40" name="price">40 Xu</li>
													<li id="li80" name="price">80 Xu</li>
													<li role="separator" class="divider"></li>
													<li id="li100" name="price">100 Xu</li>
													<li id="li150" name="price">150 Xu</li>
													<li id="li240" name="price">240 Xu</li>
													<li id="li400" name="price">400 Xu</li>
												</ul>

											</div>
											<input
												name="ctl00$ctl00$ctl00$mainbody$contentbody$contentpage$txtPriceOther"
												type="text" maxlength="4"
												id="mainbody_contentbody_contentpage_txtPriceOther"
												class="bold form-control" onblur="ValidatePrice()"
												onkeypress="CheckNumeric(event);" onkeyup="ChangPrice();"
												placeholder="Tự nhập phí tải" /> <span
												class="glyphicon glyphicon-ok form-control-feedback success-ic"
												aria-hidden="true" id="successPrice" style="right: 60px;"></span>
											<span class="input-group-addon">Xu <span
												data-toggle="tooltip" data-placement="top"
												title="(1 Xu = 1.000 đ) Bạn có thể đặt phí tải tùy ý hoặc chia sẻ miễn phí 0 Xu, Khi code đã được duyệt nếu bạn GIẢM PHÍ TẢI phí tải sẽ được cập nhật ngay nhưng nếu TĂNG GIÁ thì cần chờ BQT kiểm duyệt giá đó! Nếu mức giá >= 100 Xu thì bạn cần cam kết HỖ TRỢ khi người mua liên hệ."><i
													class="fa fa-info-circle" aria-hidden="true"></i></span></span>
										</div>
									</div>
									<div class="col-sm-6 col-md-3">
										<div class="checkbox" id="boxCheck">
											<label class="orange"> <input id="chkCamKet"
												onchange="ValidatePrice()" value="1" type="checkbox" /> Cam
												kết hỗ trợ người mua
											</label>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-control-static">
											<span id="price_error" class="text-error">&nbsp;</span>
										</div>
									</div>
								</div>
								<!--  
                        <div class="form-group">
                            <label class="col-md-2 control-label bold">Hình ảnh về code</label>
                            <div class="col-md-7">
                                <div class="upload_file">
                                    <div class="f_control">
                                        <div class="f_upload_file">
                                            Thêm ảnh...
                                    <input type="file" multiple="multiple" name="ctl00$ctl00$ctl00$mainbody$contentbody$contentpage$FileUpload2" id="mainbody_contentbody_contentpage_FileUpload2" class="upload" accept="image/gif, image/jpeg, image/png" />
                                        </div>
                                        <div class="mess alignleft" id="countFiles">
                                        </div>
                                        
                                        <div id="errFileMax2" class="text-error clear"></div>
                                    </div>
                                    <span id="mainbody_contentbody_contentpage_lblListImage"></span>
                                    <div id="mainbody_contentbody_contentpage_upPannel">
		
                                            
                                            <div id="mainbody_contentbody_contentpage_TotalImage" class="f_total">Tối đa <b>10</b> ảnh, Dung lượng tối đa <b>2 Mb</b> 1 ảnh</div>
                                        
	</div>
                                </div>
                            </div>
                            <div class="col-md-3 hidden-xs">
                                <div class="up-idea">
                                    Hoàn thành đầy đủ thông tin giúp code của bạn được nhiều người biết đến và  có thứ hạng cao trên kết quả tìm kiếm
                                </div>
                            </div>
                        </div>
                         -->
								<div class="form-group">
									<label class="col-md-2 control-label bold">Mô tả chi
										tiết <span class="text-error">*</span>
									</label>
									<div class="col-md-10" id="editorDetail">
										<textarea name="contentdetails" rows="2" cols="20"
											id="mainbody_contentbody_contentpage_ckDetail"
											style="height: 200px;">
</textarea>
										<span
											class="glyphicon glyphicon-ok form-control-feedback success-ic"
											aria-hidden="true" id="successDetail"></span>
									</div>
								</div>
								<!--  
                        <div class="form-group">
                            <label class="col-md-2 control-label bold">Hướng dẫn cài đặt</label>
                            <div class="col-md-10">
                                <textarea name="ctl00$ctl00$ctl00$mainbody$contentbody$contentpage$ckConfig" rows="2" cols="20" id="mainbody_contentbody_contentpage_ckConfig" style="height:200px;">
								</textarea>
                            </div>
                        </div>
                        -->
								<div class="form-group">
									<label class="col-md-2 control-label bold">Từ khóa <span
										class="text-error">*</span></label>
									<div class="col-md-7">
										<textarea name="tagname"
											id="mainbody_contentbody_contentpage_txtTag"
											onblur="ValidateTag()" class="form-control"></textarea>
										<span
											class="glyphicon glyphicon-ok form-control-feedback success-ic"
											aria-hidden="true" id="successTag"></span>
									</div>
									<div class="col-md-3 note-col">
										<div class="form-control-static">
											<span id="tag_error" class="text-error">&nbsp;</span> <span
												class="text-nowrap">Tối đa 6 từ khóa </span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-2 col-md-10">
										<div id="listSuggest"></div>
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-offset-2 col-md-10">
										<div class="checkbox">
											<label id="chkRequireBox" style="border-radius: 4px;">
												<input
												name="ctl00$ctl00$ctl00$mainbody$contentbody$contentpage$chkRequirement"
												type="checkbox"
												id="mainbody_contentbody_contentpage_chkRequirement"
												onchange="ValidateCheck()" value="1" /> <a
												href="/quy-dinh-chung.htm" target="_blank" class="aorange"
												title="Xem thêm điều khoản sử dụng">Tôi đã đọc và đồng ý
													với các điều khoản của Sharecode.vn&nbsp;</a>
											</label> &nbsp;&nbsp;<span id="check_error" class="text-error"
												style="line-height: 20px;">&nbsp;</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-2 col-md-10">
										<span id="upload_error" class="text-error">&nbsp;</span>
									</div>
								</div>
								<br />
								<div class="form-group">
									<div class="col-md-offset-2 col-md-10 line-h">
										<a onclick=" return ValidateUpload();"
											id="mainbody_contentbody_contentpage_btnUpload"
											class="button-orange"
											href="javascript:__doPostBack(&#39;ctl00$ctl00$ctl00$mainbody$contentbody$contentpage$btnUpload&#39;,&#39;&#39;)"><i
											class="fa fa-cloud-upload fa-lg" aria-hidden="true"></i>&nbsp;<span
											id="mainbody_contentbody_contentpage_lblButton">TẢI
												LÊN NGAY</span></a> &nbsp;&nbsp; <span class="text-error text-nowrap"
											style="line-height: 40px;">(*) Là các trường bắt buộc
											nhập nội dung</span>
									</div>
								</div>
								<div class="col-md-10" style="margin-left: 300px">

									<h2>UPLOAD CODE CHIA SẺ & KIẾM TIỀN CÙNG 4TCNCODE.VN</h2>
									<textarea id="basic-conf" name="content">Hello, World!</textarea>
									<div>
										<button id="submit" type="submit" value="add" name="action"
											style="color: #d65106; background-color: transparent; background-image: none; border-color: #d65106 !important; font-weight: 600; border: 2px solid transparent; padding: 12px 30px; font-size: 16px; line-height: 1.5; border-radius: .1875rem;">
											Book Table</button>

										<div></div>
									</div>

								</div>
							</div>

						</div>

					</div>
				</form>

			</div>
		</div>

	</div>



	<script
		src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js"
		referrerpolicy="origin"></script>
	<script>
tinymce.init({
	  selector: '#basic-conf',
	  width: 500,
	  height: 500,
	  plugins: [
	    'advlist autolink link image lists charmap print preview hr anchor pagebreak',
	    'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
	    'table emoticons template paste help'
	  ],
	  toolbar: 'undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | ' +
	    'bullist numlist outdent indent | link image | print preview media fullpage | ' +
	    'forecolor backcolor emoticons | help',
	  menu: {
	    favs: {title: 'My Favorites', items: 'code visualaid | searchreplace | emoticons'}
	  },
	  menubar: 'favs file edit view insert format tools table help',
	  content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:14px }'
	});


</script>
</body>


</html>