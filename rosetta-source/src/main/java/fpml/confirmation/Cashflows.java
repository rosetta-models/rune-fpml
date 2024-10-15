package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.Cashflows;
import fpml.confirmation.Cashflows.CashflowsBuilder;
import fpml.confirmation.Cashflows.CashflowsBuilderImpl;
import fpml.confirmation.Cashflows.CashflowsImpl;
import fpml.confirmation.PaymentCalculationPeriod;
import fpml.confirmation.PrincipalExchange;
import fpml.confirmation.meta.CashflowsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the cashflow representation of a swap trade.
 * @version ${project.version}
 */
@RosettaDataType(value="Cashflows", builder=Cashflows.CashflowsBuilderImpl.class, version="${project.version}")
public interface Cashflows extends RosettaModelObject {

	CashflowsMeta metaData = new CashflowsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A true/false flag to indicate whether the cashflows match the parametric definition of the stream, i.e. whether the cashflows could be regenerated from the parameters without loss of information.
	 */
	Boolean getCashflowsMatchParameters();
	/**
	 * The initial, intermediate and final principal exchange amounts. Typically required on cross currency interest rate swaps where actual exchanges of principal occur. A list of principal exchange elements may be ordered in the document by ascending adjusted principal exchange date. An FpML document containing an unordered principal exchange list is still regarded as a conformant document.
	 */
	List<? extends PrincipalExchange> getPrincipalExchange();
	/**
	 * The adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. A list of payment calculation period elements may be ordered in the document by ascending adjusted payment date. An FpML document containing an unordered list of payment calculation periods is still regarded as a conformant document.
	 */
	List<? extends PaymentCalculationPeriod> getPaymentCalculationPeriod();

	/*********************** Build Methods  ***********************/
	Cashflows build();
	
	Cashflows.CashflowsBuilder toBuilder();
	
