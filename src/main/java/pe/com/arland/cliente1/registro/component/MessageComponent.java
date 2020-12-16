package pe.com.arland.cliente1.registro.component;

import org.springframework.stereotype.Component;

import pe.com.arland.cliente1.registro.service.MessageService;

@Component
public class MessageComponent {

    private MessageService messageService;

    public MessageComponent(MessageService messageService) {
       this.messageService = messageService;
    }

    public String getMessage() {
        return messageService.getMessage();
    }

}