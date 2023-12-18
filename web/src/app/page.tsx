"use client";

import { useState } from "react";

import {
  checkIfNumberIsPerfect,
  findPerfectNumbersBetween,
} from "@/api/perfect-number";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { NumberIsPerfectDto } from "@/types/is-perfect.dto";

export default function Home() {
  const [numberToCheck, setNumberToCheck] = useState<number | null>(null);
  const [startingNumber, setStartingNumber] = useState<number | null>(null);
  const [endingNumber, setEndingNumber] = useState<number | null>(null);
  const [isPerfect, setIsPerfect] = useState<NumberIsPerfectDto | null>(null);
  const [perfectNumbersFound, setPerfectNumbersFound] = useState<number[]>([]);

  const checkIfItIsPerfect = async () => {
    if (!numberToCheck) {
      return;
    }

    const res = await checkIfNumberIsPerfect(numberToCheck);

    // Recommendation: handle errors
    if (!res.ok) {
      // This will activate the closest `error.js` Error Boundary
      throw new Error("Failed to fetch data");
    }

    setIsPerfect(res.data);
  };

  const findAllPerfectNumbersInInterval = async () => {
    if (!endingNumber || !startingNumber) {
      return;
    }

    const res = await findPerfectNumbersBetween(startingNumber, endingNumber);

    // Recommendation: handle errors
    if (!res.ok) {
      // This will activate the closest `error.js` Error Boundary
      throw new Error("Failed to fetch data");
    }

    setPerfectNumbersFound(res.data);
  };

  return (
    <main className="flex min-h-screen flex-col items-center justify-evenly">
      <div>
        <h3>Check if a number is a perfect number</h3>
        <div>
          <Label htmlFor="isPerfect">Number:</Label>
          <Input
            type="nunber"
            id="isPerfect"
            placeholder="Type a positive number..."
            min={1}
            step={1}
            onChange={(ev) => {
              setNumberToCheck(Number(ev.target.value));
            }}
          />
        </div>

        <Button onClick={() => checkIfItIsPerfect()}>
          Find out if it is a perfect number
        </Button>

        {isPerfect && (
          <p>
            This number is{isPerfect.isPerfect === "true" ? "" : " not"}{" "}
            perfect.
          </p>
        )}
      </div>
      <div>
        <h3>Find perfect numbers in interval (exclusive)</h3>
        <div>
          <Label htmlFor="startingNumber">From:</Label>
          <Input
            type="nunber"
            id="startingNumber"
            placeholder="Type a positive number..."
            onChange={(ev) => {
              setStartingNumber(Number(ev.target.value));
            }}
            min={1}
            max={99999}
            step={1}
          />
        </div>
        <div>
          <Label htmlFor="endingNumber">To:</Label>
          <Input
            type="nunber"
            id="endingNumber"
            placeholder="Type a positive number..."
            onChange={(ev) => {
              setEndingNumber(Number(ev.target.value));
            }}
            min={1}
            max={99999}
            step={1}
          />
        </div>

        <Button onClick={() => findAllPerfectNumbersInInterval()}>Find</Button>

        {perfectNumbersFound.map((perfectNumber, index) => (
          <p key={index}>{perfectNumber}</p>
        ))}
      </div>
    </main>
  );
}
