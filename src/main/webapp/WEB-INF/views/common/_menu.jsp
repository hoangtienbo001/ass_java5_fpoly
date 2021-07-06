<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}/products">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Quản lý Admin </div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">
            
                       
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/products">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Quản lý Danh mục</span></a>
            </li>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
            <hr class="sidebar-divider">
                <a class="nav-link" href="${pageContext.request.contextPath}/products">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Quản lý Sản phẩm</span></a>
             </li>  
             
            <li class="nav-item">
            <hr class="sidebar-divider">
                <a class="nav-link" href="${pageContext.request.contextPath}/products">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Quản lý Tài khoản</span></a>
             </li>
             
            <li class="nav-item">
            <hr class="sidebar-divider">
                <a class="nav-link" href="${pageContext.request.contextPath}/products">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Thống kê</span></a>
             </li>
                    
            <hr class="sidebar-divider d-none d-md-block">

 

        </ul>
