#
# 21fa-cs115bc
#
# lab13.py
#
# A.Nicolosi
# 20211201
#
# Issac Zheng
# I pledge my honor that I have abided by the Stevens Honor System.
#
# Practice with classes.

# TODO: Write a bare-bone class InvalidDateError that inherits from ValueError
# Your constructor should allow for up to three argument (for the month,
# day, and year).  Hint: recall the syntax for default parameter values.

class InvalidDateError(ValueError):
    def __init__(self, month, day, year):
        super().__init__(f"Invaid Date {month}/{day}/{year}")
        self.month = month
        self.day = day
        self.year = year
    
# Fill in the missing part in the class Date below
class Date:
    '''
    Date abstraction

    Demonstrate getter/setter methods and operator overloading
    '''

    daysInMonth = [31,          # not really using index 0 (dec of prev year)
                   31, 28, 31,  # jan, (non-leap) feb, mar
                   30, 31, 30,  # apr, may, jun
                   31, 31, 30,  # jul, aug, sep
                   31, 30, 31]  # oct, nov, dec

    def isLeapYear(year):
        # Every fourth year is a leap year,
        # except that every one-hundreth year it isn't,
        # but every four-hundreth year is a leap year after all!
        #
        return year%4==0

    def __init__(self, month=1, day=1, year=1970): # setting parameter values in the function header assigns default values to them
        # Call self.validate to ensure that the parameters
        # make a valid date.  Raise an InvalidDateError if not.
        # If all is good, initialize the attributes _month, _day, and
        # _year
        #
        if(not Date.validate_params(month, day, year)):
            raise InvalidDateError(month, day, year)
        self.month = month
        self.day = day
        self.year = year

    def __repr__(self):
        # Make sure to return a string that looks like a valid
        # call to the class constructor
        # Ex: Date(12, 31, 2021)
        #
        # looks like a call to the function: returns info that you'll need to reconstruct the object it is called from. "represent"
        return f"Date({self.month}, {self.day}, {self.year})"

    def __str__(self):
        # Return a string in the format mm/dd/yyyy
        #
        return ("0" if self.month<10 else "") + str(self.month) + "/" + ("0" if self.day<10 else "") + str(self.day) + "/" + str(self.year)

    def _validateCheckFeb29(m, d, y):
        return 2 == m and 29 == d and Date.isLeapYear(y)

    def validate_params(m, d, y): # methods with self you call from an object. methods without self you call from the class
        # Return True if m, d, y represent a valid date
        # Start by checking if that's a valid Feb 29 (see
        # helper above); then check if d is a valid day
        # in month m
        #
        return Date._validateCheckFeb29(m, d, y) or (m<=12 and m>0 and d<=Date.daysInMonth[m] and d>0 and y>=1) # not sure if we start from 0 or 1 or gregorian calendar's creation date 1583

    # Write getters and setters
    # TODO: get_month, get_day, get_year, set_month, set_day, set_year
    # NB: Setter should check that the resulting date is valid
    # *before* affecting the change
    
    def get_month(self):
        return self.month

    def get_day(self):
        return self.day
    
    def get_year(self):
        return self.year

    def set_month(self, month):
        if(not Date.validate_params(month, self.day, self.year)):
            raise InvalidDateError(month, self.day, self.year)
        self.month = month

    def set_day(self, day):
        if(not Date.validate_params(self.month, day, self.year)):
            raise InvalidDateError(self.month, day, self.year)
        self.day = day

    def set_year(self, year):
        if(not Date.validate_params(self.month, self.day, year)):
            raise InvalidDateError(self.month, self.day, year)
        self.year = year

    # Date arithmetic!

    # these functions are created assuming we are not allowed to call others within them because that used to be a rule for some reason

    def __eq__(self, other): #==
        return self.month == other.month and self.day == other.day and self.year == other.year

    def __ne__(self, other): #!=
        return not (self.month == other.month and self.day == other.day and self.year == other.year)
        #return not self.__eq__(other)

    def __lt__(self, other): #<
        if(self.year < other.year):
            return True
        if(self.year == other.year):
            if(self.month < other.month):
                return True
            if(self.month == other.month and self.day < other.day):
                return True                
        return False

    def __gt__(self, other): #>
        if(self.year > other.year):
            return True
        if(self.year == other.year):
            if(self.month > other.month):
                return True
            if(self.month == other.month and self.day > other.day):
                return True                
        return False
    
    def __ge__(self, other): #>=
        if(self.month == other.month and self.day == other.day and self.year == other.year):
            return True
        if(self.year > other.year):
            return True
        if(self.year == other.year):
            if(self.month > other.month):
                return True
            if(self.month == other.month and self.day > other.day):
                return True                
        return False

    def __le__(self, other): #<=
        if(self.month == other.month and self.day == other.day and self.year == other.year):
            return True
        if(self.year < other.year):
            return True
        if(self.year == other.year):
            if(self.month < other.month):
                return True
            if(self.month == other.month and self.day < other.day):
                return True                
        return False

    def __add__(self, deltaInDays):
        '''Computes the date following `self` by the specified number of days'''
        for i in range(deltaInDays):
            self.day+=1
            if(self.day > self.daysInMonth[self.month]):
                if(Date.isLeapYear(self.year) and self.month==2 and self.day==29):
                    continue
                self.month+=1
                self.day=1
            if(self.month > 12):
                self.year+=1
                self.month=1
                

# TESTING
""" date = Date(3, 6, 1990)
date2 = Date(10, 16, 1580)
#date3 = Date(2, 30, 1990)
date4 = Date(2, 28, 2020)

cd1 = Date(1, 1, 2000)
cd2 = Date(2, 1, 2000)
cd3 = Date(1, 2, 2000)
cd4 = Date(1, 1, 1999)

cd5 = Date(1,1,1970)
cd6 = Date(1,2,1969)
 """
 
# lt le gt ge
""" print(cd1.__gt__(cd1))
print(cd1.__gt__(cd2))
print(cd1.__gt__(cd3))
print(cd1.__gt__(cd4))
print()
print(cd1.__ge__(cd1))
print(cd1.__ge__(cd2))
print(cd1.__ge__(cd3))
print(cd1.__ge__(cd4))
print()
print(cd1.__lt__(cd1))
print(cd1.__lt__(cd2))
print(cd1.__lt__(cd3))
print(cd1.__lt__(cd4))
print()
print(cd1.__le__(cd1))
print(cd1.__le__(cd2))
print(cd1.__le__(cd3))
print(cd1.__le__(cd4))
print() """

# add
""" print(date)
print(date2)
print(date4)
date.__add__(365)
date4.__add__(365)
print(date)
print(date4)
print(date.__lt__(date2)) """

# eq ne repr str getters and setters
""" print(Date.isLeapYear(1990))
print(date)
print(date.__repr__())
print(date.get_day())
print(date.get_month())e
print(date.get_year())
print(date.__eq__(Date(3,6,1990)))
print(date.__ne__(Date(3,6,1990)))
print(date.__ne__(Date(4,7,1990)))
date.set_month(10)
date.set_day(4)
date.set_year(1992)
#date.set_month(13)
#date.set_day(32)
#date.set_year(-1)
print(date.get_day())
print(date)
print(date.__repr__())
print(date.__eq__(Date(3,6,1990)))
print(date.__eq__(Date(10,4,1992)))
print()
print(date2)
print(date2.__repr__())
print(date2.get_day())
print()
print(date4)
print(date4.__repr__())
print(date4.get_day()) """