package com.wiktoria.model;

import com.wiktoria.domain.VerificationType;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private  boolean isEnabled = false;
    private VerificationType sendTo;
}
