import datetime


def add(moment):
    giga_second = datetime.timedelta(0, 10 ** 9)
    return moment + giga_second
