package com.barclays.casesource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CaseSourceData {
  private int custid;
  private int accountid;
  private String accountNumber;
  private String custNo;
}