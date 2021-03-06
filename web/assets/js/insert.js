/**
 * insert.js
 * Insert page validation management.
 *
 * @author giuliobosco
 * @version 1.5
 */

/**
 * Name Validator, validator for strings.
 * @type {NameValidator}
 */
let nameValidator = new NameValidator(0,50);
/**
 * Email Validator, validator for the email.
 * @type {EmailValidator}
 */
let emailValidator = new EmailValidator(4, 256);

/**
 * First name validation status.
 * @type {boolean}
 */
let firstname = false;

/**
 * Last name validation status.
 * @type {boolean}
 */
let lastname = false;

/**
 * Date day validation status.
 * @type {boolean}
 */
let day = false;

/**
 * Date year validation status.
 * @type {boolean}
 */
let year = false;

/**
 * Street address validation status.
 * @type {boolean}
 */
let street = false;

/**
 * Civic number address validation status.
 * @type {boolean}
 */
let streetNumber = false;

/**
 * City address validation status.
 * @type {boolean}
 */
let city = false;

/**
 * Nap address validation status.
 * @type {boolean}
 */
let nap = false;

/**
 * Email validation status.
 * @type {boolean}
 */
let email = false;

/**
 * Number validation status.
 * @type {boolean}
 */
let number = false;

/**
 * Gender validation status.
 * @type {boolean}
 */
let gender = false;

/**
 * Check the status of all validation and enable or disable the submit button.
 */
function toggleSubmit() {
	if (firstname === true &&
		lastname === true &&
		day === true &&
		year === true &&
		street === true &&
		streetNumber === true &&
		city === true &&
		nap === true &&
		email === true &&
		number === true &&
		gender === true) {
		$("input[type='submit']").removeAttr('disabled').css('background-color', '#00d');
	} else {
		$("input[type='submit']").attr('disabled', 'disabled').css('background-color', 'rgba(0,0,117,0.75)');
	}
}


$(document).ready(function () {

	toggleSubmit();

	$( "input[name='name']" ).keyup(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			firstname = true;
		} else {
			$(this).css('border-color', '#f00');
			firstname = false;
		}

		toggleSubmit();
	});

	$("input[name='surname']").keyup(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			lastname = true;
		} else {
			$(this).css('border-color', '#f00');
			lastname = false;
		}

		toggleSubmit();
	});

	$("input[name='day']").keyup(function () {
		if ($(this).val() > 0 && $(this).val() <= 31) {
			$(this).css('border-color', '#000');
			day = true;
		} else {
			$(this).css('border-color', '#f00');
			day = false;
		}

		toggleSubmit();
	});

	$("input[name='year']").keyup(function () {
		if ($(this).val() > (new Date().getFullYear() - 120) && $(this).val() <= new Date().getFullYear()) {
			$(this).css('border-color', '#000');
			year = true;
		} else {
			$(this).css('border-color', '#f00');
			year = false;
		}

		toggleSubmit();
	});

	$("input[name='street']").keyup(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			street = true;
		} else {
			$(this).css('border-color', '#f00');
			street = false;
		}

		toggleSubmit();
	});

	$("input[name='streetNumber']").keyup(function () {
		if (LocalValidator.civicNumber($(this).val())) {
			$(this).css('border-color', '#000');
			streetNumber = true;
		} else {
			$(this).css('border-color', '#f00');
			streetNumber = false;
		}

		toggleSubmit();
	});

	$("input[name='city']").keyup(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			city = true;
		} else {
			$(this).css('border-color', '#f00');
			city = false;
		}

		toggleSubmit();
	});

	$("input[name='nap']").keyup(function () {
		if (LocalValidator.nap($(this).val())) {
			$(this).css('border-color', '#000');
			nap = true;
		} else {
			$(this).css('border-color', '#f00');
			nap = false;
		}

		toggleSubmit();
	});

	$("input[name='email']").keyup(function () {
		if (emailValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			email = true;
		} else {
			$(this).css('border-color', '#f00');
			email = false;
		}

		toggleSubmit();
	});

	$("input[name='number']").keyup(function () {
		if (LocalValidator.phone($(this).val())) {
			$(this).css('border-color', '#000');
			number = true;
		} else {
			$(this).css('border-color', '#f00');
			number = false;
		}

		toggleSubmit();
	});

	$("input[name='gender']").keyup(function () {
		if (LocalValidator.gender($(this).val())) {
			$(this).css('border-color', '#000');
			gender = true;
		} else {
			$(this).css('border-color', '#f00');
			gender = false;
		}

		toggleSubmit();
	});
});