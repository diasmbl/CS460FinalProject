package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.TransferRequestDTO;
import edu.ensign.cs460.bankingapi.dto.TransferResultDTO;

public interface TransferService {
    TransferResultDTO initiateTransfer(TransferRequestDTO transferRequest);
}
