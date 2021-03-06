/*
 * The MIT License
 *
 * Copyright 2018 giuliobosco.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package data;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import helper.csv.Csv;
import helper.csv.NoCsvHeaderException;
import helper.data.Address;
import helper.validators.*;

/**
 * Record for the CSV.
 *
 * @author giuliobosco
 * @version 1.1
 */
public class Record {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Optionals attributes of the request.
     */
    public static final String[] REQUIRED_ATTRIBUTES = {
            "name",
            "surname",
            "day",
            "month",
            "year",
            "street",
            "streetNumber",
            "city",
            "nap",
            "email",
            "number",
            "gender"
    };

    /**
     * Required attributes of the request.
     */
    public static final String[] OPTIONAL_ATTRIBUTES = {
            "hobby",
            "work"
    };

    // ------------------------------------------------------------------------------------------------------ Attributes
    /**
     * Record date.
     */
    private Date date;

    /**
     * Name of the record.
     */
    private String name;

    /**
     * Surname of the record.
     */
    private String surname;

    /**
     * Born date of the record.
     */
    private Date bornDate;

    /**
     * Address of the record.
     */
    private Address address;

    /**
     * Phone number of the record.
     */
    private String phoneNumber;

    /**
     * Email of the record.
     */
    private String email;

    /**
     * Male or Female of the record.
     */
    private char mf;

    /**
     * Hobby of the record.
     */
    private String hobby;

    /**
     * Profession of the record.
     */
    private String work;

    /**
     * Name validator.
     */
    private NameValidator nameValidator;

    /**
     * Email validator.
     */
    private EmailValidator emailValidator;

    /**
     * Date validator.
     */
    private DateValidator dateValidator;

    /**
     * Number validator.
     */
    private NumberValidator numberValidator;

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    /**
     * Getter for the Record date.
     *
     * @return Record date.
     */
    private Date getDate() {
        return date;
    }

    /**
     * Setter for the Record date.
     *
     * @param date Record date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for the Name of the record.
     *
     * @return Name of the record.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for the Name of the record.
     *
     * @param name Name of the record.
     * @throws NotValidDataException Name not valid.
     */
    public void setName(String name) throws NotValidDataException {
        if (nameValidator.isValid(name)) {
            this.name = name;
        } else {
            throw new NotValidDataException(nameValidator.getErrorMessagge());
        }
    }

    /**
     * Getter for the Surname of the record.
     *
     * @return Surname of the record.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Setter for the Surname of the record.
     *
     * @param surname Surname of the record.
     * @throws NotValidDataException Surname not valid.
     */
    public void setSurname(String surname) throws NotValidDataException {
        if (nameValidator.isValid(surname)) {
            this.surname = surname;
        } else {
            throw new NotValidDataException(nameValidator.getErrorMessagge());
        }
    }

    /**
     * Getter for the Born date of the record.
     *
     * @return Born date of the record.
     */
    public Date getBornDate() {
        return this.bornDate;
    }

    /**
     * Setter for the Born date of the record.
     *
     * @param bornDate Born date of the record.
     */
    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    /**
     * Getter for the Address of the record.
     *
     * @return Address of the record.
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Setter for the Address of the record.
     *
     * @param address Address of the record.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter for the Phone number of the record.
     *
     * @return Phone number of the record.
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Setter for the Phone number of the record.
     *
     * @param phoneNumber Phone number of the record.
     */
    public void setPhoneNumber(String phoneNumber) throws NotValidDataException {
        if (numberValidator.isValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new NotValidDataException(numberValidator.getErrorMessagge());
        }
    }

    /**
     * Getter for the Email of the record.
     *
     * @return Email of the record.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter for the Email of the record.
     *
     * @param email Email of the record.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the Male or Female of the record.
     *
     * @return Male or Female of the record.
     */
    public char getMf() {
        return this.mf;
    }

    /**
     * Setter for the Male or Female of the record.
     *
     * @param mf Male or Female of the record.
     * @throws NotValidDataException The gender is not valid.
     */
    public void setMf(char mf) throws NotValidDataException{
        if (mf == 'm' || mf == 'M' || mf == 'f' || mf == 'F') {
            this.mf = mf;
        } else {
            throw new NotValidDataException("the value: " + mf + " is not valid.");
        }
    }

    /**
     * Getter for the Hobby of the record.
     *
     * @return Hobby of the record.
     */
    public String getHobby() {
        return this.hobby;
    }

    /**
     * Setter for the Hobby of the record.
     *
     * @param hobby Hobby of the record.
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * Getter for the Profession of the record.
     *
     * @return Profession of the record.
     */
    public String getWork() {
        return this.work;
    }

