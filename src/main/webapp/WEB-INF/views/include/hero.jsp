<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>모든 카테고리</span>
                        </div>
                        <ul>
							<li><a href="#">식품</a></li>
                            <li><a href="#">배변용품</a></li>
                            <li><a href="#">건강,미용</a></li>
                            <li><a href="#">일반용품</a></li>

                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                	<select class="hero__search__categories" name="전체">
						<option value="all">전체</option>
						<option value="F">식품</option>
						<option value="B">배변용품</option>
						<option value="H">건강,미용,목욕</option>
						<option value="J">용품</option>
					</select>
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <!-- <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>  -->
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                            <div class="hero__search__phone__icon">
                                <img src="${contextPath}/resources/bootstrap/img/basket.png">
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->