
$(document).ready(function () {
    //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup','#txtDni',function() {
        let valor = $(this).val();
        listado(valor);

    });

    function listado(consulta) {
        opc = "8";
        $.get("Control", {opc, consulta}, (response) => {
            const misDatos = JSON.parse(response);//recuperar la informacion que envio el controlador  
            let template = "";
            console.log(misDatos);

            template += `  
             <table class="table table-hover">  
                                    <thead class="text-white bg-dark">  
                                        <tr>  
                                            <th>Cod. Alquiler</th>
                                            <th>Cod. Habitacion</th>
                                            <th>DNI Cliente</th>
                                            <th>Fecha Ingreso</th>
                                            <th>Fecha Salida</th>
                                            <th>Cod. Empleado</th>
                                            <th>Estado</th>
                                            <th>Modificar</th>
                                        </tr>  
                                    </thead>  
                                    <tbody>`;
            misDatos.forEach(midato => {
                if(midato.alq_estado==="Finalizado")
                    res="No disponible";
                else
                    res=`<a href="javascript:pasaSeleccion('${midato.alq_codigo}');"><img src="botones/Edit.gif" height="20" width="20" class="center-block"></a></a>`;
                template += `  
                <tr>  
                    <td>${midato.alq_codigo}</td>  
                    <td>${midato.hab_codigo}</td>  
                    <td>${midato.cli_dni}</td>
                    <td>${midato.alq_fechaIngreso}</td> 
                    <td>${midato.alq_fechaSalida}</td>
                    <td>${midato.emp_codigo}</td>
                    <td>${midato.alq_estado}</td>
                    <td>${res}</td> 
                                </tr>`;

            })
            template += `</tbody></table>`;
            $("#tablares").html(template);

        })
    } //fin de listado 

})
    