<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="ie lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="ie lt-ie9"> <![endif]-->
<!--[if gt IE 8]> <html class="ie gt-ie8"> <![endif]-->
<!--[if !IE]><!--><html><!-- <![endif]-->
<head>
	<title>Zurbaran</title>

	<!-- Meta -->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />


	<!-- JQuery -->
	<script src="resources/js/templateClases/plugins/system/jquery.min.js"></script>

	<!-- JQueryUI -->
	<script src="resources/js/templateClases/plugins/system/jquery-ui/js/jquery-ui-1.9.2.custom.min.js"></script>
	<!-- Bootstrap -->
	<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" />
	<link href="resources/bootstrap/css/responsive.css" rel="stylesheet" />

	<!-- Glyphicons Font Icons -->
	<link href="resources/css/glyphicons.css" rel="stylesheet" />

	<!-- Uniform Pretty Checkboxes -->
	<link href="resources/js/templateClases/plugins/forms/pixelmatrix-uniform/css/uniform.default.css" rel="stylesheet" />

	<!-- PrettyPhoto -->
    <link href="resources/js/templateClases/plugins/gallery/prettyphoto/css/prettyPhoto.css" rel="stylesheet" />

	<!-- Bootstrap Extended -->
	<link href="resources/bootstrap/extend/jasny-bootstrap/css/jasny-bootstrap.min.css" rel="stylesheet">
	<link href="resources/bootstrap/extend/jasny-bootstrap/css/jasny-bootstrap-responsive.min.css" rel="stylesheet">
	<link href="resources/bootstrap/extend/bootstrap-wysihtml5/css/bootstrap-wysihtml5-0.0.2.css" rel="stylesheet">
	<link href="resources/bootstrap/extend/bootstrap-select/bootstrap-select.css" rel="stylesheet" />
	<link href="resources/bootstrap/extend/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css" rel="stylesheet" />

	<!-- Select2 Plugin -->
	<link href="resources/js/templateClases/plugins/forms/select2/select2.css" rel="stylesheet" />

	<!-- DateTimePicker Plugin -->
	<link href="resources/js/templateClases/plugins/forms/bootstrap-datetimepicker/css/datetimepicker.css" rel="stylesheet" />

	<!-- JQueryUI -->
	<link href="resources/js/templateClases/plugins/system/jquery-ui/css/smoothness/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />

	<!-- MiniColors ColorPicker Plugin -->
	<link href="resources/js/templateClases/plugins/color/jquery-miniColors/jquery.miniColors.css" rel="stylesheet" />

	<!-- Notyfy Notifications Plugin -->
	<link href="resources/js/templateClases/plugins/notifications/notyfy/jquery.notyfy.css" rel="stylesheet" />
	<link href="resources/js/templateClases/plugins/notifications/notyfy/themes/default.css" rel="stylesheet" />

	<!-- Gritter Notifications Plugin -->
	<link href="resources/js/templateClases/plugins/notifications/Gritter/css/jquery.gritter.css" rel="stylesheet" />

	<!-- Easy-pie Plugin -->
	<link href="resources/js/templateClases/plugins/charts/easy-pie/jquery.easy-pie-chart.css" rel="stylesheet" />

	<!-- Google Code Prettify Plugin -->
	<link href="resources/js/templateClases/plugins/other/google-code-prettify/prettify.css" rel="stylesheet" />
	<script src="resources/js/templateClases/plugins/forms/jquery-validation/dist/jquery.validate.min.js"></script>
	

	<!-- Main Theme Stylesheet :: CSS -->
	<link href="resources/css/style-light.css?1369414384" rel="stylesheet" />


	<!-- LESS.js Library -->
	<script src="resources/js/templateClases/plugins/system/less.min.js"></script>
	<!-- DataTables Tables Plugin -->
	<script src="resources/js/templateClases/plugins/tables/DataTables/media/js/jquery.dataTables.min.js"></script>
	<script src="resources/js/templateClases/plugins/tables/DataTables/media/js/DT_bootstrap.js"></script>
	<script src="resources/js/templateClases/plugins/mootools-core-1.4.5-full-compat.js"></script>
	<script src="resources/js/uiClases/SideBarController.js"></script>
	<script src="resources/js/uiClases/TemplateManager.js"></script>
	<script src="resources/js/uiClases/Render.js"></script>
	<script src="resources/js/uiClases/Banco.js"></script>
	<script src="resources/js/uiClases/Entidad.js"></script>
	<script src="resources/js/uiClases/Cotizacion.js"></script>
	<script src="resources/js/uiClases/Cuenta.js"></script>
	<script src="resources/js/uiClases/TipoDocumento.js"></script>
	<script src="resources/js/uiClases/Moneda.js"></script>
	<script src="resources/js/uiClases/Concepto.js"></script>
	<script src="resources/js/uiClases/Administracion.js"></script>
	
	<script src="resources/js/uiClases/TipoEntidad.js"></script>
	<script src="resources/js/uiClases/RenderTranslator.js"></script>
	<script src="resources/js/uiClases/ServerManager.js"></script>
	<script>

  $( document ).ready(function() {
	sideBarController.bindMenuOptionsEvents();
  });
 </script>
	<!-- Main Theme Stylesheet :: CSS-->
	<link href="resources/css/style-light.css?1369414383" rel="stylesheet" />


	<!-- LESS.js Library-->
	<script src="resources/js/templateClases/plugins/system/less.min.js"></script>
