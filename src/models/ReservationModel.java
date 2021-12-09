package models;

import base.IDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationModel implements IDate {

    int roomNumber;
    Date startDate;
    Date finalDate;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int  roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    @Override
    public long calculateDuration() {
        return TimeUnit.DAYS.convert(finalDate.getTime() - startDate.getTime(), TimeUnit.MILLISECONDS);
    }
}
