package com.turkcell.restapibestpractices.dto.request;

import com.turkcell.restapibestpractices.dto.request.base.BaseAccountRequest;



public class CreateAccountRequest extends BaseAccountRequest {





    /*
    Dto icerisindeki validasyonlar istek daha controllera gelmeden Dispatcher servlet tarafindan
    yakalanip validate edilmesini saglar.


     if (id == null || id.equals("") ) {
        throw new MethodArgumentNotValidException("Account id must not be empty");
    }

     Burada firlatilan exception ResponseEntityExceptionHandler tarafindan yakalanir.
    ResponseEntityExceptionHandler  handleMethodArgumentNot methodu kendisi bize json olarak mesaj uretir.
    Eger bu mesaji ozellestirmek istemiyorsak override ederiz.


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

     ex.getBindingResult() bize exception olan tum fieldlari bir listeye atiyor.
            ex.getBindingResult().getAllErrors() methoduyla donen tum hatalari kendi olusturdugumuz
        map icerisine atiyoruz.

        controllerlarda @Valid anatasyonu vermezsek yukaridaki adimlarin hiocbiri calismayacaktir.
        Cunku spring boot @Valid anatasyonunu gordukten sonra Dto icerisindeki tum validasyonlari calistirir.

*/


}