    /**
     * Setter for the Profession of the record.
     *
     * @param work Profession of the record.
     */
    public void setWork(String work) {
        this.work = work;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor without parameters.
     * Initialize the date attribute with the actual time.
     */
    public Record() {
        this.address = new Address();
        this.nameValidator = new NameValidator(1, 50);
        this.emailValidator = new EmailValidator();
        this.dateValidator = new DateValidator(new Date());
        this.numberValidator = new NumberValidator(9, 13);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Getter for all the data.
     * Collect all the data of the record and return
     *
     * @return Data of the attributes.
     */
    public String[] getDataStrings() {
        String[] ret = new String[13];

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getBornDate());
        String bornDate = calendar.get(Calendar.DAY_OF_MONTH) + "/"
                + (calendar.get(Calendar.MONTH) + 1) + "/"
                + calendar.get(Calendar.YEAR);

        ret[0] = "\"" + this.getDate().toString() + "\"";
        ret[1] = "\"" + this.getName() + "\"";
        ret[2] = "\"" + this.getSurname() + "\"";
        ret[3] = "\"" + bornDate + "\"";
        ret[4] = "\"" + this.getAddress().getStreet() + "\"";
        ret[5] = "\"" + this.getAddress().getCivicNumberLetter() + "\"";
        ret[6] = "\"" + this.getAddress().getCity() + "\"";
        ret[7] = "\"" + this.getAddress().getNap() + "\"";
        ret[8] = "\"" + this.getPhoneNumber() + "\"";
        ret[9] = "\"" + this.getEmail() + "\" ";
        ret[10] = "\"" + Character.toString(this.getMf()) + "\"";
        ret[11] = "\"" + this.getHobby() + "\"";
        ret[12] = "\"" + this.getWork() + "\"";

        return ret;
    }

    /**
     * Getter all the names of the attributes.
     *
     * @return Names of the attributes.
     */
    public String[] getAttributesStrings() {
        String[] ret = new String[13];

        ret[0] = "\"data\"";
        ret[1] = "\"nome\"";
        ret[2] = "\"cognome\"";
        ret[3] = "\"dataDiNascita\"";
        ret[4] = "\"via\"";
        ret[5] = "\"numeroCivico\"";
        ret[6] = "\"citta\"";
        ret[7] = "\"nap\"";
        ret[8] = "\"telefono\"";
        ret[9] = "\"email\"";
        ret[10] = "\"genere\"";
        ret[11] = "\"hobby\"";
        ret[12] = "\"professione\"";

        return ret;
    }

    /**
     * Set the all the data in one time.
     * The data needs the following sequence.
     * "name",
     * "surname",
     * "day",
     * "month",
     * "year",
     * "street",
     * "streetNumber",
     * "city",
     * "nap",
     * "email",
     * "number",
     * "gender",
     * "hobby", (optional)
     * "work" (optional)
     *
     * @param data Data to insert in the object.
     */
    public void setData(String[] data) throws NotValidDataException {
        if (data.length == 14) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data[2]));
            calendar.set(Calendar.MONTH, Integer.parseInt(data[3]) - 1);
            calendar.set(Calendar.YEAR, Integer.parseInt(data[4]));

            this.setDate(new Date());
            this.setName(data[0]);
            this.setSurname(data[1]);
            this.setBornDate(calendar.getTime());
            this.getAddress().setStreet(data[5]);
            this.getAddress().setCivicNumberLetter(data[6]);
            this.getAddress().setCity(data[7]);
            this.getAddress().setNap(data[8]);
            this.setEmail(data[9]);
            this.setPhoneNumber(data[10]);
            this.setMf(data[11].charAt(0));
            this.setHobby(data[12]);
            this.setWork(data[13]);
        } else {
            throw new NotValidDataException("The inserted data is not valid.");
        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Main method of the class used to test the class.
     *
     * @param args Command Line arguments.
     */
    public static void main(String[] args) throws NotValidDataException {
        Record record = new Record();

        record.setName("John");
        record.setSurname("Doe");
        record.setBornDate(new Date(2000, 1, 1));
        Address recordAddress = new Address();
        recordAddress.setStreet("Via Garibaldi");
        recordAddress.setCivicNumberLetter("57");
        recordAddress.setCity("milano");
        recordAddress.setNap("20121");
        record.setAddress(recordAddress);
        record.setEmail("john.doe@example.com");
        record.setMf('m');//record.setPhoneNumber(41796278810);
        record.setHobby("Play Football");
        record.setWork("Writer");

        try {
            Path path = Paths.get("Csv.txt");
            Csv writer = new Csv(path, ';');
            writer.setHeader(record.getAttributesStrings());

            writer.addLine(record.getDataStrings());

            writer.save();
        } catch (IOException ioe) {
            System.out.println("ioe");
        } catch (NoCsvHeaderException nche) {
            System.out.println("nche");
        }
    }
}
