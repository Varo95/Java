package io.videoclub.model;

import io.videoclub.model.interfaces.AProduct;
import io.videoclub.model.interfaces.IClient;
import io.videoclub.model.interfaces.IEnum;
import io.videoclub.model.interfaces.IStorage;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Reservation implements IStorage<Reservation> {

    public enum StatusReserve implements IEnum {
        ACTIVE, //ini on, finished off
        FINISHED, //ini on finised on == end
        PENDING  //ini on , finished off and end past
        ;
        @Override
        public String getDisplayName() {
            return this.name();
        }
    }
    private transient AProduct pro;
    private transient IClient cli;
    private final String productId;
    private final String clientId;
    private LocalDate ini;
    private LocalDate end;
    private LocalDate finished;
    private StatusReserve status;

    public Reservation(final AProduct pro, final IClient cli) {
        this.pro = pro;
        this.cli = cli;
        this.productId = pro.getId();
        this.clientId = cli.getId();
        this.finished = null;
        this.pro.setStatus(AProduct.Status.RESERVED);
        this.ini = LocalDate.now();
        this.end = LocalDate.now().plusDays(2);
        if (this.end.getDayOfWeek() == DayOfWeek.SUNDAY) {
            this.end = this.end.plusDays(1);
        }
        this.status = StatusReserve.ACTIVE;
    }

    public AProduct getPro() {
        return this.pro;
    }

    public IClient getCli() {
        return this.cli;
    }

    public LocalDate getIni() {
        return this.ini;
    }

    public LocalDate getEnd() {
        return this.end;
    }

    public LocalDate getFinished() {
        return this.finished;
    }

    public StatusReserve getStatus() {
        return this.status;
    }

    public void setPro(final AProduct pro) {
        this.pro = pro;
    }

    public void setCli(final IClient cli) {
        this.cli = cli;
    }

    public void setIni(final LocalDate ini) {
        this.ini = ini;
    }

    public void setEnd(final LocalDate end) {
        this.end = end;
    }

    public void setFinished(final LocalDate finished) {
        this.finished = finished;
    }

    public void setStatus(final StatusReserve status) {
        this.status = status;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void addDays(final int days) {
        this.end = LocalDate.now().plusDays(days);
        this.status = StatusReserve.ACTIVE;
    }

    public void finish() {
        this.finished = LocalDate.now();
        this.pro.setStatus(AProduct.Status.AVAILABLE);
        this.status = StatusReserve.FINISHED;
    }

    public double getIncome() {
        return switch (this.status) {
            case ACTIVE -> (this.pro.getPrize() / 2) * (float) this.ini.until(this.end).getDays();
            case PENDING -> (this.pro.getPrize() / 2) * (float) this.ini.until(LocalDate.now()).getDays();
            case FINISHED -> this.ini.until(finished).getDays() == 0 ? this.pro.getPrize() : ((this.pro.getPrize() / 2) * (float) this.ini.until(this.finished).getDays());
        };
    }

    @Override
    public int compareTo(final Reservation o) {
        return this.equals(o) ? 0 : this.cli.getId().compareTo(o.cli.getId()) + this.pro.compareTo(o.pro) + this.ini.compareTo(o.ini);
    }

    @Override
    public String getId() {
        return this.clientId + "-" + this.productId;
    }

    @Override
    public boolean equals(final Object o) {
        return o == this || o instanceof Reservation other && this.pro.equals(other.pro) && this.cli.equals(other.cli) && this.ini.equals(other.ini) && this.end.equals(other.end) && this.status == other.status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "pro=" + this.pro.toString() +
                ", cli=" + this.cli.toString() +
                ", ini=" + this.ini +
                ", end=" + this.end +
                ", finished=" + this.finished +
                ", status=" + this.status +
                '}';
    }
}
