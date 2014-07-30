<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="ie lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="ie lt-ie9"> <![endif]-->
<!--[if gt IE 8]> <html class="ie gt-ie8"> <![endif]-->
<!--[if !IE]><!--><html><!-- <![endif]-->
<head>
	<title>Zurbaran</title>

	<!-- Meta -->
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" charset="ISO-8859-1" />
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
	<link href="resources/bootstrap/css/responsive.css" rel="stylesheet"  />

	<!-- Glyphicons Font Icons -->
	<link href="resources/css/glyphicons.css" rel="stylesheet"media="all" />

	<!-- Uniform Pretty Checkboxes -->
	<link href="resources/js/templateClases/plugins/forms/pixelmatrix-uniform/css/uniform.default.css" rel="stylesheet"  />
	<script src="resources/js/templateClases/plugins/charts/flot/jquery.flot.js"></script>
	<script src="resources/js/templateClases/plugins/charts/flot/jquery.flot.orderBars.js"></script>

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
	<link href="resources/css/jquery.jgrowl.css" rel="stylesheet" />
	<link href="resources/js/templateClases/plugins/tables/DataTables/media/css/jquery.dataTables.css" rel="stylesheet" />

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
	<script src="resources/js/templateClases/plugins/jquery.PrintArea.js"></script>
	


	<!-- Main Theme Stylesheet :: CSS -->
	<link href="resources/css/style-light.css?1369414384" rel="stylesheet"  />


	<!-- LESS.js Library -->
	<script src="resources/js/templateClases/plugins/system/less.min.js"></script>
		<script src="resources/js/templateClases/plugins/money.js"></script>
		<script src="resources/js/templateClases/plugins/jquery.number.js"></script>
	<!-- DataTables Tables Plugin -->
	<script src="resources/js/templateClases/plugins/tables/DataTables/media/js/jquery.dataTables.min.js"></script>
	<script src="resources/js/templateClases/plugins/tables/DataTables/media/js/DT_bootstrap.js"></script>
	<script src="resources/js/templateClases/plugins/mootools-core-1.4.5-full-compat.js"></script>
	<script src="resources/js/templateClases/plugins/forms/select2/select2.js"></script>
	<script src="resources/js/uiClases/SideBarController.js"></script>
	<script src="resources/js/uiClases/TemplateManager.js"></script>
	<script src="resources/js/uiClases/Render.js"></script>
	<script src="resources/js/uiClases/DocumentoJson.js"></script>
	<script src="resources/js/uiClases/Rol.js"></script>
	<script src="resources/js/uiClases/Usuario.js"></script>

	<script src="resources/js/uiClases/AppStatus.js"></script>

	<script src="resources/js/uiClases/Banco.js"></script>
	<script src="resources/js/uiClases/SaldoEstructura.js"></script>
	<script src="resources/js/uiClases/Entidad.js"></script>
	<script src="resources/js/uiClases/Chequera.js"></script>
	<script src="resources/js/uiClases/Cotizacion.js"></script>
	<script src="resources/js/uiClases/Utils.js"></script>
	<script src="resources/js/uiClases/Cuenta.js"></script>
	<script src="resources/js/uiClases/TipoDocumento.js"></script>
	<script src="resources/js/uiClases/Estructura.js"></script>
	<script src="resources/js/uiClases/EstructuraContenido.js"></script>
	<script src="resources/js/uiClases/Tercero.js"></script>
	<script src="resources/js/uiClases/Propio.js"></script>
	<script src="resources/js/uiClases/SaldoEstructuraMovimiento.js"></script>


	<script src="resources/js/uiClases/DocumentoListado.js"></script>
    <script src="resources/js/uiClases/Documento.js"></script>

	<script src="resources/js/uiClases/Moneda.js"></script>
	<script src="resources/js/uiClases/Periodo.js"></script>
	<script src="resources/js/uiClases/ResumenCuenta.js"></script>
	<script src="resources/js/uiClases/SaldoCuenta.js"></script>
	<script src="resources/js/uiClases/Concepto.js"></script>
	<script src="resources/js/uiClases/Administracion.js"></script>
	<script src="resources/js/uiClases/ComponentTranslator.js"></script>
	<script src="resources/js/uiClases/TipoEntidad.js"></script>
	<script src="resources/js/uiClases/RenderTranslator.js"></script>
	<script src="resources/js/uiClases/ServerManager.js"></script>

			<script src="resources/js/templateClases/plugins/notifications/jquery.jgrowl.js" ></script>

		<link rel="stylesheet" href="resources/js/templateClases/plugins/tag/css/textext.core.css" type="text/css">
		<link rel="stylesheet" href="resources/js/templateClases/plugins/tag/css/textext.plugin.tags.css" type="text/css">
		<link rel="stylesheet" href="resources/js/templateClases/plugins/tag/css/textext.plugin.autocomplete.css" type="text/css">
		<link rel="stylesheet" href="resources/js/templateClases/plugins/tag/css/textext.plugin.focus.css" type="text/css">
		<link rel="stylesheet" href="resources/js/templateClases/plugins/tag/css/textext.plugin.prompt.css" type="text/css">
		<link rel="stylesheet" href="resources/js/templateClases/plugins/tag/css/textext.plugin.arrow.css" type="text/css">
		<link rel="stylesheet" href="resources/js/templateClases/plugins/tables/DataTables/extras/TableTools/media/css/TableTools.css" type="text/css">


		<link rel="stylesheet" href="resources/css/estilosPropios.css" type="text/css" media="all">
				<script src="resources/js/templateClases/plugins/tables/DataTables/extras/TableTools/media/js/ZeroClipboard.js" type="text/javascript" charset="ISO-8859-1"></script>

		<script src="resources/js/templateClases/plugins/tables/DataTables/extras/TableTools/media/js/TableTools.min.js" type="text/javascript" charset="ISO-8859-1"></script>
		<script src="resources/js/templateClases/plugins/tag/js/textext.core.js" type="text/javascript" charset="ISO-8859-1"></script>
		<script src="resources/js/templateClases/plugins/tag/js/textext.plugin.tags.js" type="text/javascript" charset="ISO-8859-1"></script>
		<script src="resources/js/templateClases/plugins/tag/js/textext.plugin.autocomplete.js" type="text/javascript" charset="ISO-8859-1"></script>
		<script src="resources/js/templateClases/plugins/tag/js/textext.plugin.suggestions.js" type="text/javascript" charset="ISO-8859-1"></script>
		<script src="resources/js/templateClases/plugins/tag/js/textext.plugin.filter.js" type="text/javascript" charset="ISO-8859-1"></script>
		<script src="resources/js/templateClases/plugins/tag/js/textext.plugin.focus.js" type="text/javascript" charset="ISO-8859-1"></script>
		<script src="resources/js/templateClases/plugins/tag/js/textext.plugin.prompt.js" type="text/javascript" charset="ISO-8859-1"></script>
		<script src="resources/js/templateClases/plugins/tag/js/textext.plugin.ajax.js" type="text/javascript" charset="ISO-8859-1"></script>
		<script src="resources/js/templateClases/plugins/tag/js/textext.plugin.arrow.js" type="text/javascript" charset="ISO-8859-1"></script>