</head>
<body class="">

		<!-- Main Container Fluid -->
	<div class="container-fluid fluid menu-left">

		<!-- Top navbar -->
		<div class="navbar main hidden-print">

			<!-- Brand -->
			<a href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light" class="appbrand pull-left"><span>Zurbaran <span>vBeta</span></span></a>

						<!-- Menu Toggle Button -->
			<button type="button" class="btn btn-navbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<!-- // Menu Toggle Button END -->

						<!-- Top Menu -->
			<ul class="topnav pull-left tn1">

								<!-- Themer -->
				<li class="hidden-phone">
					<a href="#" data-target="#themer" data-toggle="collapse" class="glyphicons eyedropper"><i></i><span>Themer</span></a>
				</li>
				<!-- // Themer END -->


			</ul>
			<!-- // Top Menu END -->


			<!-- Top Menu Right -->
			<ul class="topnav pull-right">

				<!-- Language menu -->
				<li class="hidden-phone" id="lang_nav">
					<a href="#" data-toggle="dropdown"><img src="resources/images/lang/en.png" alt="en" /></a>
			    	<ul class="dropdown-menu pull-left">
			      		<li class="active"><a href="?page=index&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light&amp;lang=en" title="English"><img src="resources/images/lang/en.png" alt="English"> English</a></li>
			      		<li><a href="?page=index&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light&amp;lang=ro" title="Romanian"><img src="resources/images/lang/ro.png" alt="Romanian"> Romanian</a></li>
			      		<li><a href="?page=index&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light&amp;lang=it" title="Italian"><img src="resources/images/lang/it.png" alt="Italian"> Italian</a></li>
			      		<li><a href="?page=index&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light&amp;lang=fr" title="French"><img src="resources/images/lang/fr.png" alt="French"> French</a></li>
			      		<li><a href="?page=index&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light&amp;lang=pl" title="Polish"><img src="resources/images/lang/pl.png" alt="Polish"> Polish</a></li>
			    	</ul>
				</li>
				<!-- // Language menu END -->

				<!-- Dropdown -->
				<li class="dropdown visible-abc">
					<a href="" data-toggle="dropdown" class="glyphicons cogwheel"><i></i>Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu pull-right">

						<li class="dropdown submenu">
                    		<a href="#" class="dropdown-toggle" data-toggle="dropdown">Level 2</a>
							<ul class="dropdown-menu submenu-show submenu-hide pull-left">
		                        <li class="dropdown submenu">
		                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Level 2.1</a>
									<ul class="dropdown-menu submenu-show submenu-hide pull-left">
										<li><a href="#">Level 2.1.1</a></li>
                                    	<li><a href="#">Level 2.1.2</a></li>
                                    	<li><a href="#">Level 2.1.3</a></li>
                                    	<li><a href="#">Level 2.1.4</a></li>
		                            </ul>
		                        </li>
		                        <li class="dropdown submenu">
		                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Level 2.2</a>
		                            <ul class="dropdown-menu submenu-show submenu-hide pull-left">
										<li><a href="#">Level 2.2.1</a></li>
		                                <li><a href="#">Level 2.2.2</a></li>
		                            </ul>
		                        </li>
		                    </ul>
		                </li>

		                <li><a href="">Some option</a></li>
						<li><a href="">Some other option</a></li>
						<li><a href="">Other option</a></li>

					</ul>
				</li>
				<!-- // Dropdown END -->

				<!-- Profile / Logout menu -->
				<li class="account">
										<a data-toggle="dropdown" href="my_account.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light" class="glyphicons logout lock"><span class="hidden-phone text">Alexis</span><i></i></a>
					<ul class="dropdown-menu pull-right">
						<li><a href="my_account.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light" class="glyphicons cogwheel">Configuraciones<i></i></a></li>
						<li class="highlight profile">
							<span>
								<span class="heading">Perfil <a href="my_account.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light" class="pull-right">edit</a></span>
								<span class="img"></span>
								<span class="details">
									<a href="my_account.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light">Mosaic Pro</a>
									contact@mosaicpro.biz
								</span>
								<span class="clearfix"></span>
							</span>
						</li>
						<li>
							<span>
								<a class="btn btn-default btn-mini pull-right" href="login.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light">Sign Out</a>
							</span>
						</li>
					</ul>
									</li>
				<!-- // Profile / Logout menu END -->

			</ul>
			<!-- // Top Menu Right END -->


		</div>
		<!-- Top navbar END -->

				<!-- Sidebar menu & content wrapper -->
		<div id="wrapper">

		<!-- Sidebar Menu -->
		<div id="menu" class="hidden-phone hidden-print">

			<!-- Scrollable menu wrapper with Maximum height -->
			<div class="slim-scroll" data-scroll-height="800px">

			<!-- Sidebar Profile -->
			<span class="profile">
				<a class="img" href="my_account.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><img src="http://dummyimage.com/51x51/232323/ffffff&amp;text=photo" alt="Mr. Awesome" /></a>
				<span>
					<strong>Bienvenido </strong>
					<a href="my_account.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light" class="glyphicons right_arrow">Alexis <i></i></a>
				</span>
			</span>
			<!-- // Sidebar Profile END -->

			<!-- Sidebar Mini Stats -->
			<div id="notif">
				<ul>
					<li><a href="" class="glyphicons envelope"><i></i> 5</a></li>
					<li><a href="" class="glyphicons shopping_cart"><i></i> 1</a></li>
					<li><a href="" class="glyphicons log_book"><i></i> 3</a></li>
					<li><a href="" class="glyphicons user_add"><i></i> 14</a></li>
				</ul>
			</div>
			<!-- // Sidebar Mini Stats END -->

			<!-- Regular Size Menu -->
			<ul>


								<!-- Menu Regular Item -->
				<li class="glyphicons display active"><a href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><i></i><span>Inicio</span></a></li>

				
				<!-- Landing Submenu Level 1 -->
				<li class="hasSubmenu">
					<a data-toggle="collapse" class="glyphicons notes" href="#menu_landing"><i></i><span>Gestion de Valores</span></a>
					<ul class="collapse" id="menu_landing">
						<li class=""><a href="landing_page_1.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><span>Valores de Terceros</span></a></li>
						<li class=""><a href="landing_page_2.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><span>Valores Propios</span></a></li>
					</ul>
					<span class="count">2</span>
				</li>
					<!-- Landing Submenu Level 1 -->
					<li class="hasSubmenu">
						<a data-toggle="collapse" class="glyphicons notes" href="#menu_landing"><i></i><span>Gestion de Cuentas</span></a>
						<ul class="collapse" id="menu_landing">
							<li class=""><a href="landing_page_1.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><span>Resumen de Cuentas</span></a></li>
							<li class=""><a href="landing_page_2.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><span>Saldo de Cuentas</span></a></li><li class=""><a href="landing_page_2.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><span>Conciliaciones</span></a></li>
						</ul>
						<span class="count">2</span>
					</li>
				<!-- // Gallery Submenu Level 1 END -->

				<!-- Shop Submenu Level 1 -->
				<li class="hasSubmenu">
					<a data-toggle="collapse" class="glyphicons shopping_cart" href="#menu_ecommerce"><i></i><span>Configuraciones</span></a>
					<ul class="collapse" id="menu_ecommerce">
						<li class="hasSubmenu">
							<a data-toggle="collapse" class="option" id="administracion" href="Admin.html"><i></i><span>Administracion</span></a>

							<span class="count">3</span>
						</li>
					
									<li class="">
										<a data-toggle="collapse" class="option" id="moneda" href="#menu_ecommerce_admin"><i></i><span>Monedas</span></a>
										<span class="count">2</span>
									</li>
									<li class="">
										<a data-toggle="collapse" class="option" id="cuenta" href="#menu_ecommerce_admin"><i></i><span>Cuentas</span></a>
										<span class="count">2</span>
									</li>
										<li class="">
											<a data-toggle="collapse" class="option" id="concepto" href="#menu_ecommerce_admin"><i></i><span>Conceptos</span></a>
											<span class="count">2</span>
										</li>
									<li class="">
										<a data-toggle="collapse" class="option" id="banco" href="#menu_ecommerce_admin"><i></i><span>Bancos</span></a>
										<span class="count">2</span>
									</li>
									<li class="">
										<a data-toggle="collapse" class="option" id="documento" href="#menu_ecommerce_admin"><i></i><span>Documentos</span></a>
										<span class="count">2</span>
									</li>
									<li class="">
										<a data-toggle="collapse" class="option" id="estructura" href="#menu_ecommerce_admin"><i></i><span>Estructuras</span></a>
										<span class="count">2</span>
									</li>
					</ul>
					<span class="count">5</span>
				</li>
				<!-- // Shop Submenu Level 1 END -->

				<!-- Menu Regular Items -->
				<li class="glyphicons tags"><a href="faq.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><i></i><span>Gestion de Documentos</span></a></li>
	

			</ul>
			<div class="clearfix"></div>
			<div class="separator bottom"></div>
			<!-- // Regular Size Menu END -->

						<!-- Sidebar Stats Widgets -->
			<div class="widget-sidebar-stats">
				<strong>3,540</strong>
				<span>Messages</span>
				<span class="pull-right sparkline"></span>
				<div class="clearfix"></div>
			</div>
			<div class="widget-sidebar-stats">
				<strong>2,510,402</strong>
				<span>Photos</span>
				<span class="pull-right sparkline"></span>
				<div class="clearfix"></div>
			</div>
			<div class="separator bottom"></div>
			<!-- // Sidebar Stats Widgets END -->

			<!-- Stats Widget -->
			<a href="" class="widget-stats widget-stats-2 widget-stats-easy-pie widget-sidebar-stats txt-single">
				<div data-percent="90" class="easy-pie primary"><span class="value">90</span>%</div>
				<span class="txt">Completed tasks</span>
				<div class="clearfix"></div>
			</a>
			<!-- // Stats Widget END -->

			<!-- Stats Widget -->
			<a href="" class="widget-stats widget-stats-2 widget-stats-3 widget-sidebar-stats black margin-bottom-none">
				<span class="sparkline success"></span>
				<span class="txt"><span class="count">12,566</span> Photos</span>
				<div class="clearfix"></div>
			</a>
			<div class="separator bottom"></div>
			<!-- // Stats Widget END -->

			<!-- Larger Menu Style -->
			<ul>
				<li class="heading"><span>Larger menu</span></li>
				<li class="large glyphicons group"><a href="error.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><i></i><span>Clients</span></a></li>
				<li class="large hasSubmenu glyphicons log_book">
					<a data-toggle="collapse" href="#menu_tasks"><i></i><span>Task Management</span></a>
					<ul class="collapse" id="menu_tasks">
						<li class=""><a href="tasks.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><span>Tasks Overview</span></a></li>
						<li class=""><a href="error.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><span>Manage Projects</span></a></li>
						<li class=""><a href="error.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-light"><span>Manage Team</span></a></li>
					</ul>
					<span class="count">3</span>
				</li>
			</ul>
			<div class="clearfix"></div>
			<!-- // Larger Menu Style END -->

			<!-- Sidebar Stats Widgets -->
			<div class="separator bottom"></div>
			<div class="widget-sidebar-stats">
				<span>HDD <strong class="pull-right">80% used</strong></span>
				<div class="progress progress-danger">
					<div class="bar" style="width: 80%;"></div>
				</div>
				<div class="clearfix"></div>

			</div>
			<div class="widget-sidebar-stats">
				<span>Mail <strong class="pull-right">65% used</strong></span>
				<div class="progress progress-success">
					<div class="bar" style="width: 65%;"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-sidebar-stats">
				<h5>Generic widget</h5>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
			</div>
			<!-- // Sidebar Stats Widgets END -->



			</div>
			<!-- // Scrollable Menu wrapper with Maximum Height END -->

		</div>
		<!-- // Sidebar Menu END -->

		<!-- Content -->
		<div id="content">
	<!-- Filters -->


