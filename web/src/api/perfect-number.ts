import { httpConnector } from "@/api/http-connector";
import { NumberIsPerfectDto } from "@/types/is-perfect.dto";

export const checkIfNumberIsPerfect: (n: number) => Promise<{
  data: NumberIsPerfectDto;
  ok: boolean;
  status: number;
}> = (n: number) => httpConnector.get(`/number/${n}/isPerfect`);

export const findPerfectNumbersBetween: (
  startingNumber: number,
  endingNumber: number
) => Promise<{
  data: number[];
  ok: boolean;
  status: number;
}> = (startingNumber: number, endingNumber: number) =>
  httpConnector.get(`/perfectNumbersBetween/${startingNumber}/${endingNumber}`);
