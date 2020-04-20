package passagiers;

import java.util.HashSet;

public abstract class GeprivilegieerdePassagier extends Passagier {
	private HashSet<Voucher> vouchers;

	public GeprivilegieerdePassagier(String naam) {
		super(naam);
		vouchers = new HashSet<Voucher>();
	}

	public GeprivilegieerdePassagier() {
		super();
		vouchers = new HashSet<Voucher>();
	}

	public boolean toevoegenVoucher(Voucher x) {
		return vouchers.add(x);
	}

}