<div class ="contenidoPrincipal">
	<div class="innerLR">

		<!-- Modal inline -->
		<div class="modal" style="position: relative; top: auto; left: auto; right: auto; margin: 0 auto; z-index: 1; max-width: 100%;">

			<!-- Modal heading -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3>Modal header</h3>
			</div>
			<!-- // Modal heading END -->

			<!-- Modal body -->
			<div class="modal-body">
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
			</div>
			<!-- // Modal body END -->

			<!-- Modal footer -->
			<div class="modal-footer">
				<a href="#" class="btn btn-default">Just a button</a>
				<a href="#modal-simple" data-toggle="modal" class="btn btn-primary">Open Live Modal</a>
			</div>
			<!-- // Modal footer END -->

		</div>
		<div class="modal hide fade" id="modal-simple">
			<div class="innerLR">
			<form class="form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

				<!-- Widget -->
				<div class="widget">

					<!-- Widget heading -->
					<div class="widget-head">
						<h4 class="heading">Complete los datos</h4>
					</div>
					<!-- // Widget heading END -->

					<div class="widget-body">
						<!-- Row -->
						<div class="row-fluid">
							<!-- Column -->
							<div class="span6">
								<!-- Group -->
								<div class="control-group">
									<label class="control-label" for="firstname">Nombre</label>
									<div class="controls"><input class="span12" id="firstname" name="firstname" type="text"></div>
								</div>
								<div class="control-group">
																			<label class="control-label">Estado</label>
																			<div class="controls">
																				<select class="selectpicker span12">
																					<option>Activo</option>
																					<option>No Activo</option>
																				</select>
																			</div>
																		</div>
								<!-- // Group END -->
								<!-- Group -->
								<!-- // Group END -->
							</div>
							<!-- // Column END -->
							<!-- Column -->
							<!-- // Column END -->
						</div>
						<!-- // Row END -->
						<hr class="separator">
						<!-- Row -->
						<!-- // Row END -->
						<hr class="separator">
					<!-- Form actions -->
						<div class="form-actions">
							<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Save</button>
							<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>Cancel</button>
						</div>
						<!-- // Form actions END -->

					</div>
				</div>
				<!-- // Widget END -->
			</form>
	</div>
		</div>


	<!-- Modal Gallery -->


	</div>
	</div>
	<!-- // Modal Gallery END -->





	<!-- JQueryUI Touch Punch -->
	<!-- small hack that enables the use of touch events on sites using the jQuery UI user interface library -->
	<script src="resources/js/templateClases/plugins/system/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

	<!-- Modernizr -->
	<script src="resources/js/templateClases/plugins/system/modernizr.js"></script>

	<!-- Bootstrap -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>

	<!-- SlimScroll Plugin -->
	<script src="resources/js/templateClases/plugins/other/jquery-slimScroll/jquery.slimscroll.min.js"></script>

	<!-- Common Demo Script -->
	<script src="resources/js/templateClases/common.js?1369414384"></script>

	<!-- Holder Plugin -->
	<script src="resources/js/templateClases/plugins/other/holder/holder.js"></script>

	<!-- Uniform Forms Plugin -->
	<script src="resources/js/templateClases/plugins/forms/pixelmatrix-uniform/jquery.uniform.min.js"></script>

	<!-- PrettyPhoto -->
	<script src="resources/js/templateClases/plugins/gallery/prettyphoto/js/jquery.prettyPhoto.js"></script>

	<!-- Global -->
	<script>
	var basePath = '../../../../common/';
	</script>

	<!-- Bootstrap Extended -->
	<script src="resources/bootstrap/extend/bootstrap-select/bootstrap-select.js"></script>
	<script src="resources/bootstrap/extend/bootstrap-toggle-buttons/static/js/jquery.toggle.buttons.js"></script>
	<script src="resources/bootstrap/extend/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js"></script>
	<script src="resources/bootstrap/extend/jasny-bootstrap/js/jasny-bootstrap.min.js"></script>
	<script src="resources/bootstrap/extend/jasny-bootstrap/js/bootstrap-fileupload.js"></script>
	<script src="resources/bootstrap/extend/bootbox.js"></script>
	<script src="resources/bootstrap/extend/bootstrap-wysihtml5/js/wysihtml5-0.3.0_rc2.min.js"></script>
	<script src="resources/bootstrap/extend/bootstrap-wysihtml5/js/bootstrap-wysihtml5-0.0.2.js"></script>

	<!-- Google Code Prettify -->
	<script src="resources/js/templateClases/plugins/other/google-code-prettify/prettify.js"></script>

	<!-- Gritter Notifications Plugin -->
	<script src="resources/js/templateClases/plugins/notifications/Gritter/js/jquery.gritter.min.js"></script>

	<!-- Notyfy Notifications Plugin -->
	<script src="resources/js/templateClases/plugins/notifications/notyfy/jquery.notyfy.js"></script>

	<!-- MiniColors Plugin -->
	<script src="resources/js/templateClases/plugins/color/jquery-miniColors/jquery.miniColors.js"></script>

	<!-- DateTimePicker Plugin -->
	<script src="resources/js/templateClases/plugins/forms/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>

	<!-- Cookie Plugin -->
	<script src="resources/js/templateClases/plugins/system/jquery.cookie.js"></script>

	<!-- Colors -->
	<script>
	var primaryColor = '#e25f39',
		dangerColor = '#bd362f',
		successColor = '#609450',
		warningColor = '#ab7a4b',
		inverseColor = '#45484d';
	</script>

	<!-- Themer -->
	<script>
	var themerPrimaryColor = primaryColor;
	</script>
	<script src="resources/js/templateClases/themer.js"></script>

	<!-- Twitter Feed -->

	<!-- Easy-pie Plugin -->
	<script src="resources/js/templateClases/plugins/charts/easy-pie/jquery.easy-pie-chart.js"></script>

	<!-- Sparkline Charts Plugin -->
	<script src="resources/js/templateClases/plugins/charts/sparkline/jquery.sparkline.min.js"></script>

	<!-- Ba-Resize Plugin -->
	<script src="resources/js/templateClases/plugins/other/jquery.ba-resize.js"></script>



	<!-- Optional Resizable Sidebars -->
	<!--[if gt IE 8]><!--><script src="resources/js/templateClases/resizable.js?1369414384"></script><!--<![endif]-->

	<!-- Modals Page Demo Script -->
	<script src="resources/js/templateClases/modals.js"></script>
</body>

</html>