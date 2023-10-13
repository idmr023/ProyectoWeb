
$(document).ready(function () {
    //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup', '#txtnom', function () {
        let valor = $(this).val();
        listado(valor);

    });

    function listado(consulta) {
        opc = "5";
        $.get("Control", {opc, consulta}, (response) => {
            const misDatos = JSON.parse(response);//recuperar la informacion q envio el controlador  
            let template = "";
            console.log(misDatos);

            template += `  
             <table class="table table-hover">  
                                    <thead class="text-white bg-dark">  
                                        <tr>  
                                            <th>Codigo</th>  
                                            <th>Apellido</th>  
                                            <th>Nombre</th> 
                                            <th>Sexo</th> 
                                            <th>Celular</th>
                                            <th>Editar</th>
                                            <th>Eliminar</th>
                                           </tr>  
                                    </thead>  
                                    <tbody>`;
            misDatos.forEach(midato => {
                template += `  
                <tr>  
                <td>${midato.cli_dni}</td>  
                    <td>${midato.apellido}</td>  
                    <td>${midato.nombre}</td> 
                    <td>${midato.sexo}</td> 
                    <td>${midato.celular}</td> 
                    <td><a href="control?opc=2&nro=<%=x.getCli_dni()%>">Editar</td>
                    <td><a href="control?opc=6&nro=<%=x.getCli_dni()%>">Eliminar</td>
                    <td><a href="javascript:pasaSeleccion('${midato.cli_dni}', '${midato.apellido}', 
'${midato.nombre}', '${midato.sexo}', '${midato.celular}', '${midato.cli_num_dias}', '${midato.cli_fech_reg}', '${midato.cli_tipo_habitacion}');"> 
</a> 
                                </tr>`;

            })
            template += `</tbody></table>`;
            $("#tablares").html(template);

        })
    } //fin de listado 

})
    