<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
	<title>Learing SpringBoot</title>
	<meta name="keywords" content="Learing SpringBoot">
	<meta name="description" content="Learing SpringBoot">
	<link rel="stylesheet" type="text/css" href="${appBase}/static/assets/css/bootstrap-lp.min.css?v=${version!''}">
	<link rel="stylesheet" type="text/css" href="${appBase}/static/landingpage/css/lp-all.min.css?v=${version!''}">
	<script type="text/javascript" src="${appBase}/static/assets/js/jquery.min.js?v=${version!''}"></script>
	<script type="text/javascript" src="${appBase}/static/assets/js/bootstrap.min.js?v=${version!''}"></script>
	<script type="text/javascript" src="${appBase}/static/assets/js/vue.min.js?v=${version!''}"></script>
	<script type="text/javascript" src="${appBase}/static/landingpage/js/lp-all.min.js?v=${version!''}"></script>
	<script type="text/javascript">
		var appBase = "${appBase}";
	</script>
</head>
<body>
<header class="navbar navbar-default banner-box">
	<img alt="SpringBoot" class="banner" src="${appBase}/static/landingpage/image/banner.jpg">
</header>
<section>
<div class="container form">
	<div class="row form-group">
		<div class="col-sm-12 col-xs-12">
			<div class="col-sm-3 col-xs-3">
				<img alt="SpringBoot" class="icon-link" src="${appBase}/static/landingpage/image/icon1.png">
				<span class="link-test">SpringBoot</span>
			</div>
			<div class="col-sm-3 col-xs-3">
				<img alt="SpringBoot" class="icon-link" src="${appBase}/static/landingpage/image/icon2.png">
				<span class="link-test">SpringBoot</span>
			</div>
			<div class="col-sm-3 col-xs-3">
				<img alt="SpringBoot" class="icon-link" src="${appBase}/static/landingpage/image/icon3.png">
				<span class="link-test">SpringBoot</span>
			</div>
			<div class="col-sm-3 col-xs-3">
				<img alt="SpringBoot" class="icon-link" src="${appBase}/static/landingpage/image/icon4.png">
				<span class="link-test">SpringBoot</span>
			</div>
		</div>
	</div>
	<div class="row form-group" id="cardNoArea">
		<div class="col-sm-12 col-xs-12">
	      <input type="text" maxlength="18" class="form-control custom-form-control"
	      	id="idCardNo" name="idCardNo" placeholder="请输入您的身份证号" required 
	      	v-on:blur="idCardNoBlur" v-on:input="idCardNoInput" v-model="value">
	      <span class="error-message"  v-bind:style="{display:show}">{{message}}</span>
		</div>
	</div>
	<div class="row form-group" id="phoneArea">
	    <div class="col-sm-12 col-xs-12">
	      <input type="text" maxlength="11" pattern="\d*" class="form-control custom-form-control"
	      	id="phone" name="phone" placeholder="请输入您的手机号码"
	      	v-on:blur="phoneBlur" v-on:input="phoneInput" v-model="value">
	      <span class="error-message" v-bind:style="{display:show}">{{message}}</span>
	    </div>
	</div>
	<div class="row form-group">
		<div class="col-sm-12 col-xs-12">
			<span class="captcha-test">点击立刻申请，学习<a id="btnTermsOfUse" data-target="#termsModal" data-toggle="modal">《SpringBoot》</a>。</span>
		</div>
	</div>
	<div class="row form-group" id="applyNowArea">
		<div class="col-sm-12 col-xs-12">
			<input type="button" value="立刻申请" id="applyNow" class="btn btn-danger disabled"
				v-on:click="clickApplyNow">
			<span class="apply-test">如果您有未完成的申请，<a id="loginURL">点击这里</a>继续申请。</span>
		</div>
	</div>
</div>
</section>
<footer>
	<div class="copyright">©2017 October</div>
	<p class="copyright-test">Learning SpringBoot</p>
</footer>
<#include "terms-dialog.ftl"/>
</body>
</html>