<script>
  $( document ).ready(function() {
	  $(".contLogin").click(function() {
		  $.ajax({type: 'GET',
	    		url: 'login/',
	    		success: function(data) {
	    		   $("body").empty()
	    		   $("body").append(data);
	    			sideBarController.bindMenuOptionsEvents();

	    			
				}});
	    	
		});
  });
 </script>
</head>
<body class="login">
	
	<!-- Wrapper -->
<div id="login" style="background: #e04545 url(../images/mosaic-pattern.png) repeat;">

	<!-- Box -->
	<div class="form-signin">
		<h3>Entrar con mi Cuenta</h3>
		
		<!-- Row -->
		<div class="row-fluid row-merge">
		
			<!-- Column -->
			<div class="span12">
				<div class="inner">
					<!-- Form -->
					<form:form name='loginForm' action="login" method='POST'>
						<label class="strong">Usuario</label>
						<input type="text" class="input-block-level" placeholder="Ingrese su Usuario"/> 
						<input type="password" class="input-block-level" placeholder="Ingrese su Clave"/> 
<!-- 						<div class="uniformjs" style=""><label class="checkbox"><input type="checkbox" value="remember-me">Recordarme</label></div> -->
						<div class="row-fluid">
							<div class="span5 center">
								<button class="btn btn-block btn-primary contLogin" type="button">Entrar</button>
							</div>
						</div>
					</form:form>
					<!-- // Form END -->
					
				</div>
			</div>
			<!-- // Column END -->
			
			<!-- Column -->

			<!-- // Column END -->
			
		</div>
		<!-- // Row END -->

	</div>
	<!-- // Box END -->
	
</div>
<!-- // Wrapper END -->	

	

	
	
</body>
</html>