	static Cashflows.CashflowsBuilder builder() {
		return new Cashflows.CashflowsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Cashflows> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Cashflows> getType() {
		return Cashflows.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cashflowsMatchParameters"), Boolean.class, getCashflowsMatchParameters(), this);
		processRosetta(path.newSubPath("principalExchange"), processor, PrincipalExchange.class, getPrincipalExchange());
		processRosetta(path.newSubPath("paymentCalculationPeriod"), processor, PaymentCalculationPeriod.class, getPaymentCalculationPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashflowsBuilder extends Cashflows, RosettaModelObjectBuilder {
		PrincipalExchange.PrincipalExchangeBuilder getOrCreatePrincipalExchange(int _index);
		List<? extends PrincipalExchange.PrincipalExchangeBuilder> getPrincipalExchange();
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder getOrCreatePaymentCalculationPeriod(int _index);
		List<? extends PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> getPaymentCalculationPeriod();
		Cashflows.CashflowsBuilder setCashflowsMatchParameters(Boolean cashflowsMatchParameters);
		Cashflows.CashflowsBuilder addPrincipalExchange(PrincipalExchange principalExchange0);
		Cashflows.CashflowsBuilder addPrincipalExchange(PrincipalExchange principalExchange1, int _idx);
		Cashflows.CashflowsBuilder addPrincipalExchange(List<? extends PrincipalExchange> principalExchange2);
		Cashflows.CashflowsBuilder setPrincipalExchange(List<? extends PrincipalExchange> principalExchange3);
		Cashflows.CashflowsBuilder addPaymentCalculationPeriod(PaymentCalculationPeriod paymentCalculationPeriod0);
		Cashflows.CashflowsBuilder addPaymentCalculationPeriod(PaymentCalculationPeriod paymentCalculationPeriod1, int _idx);
		Cashflows.CashflowsBuilder addPaymentCalculationPeriod(List<? extends PaymentCalculationPeriod> paymentCalculationPeriod2);
		Cashflows.CashflowsBuilder setPaymentCalculationPeriod(List<? extends PaymentCalculationPeriod> paymentCalculationPeriod3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cashflowsMatchParameters"), Boolean.class, getCashflowsMatchParameters(), this);
			processRosetta(path.newSubPath("principalExchange"), processor, PrincipalExchange.PrincipalExchangeBuilder.class, getPrincipalExchange());
			processRosetta(path.newSubPath("paymentCalculationPeriod"), processor, PaymentCalculationPeriod.PaymentCalculationPeriodBuilder.class, getPaymentCalculationPeriod());
		}
		

		Cashflows.CashflowsBuilder prune();
	}

	/*********************** Immutable Implementation of Cashflows  ***********************/
	class CashflowsImpl implements Cashflows {
		private final Boolean cashflowsMatchParameters;
		private final List<? extends PrincipalExchange> principalExchange;
		private final List<? extends PaymentCalculationPeriod> paymentCalculationPeriod;
		
		protected CashflowsImpl(Cashflows.CashflowsBuilder builder) {
			this.cashflowsMatchParameters = builder.getCashflowsMatchParameters();
			this.principalExchange = ofNullable(builder.getPrincipalExchange()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.paymentCalculationPeriod = ofNullable(builder.getPaymentCalculationPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashflowsMatchParameters")
		public Boolean getCashflowsMatchParameters() {
			return cashflowsMatchParameters;
		}
		
		@Override
		@RosettaAttribute("principalExchange")
		public List<? extends PrincipalExchange> getPrincipalExchange() {
			return principalExchange;
		}
		
		@Override
		@RosettaAttribute("paymentCalculationPeriod")
		public List<? extends PaymentCalculationPeriod> getPaymentCalculationPeriod() {
			return paymentCalculationPeriod;
		}
		
		@Override
		public Cashflows build() {
			return this;
		}
		
		@Override
		public Cashflows.CashflowsBuilder toBuilder() {
			Cashflows.CashflowsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Cashflows.CashflowsBuilder builder) {
			ofNullable(getCashflowsMatchParameters()).ifPresent(builder::setCashflowsMatchParameters);
			ofNullable(getPrincipalExchange()).ifPresent(builder::setPrincipalExchange);
			ofNullable(getPaymentCalculationPeriod()).ifPresent(builder::setPaymentCalculationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Cashflows _that = getType().cast(o);
		
			if (!Objects.equals(cashflowsMatchParameters, _that.getCashflowsMatchParameters())) return false;
			if (!ListEquals.listEquals(principalExchange, _that.getPrincipalExchange())) return false;
			if (!ListEquals.listEquals(paymentCalculationPeriod, _that.getPaymentCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowsMatchParameters != null ? cashflowsMatchParameters.hashCode() : 0);
			_result = 31 * _result + (principalExchange != null ? principalExchange.hashCode() : 0);
			_result = 31 * _result + (paymentCalculationPeriod != null ? paymentCalculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Cashflows {" +
				"cashflowsMatchParameters=" + this.cashflowsMatchParameters + ", " +
				"principalExchange=" + this.principalExchange + ", " +
				"paymentCalculationPeriod=" + this.paymentCalculationPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of Cashflows  ***********************/
	class CashflowsBuilderImpl implements Cashflows.CashflowsBuilder {
	
		protected Boolean cashflowsMatchParameters;
		protected List<PrincipalExchange.PrincipalExchangeBuilder> principalExchange = new ArrayList<>();
		protected List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> paymentCalculationPeriod = new ArrayList<>();
	
		public CashflowsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("cashflowsMatchParameters")
		public Boolean getCashflowsMatchParameters() {
			return cashflowsMatchParameters;
		}
		
		@Override
		@RosettaAttribute("principalExchange")
		public List<? extends PrincipalExchange.PrincipalExchangeBuilder> getPrincipalExchange() {
			return principalExchange;
		}
		
		public PrincipalExchange.PrincipalExchangeBuilder getOrCreatePrincipalExchange(int _index) {
		
			if (principalExchange==null) {
				this.principalExchange = new ArrayList<>();
			}
			PrincipalExchange.PrincipalExchangeBuilder result;
			return getIndex(principalExchange, _index, () -> {
						PrincipalExchange.PrincipalExchangeBuilder newPrincipalExchange = PrincipalExchange.builder();
						return newPrincipalExchange;
					});
		}
		
		@Override
		@RosettaAttribute("paymentCalculationPeriod")
		public List<? extends PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> getPaymentCalculationPeriod() {
			return paymentCalculationPeriod;
		}
		
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder getOrCreatePaymentCalculationPeriod(int _index) {
		
			if (paymentCalculationPeriod==null) {
				this.paymentCalculationPeriod = new ArrayList<>();
			}
			PaymentCalculationPeriod.PaymentCalculationPeriodBuilder result;
			return getIndex(paymentCalculationPeriod, _index, () -> {
						PaymentCalculationPeriod.PaymentCalculationPeriodBuilder newPaymentCalculationPeriod = PaymentCalculationPeriod.builder();
						return newPaymentCalculationPeriod;
					});
		}
		
		@Override
		@RosettaAttribute("cashflowsMatchParameters")
		public Cashflows.CashflowsBuilder setCashflowsMatchParameters(Boolean cashflowsMatchParameters) {
			this.cashflowsMatchParameters = cashflowsMatchParameters==null?null:cashflowsMatchParameters;
			return this;
		}
		@Override
		public Cashflows.CashflowsBuilder addPrincipalExchange(PrincipalExchange principalExchange) {
			if (principalExchange!=null) this.principalExchange.add(principalExchange.toBuilder());
			return this;
		}
		
		@Override
		public Cashflows.CashflowsBuilder addPrincipalExchange(PrincipalExchange principalExchange, int _idx) {
			getIndex(this.principalExchange, _idx, () -> principalExchange.toBuilder());
			return this;
		}
		@Override 
		public Cashflows.CashflowsBuilder addPrincipalExchange(List<? extends PrincipalExchange> principalExchanges) {
			if (principalExchanges != null) {
				for (PrincipalExchange toAdd : principalExchanges) {
					this.principalExchange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("principalExchange")
		public Cashflows.CashflowsBuilder setPrincipalExchange(List<? extends PrincipalExchange> principalExchanges) {
			if (principalExchanges == null)  {
				this.principalExchange = new ArrayList<>();
			}
			else {
				this.principalExchange = principalExchanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Cashflows.CashflowsBuilder addPaymentCalculationPeriod(PaymentCalculationPeriod paymentCalculationPeriod) {
			if (paymentCalculationPeriod!=null) this.paymentCalculationPeriod.add(paymentCalculationPeriod.toBuilder());
			return this;
		}
		
		@Override
		public Cashflows.CashflowsBuilder addPaymentCalculationPeriod(PaymentCalculationPeriod paymentCalculationPeriod, int _idx) {
			getIndex(this.paymentCalculationPeriod, _idx, () -> paymentCalculationPeriod.toBuilder());
			return this;
		}
		@Override 
		public Cashflows.CashflowsBuilder addPaymentCalculationPeriod(List<? extends PaymentCalculationPeriod> paymentCalculationPeriods) {
			if (paymentCalculationPeriods != null) {
				for (PaymentCalculationPeriod toAdd : paymentCalculationPeriods) {
					this.paymentCalculationPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("paymentCalculationPeriod")
		public Cashflows.CashflowsBuilder setPaymentCalculationPeriod(List<? extends PaymentCalculationPeriod> paymentCalculationPeriods) {
			if (paymentCalculationPeriods == null)  {
				this.paymentCalculationPeriod = new ArrayList<>();
			}
			else {
				this.paymentCalculationPeriod = paymentCalculationPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Cashflows build() {
			return new Cashflows.CashflowsImpl(this);
		}
		
		@Override
		public Cashflows.CashflowsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cashflows.CashflowsBuilder prune() {
			principalExchange = principalExchange.stream().filter(b->b!=null).<PrincipalExchange.PrincipalExchangeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			paymentCalculationPeriod = paymentCalculationPeriod.stream().filter(b->b!=null).<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashflowsMatchParameters()!=null) return true;
			if (getPrincipalExchange()!=null && getPrincipalExchange().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPaymentCalculationPeriod()!=null && getPaymentCalculationPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Cashflows.CashflowsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Cashflows.CashflowsBuilder o = (Cashflows.CashflowsBuilder) other;
			
			merger.mergeRosetta(getPrincipalExchange(), o.getPrincipalExchange(), this::getOrCreatePrincipalExchange);
			merger.mergeRosetta(getPaymentCalculationPeriod(), o.getPaymentCalculationPeriod(), this::getOrCreatePaymentCalculationPeriod);
			
			merger.mergeBasic(getCashflowsMatchParameters(), o.getCashflowsMatchParameters(), this::setCashflowsMatchParameters);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Cashflows _that = getType().cast(o);
		
			if (!Objects.equals(cashflowsMatchParameters, _that.getCashflowsMatchParameters())) return false;
			if (!ListEquals.listEquals(principalExchange, _that.getPrincipalExchange())) return false;
			if (!ListEquals.listEquals(paymentCalculationPeriod, _that.getPaymentCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashflowsMatchParameters != null ? cashflowsMatchParameters.hashCode() : 0);
			_result = 31 * _result + (principalExchange != null ? principalExchange.hashCode() : 0);
			_result = 31 * _result + (paymentCalculationPeriod != null ? paymentCalculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowsBuilder {" +
				"cashflowsMatchParameters=" + this.cashflowsMatchParameters + ", " +
				"principalExchange=" + this.principalExchange + ", " +
				"paymentCalculationPeriod=" + this.paymentCalculationPeriod +
			'}';
		}
	}
}
