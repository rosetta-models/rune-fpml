package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CalculationPeriodAmount;
import fpml.confirmation.CalculationPeriodDates;
import fpml.confirmation.Cashflows;
import fpml.confirmation.Formula;
import fpml.confirmation.InterestRateStream;
import fpml.confirmation.InterestRateStream.InterestRateStreamBuilder;
import fpml.confirmation.InterestRateStream.InterestRateStreamBuilderImpl;
import fpml.confirmation.InterestRateStream.InterestRateStreamImpl;
import fpml.confirmation.Leg;
import fpml.confirmation.Leg.LegBuilder;
import fpml.confirmation.Leg.LegBuilderImpl;
import fpml.confirmation.Leg.LegImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentDates;
import fpml.confirmation.PrincipalExchanges;
import fpml.confirmation.ResetDates;
import fpml.confirmation.SettlementProvision;
import fpml.confirmation.StubCalculationPeriodAmount;
import fpml.confirmation.meta.InterestRateStreamMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the components specifiying an interest rate stream, including both a parametric and cashflow representation for the stream of payments.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="InterestRateStream", builder=InterestRateStream.InterestRateStreamBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface InterestRateStream extends Leg {

	InterestRateStreamMeta metaData = new InterestRateStreamMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * The calculation periods dates schedule.
	 */
	CalculationPeriodDates getCalculationPeriodDates();
	/**
	 * The payment dates schedule.
	 */
	PaymentDates getPaymentDates();
	/**
	 * The reset dates schedule. The reset dates schedule only applies for a floating rate stream.
	 */
	ResetDates getResetDates();
	/**
	 * The calculation period amount parameters.
	 */
	CalculationPeriodAmount getCalculationPeriodAmount();
	/**
	 * The stub calculation period amount parameters. This element must only be included if there is an initial or final stub calculation period. Even then, it must only be included if either the stub references a different floating rate tenor to the regular calculation periods, or if the stub is calculated as a linear interpolation of two different floating rate tenors, or if a specific stub rate or stub amount has been negotiated.
	 */
	StubCalculationPeriodAmount getStubCalculationPeriodAmount();
	/**
	 * The true/false flags indicating whether initial, intermediate or final exchanges of principal should occur.
	 */
	PrincipalExchanges getPrincipalExchanges();
	/**
	 * The cashflows representation of the swap stream.
	 */
	Cashflows getCashflows();
	/**
	 * A provision that allows the specification of settlement terms, occuring when the settlement currency is different to the notional currency of the trade.
	 */
	SettlementProvision getSettlementProvision();
	/**
	 * An interest rate derivative formula.
	 */
	Formula getFormula();

	/*********************** Build Methods  ***********************/
	InterestRateStream build();
	
	InterestRateStream.InterestRateStreamBuilder toBuilder();
	
	static InterestRateStream.InterestRateStreamBuilder builder() {
		return new InterestRateStream.InterestRateStreamBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestRateStream> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestRateStream> getType() {
		return InterestRateStream.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.class, getCalculationPeriodDates());
		processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("resetDates"), processor, ResetDates.class, getResetDates());
		processRosetta(path.newSubPath("calculationPeriodAmount"), processor, CalculationPeriodAmount.class, getCalculationPeriodAmount());
		processRosetta(path.newSubPath("stubCalculationPeriodAmount"), processor, StubCalculationPeriodAmount.class, getStubCalculationPeriodAmount());
		processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.class, getPrincipalExchanges());
		processRosetta(path.newSubPath("cashflows"), processor, Cashflows.class, getCashflows());
		processRosetta(path.newSubPath("settlementProvision"), processor, SettlementProvision.class, getSettlementProvision());
		processRosetta(path.newSubPath("formula"), processor, Formula.class, getFormula());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestRateStreamBuilder extends InterestRateStream, Leg.LegBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates();
		CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates();
		PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates();
		PaymentDates.PaymentDatesBuilder getPaymentDates();
		ResetDates.ResetDatesBuilder getOrCreateResetDates();
		ResetDates.ResetDatesBuilder getResetDates();
		CalculationPeriodAmount.CalculationPeriodAmountBuilder getOrCreateCalculationPeriodAmount();
		CalculationPeriodAmount.CalculationPeriodAmountBuilder getCalculationPeriodAmount();
		StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder getOrCreateStubCalculationPeriodAmount();
		StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder getStubCalculationPeriodAmount();
		PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges();
		PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges();
		Cashflows.CashflowsBuilder getOrCreateCashflows();
		Cashflows.CashflowsBuilder getCashflows();
		SettlementProvision.SettlementProvisionBuilder getOrCreateSettlementProvision();
		SettlementProvision.SettlementProvisionBuilder getSettlementProvision();
		Formula.FormulaBuilder getOrCreateFormula();
		Formula.FormulaBuilder getFormula();
		InterestRateStream.InterestRateStreamBuilder setId(String id);
		InterestRateStream.InterestRateStreamBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		InterestRateStream.InterestRateStreamBuilder setCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates);
		InterestRateStream.InterestRateStreamBuilder setPaymentDates(PaymentDates paymentDates);
		InterestRateStream.InterestRateStreamBuilder setResetDates(ResetDates resetDates);
		InterestRateStream.InterestRateStreamBuilder setCalculationPeriodAmount(CalculationPeriodAmount calculationPeriodAmount);
		InterestRateStream.InterestRateStreamBuilder setStubCalculationPeriodAmount(StubCalculationPeriodAmount stubCalculationPeriodAmount);
		InterestRateStream.InterestRateStreamBuilder setPrincipalExchanges(PrincipalExchanges principalExchanges);
		InterestRateStream.InterestRateStreamBuilder setCashflows(Cashflows cashflows);
		InterestRateStream.InterestRateStreamBuilder setSettlementProvision(SettlementProvision settlementProvision);
		InterestRateStream.InterestRateStreamBuilder setFormula(Formula formula);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("calculationPeriodDates"), processor, CalculationPeriodDates.CalculationPeriodDatesBuilder.class, getCalculationPeriodDates());
			processRosetta(path.newSubPath("paymentDates"), processor, PaymentDates.PaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("resetDates"), processor, ResetDates.ResetDatesBuilder.class, getResetDates());
			processRosetta(path.newSubPath("calculationPeriodAmount"), processor, CalculationPeriodAmount.CalculationPeriodAmountBuilder.class, getCalculationPeriodAmount());
			processRosetta(path.newSubPath("stubCalculationPeriodAmount"), processor, StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder.class, getStubCalculationPeriodAmount());
			processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.PrincipalExchangesBuilder.class, getPrincipalExchanges());
			processRosetta(path.newSubPath("cashflows"), processor, Cashflows.CashflowsBuilder.class, getCashflows());
			processRosetta(path.newSubPath("settlementProvision"), processor, SettlementProvision.SettlementProvisionBuilder.class, getSettlementProvision());
			processRosetta(path.newSubPath("formula"), processor, Formula.FormulaBuilder.class, getFormula());
		}
		

		InterestRateStream.InterestRateStreamBuilder prune();
	}

	/*********************** Immutable Implementation of InterestRateStream  ***********************/
	class InterestRateStreamImpl extends Leg.LegImpl implements InterestRateStream {
		private final PayerReceiverModel payerReceiverModel;
		private final CalculationPeriodDates calculationPeriodDates;
		private final PaymentDates paymentDates;
		private final ResetDates resetDates;
		private final CalculationPeriodAmount calculationPeriodAmount;
		private final StubCalculationPeriodAmount stubCalculationPeriodAmount;
		private final PrincipalExchanges principalExchanges;
		private final Cashflows cashflows;
		private final SettlementProvision settlementProvision;
		private final Formula formula;
		
		protected InterestRateStreamImpl(InterestRateStream.InterestRateStreamBuilder builder) {
			super(builder);
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.calculationPeriodDates = ofNullable(builder.getCalculationPeriodDates()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.resetDates = ofNullable(builder.getResetDates()).map(f->f.build()).orElse(null);
			this.calculationPeriodAmount = ofNullable(builder.getCalculationPeriodAmount()).map(f->f.build()).orElse(null);
			this.stubCalculationPeriodAmount = ofNullable(builder.getStubCalculationPeriodAmount()).map(f->f.build()).orElse(null);
			this.principalExchanges = ofNullable(builder.getPrincipalExchanges()).map(f->f.build()).orElse(null);
			this.cashflows = ofNullable(builder.getCashflows()).map(f->f.build()).orElse(null);
			this.settlementProvision = ofNullable(builder.getSettlementProvision()).map(f->f.build()).orElse(null);
			this.formula = ofNullable(builder.getFormula()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		public CalculationPeriodDates getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		public PaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("resetDates")
		public ResetDates getResetDates() {
			return resetDates;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodAmount")
		public CalculationPeriodAmount getCalculationPeriodAmount() {
			return calculationPeriodAmount;
		}
		
		@Override
		@RosettaAttribute("stubCalculationPeriodAmount")
		public StubCalculationPeriodAmount getStubCalculationPeriodAmount() {
			return stubCalculationPeriodAmount;
		}
		
		@Override
		@RosettaAttribute("principalExchanges")
		public PrincipalExchanges getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		@RosettaAttribute("cashflows")
		public Cashflows getCashflows() {
			return cashflows;
		}
		
		@Override
		@RosettaAttribute("settlementProvision")
		public SettlementProvision getSettlementProvision() {
			return settlementProvision;
		}
		
		@Override
		@RosettaAttribute("formula")
		public Formula getFormula() {
			return formula;
		}
		
		@Override
		public InterestRateStream build() {
			return this;
		}
		
		@Override
		public InterestRateStream.InterestRateStreamBuilder toBuilder() {
			InterestRateStream.InterestRateStreamBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestRateStream.InterestRateStreamBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getCalculationPeriodDates()).ifPresent(builder::setCalculationPeriodDates);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getResetDates()).ifPresent(builder::setResetDates);
			ofNullable(getCalculationPeriodAmount()).ifPresent(builder::setCalculationPeriodAmount);
			ofNullable(getStubCalculationPeriodAmount()).ifPresent(builder::setStubCalculationPeriodAmount);
			ofNullable(getPrincipalExchanges()).ifPresent(builder::setPrincipalExchanges);
			ofNullable(getCashflows()).ifPresent(builder::setCashflows);
			ofNullable(getSettlementProvision()).ifPresent(builder::setSettlementProvision);
			ofNullable(getFormula()).ifPresent(builder::setFormula);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRateStream _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(resetDates, _that.getResetDates())) return false;
			if (!Objects.equals(calculationPeriodAmount, _that.getCalculationPeriodAmount())) return false;
			if (!Objects.equals(stubCalculationPeriodAmount, _that.getStubCalculationPeriodAmount())) return false;
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!Objects.equals(cashflows, _that.getCashflows())) return false;
			if (!Objects.equals(settlementProvision, _that.getSettlementProvision())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (resetDates != null ? resetDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodAmount != null ? calculationPeriodAmount.hashCode() : 0);
			_result = 31 * _result + (stubCalculationPeriodAmount != null ? stubCalculationPeriodAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (cashflows != null ? cashflows.hashCode() : 0);
			_result = 31 * _result + (settlementProvision != null ? settlementProvision.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateStream {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"resetDates=" + this.resetDates + ", " +
				"calculationPeriodAmount=" + this.calculationPeriodAmount + ", " +
				"stubCalculationPeriodAmount=" + this.stubCalculationPeriodAmount + ", " +
				"principalExchanges=" + this.principalExchanges + ", " +
				"cashflows=" + this.cashflows + ", " +
				"settlementProvision=" + this.settlementProvision + ", " +
				"formula=" + this.formula +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestRateStream  ***********************/
	class InterestRateStreamBuilderImpl extends Leg.LegBuilderImpl  implements InterestRateStream.InterestRateStreamBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates;
		protected PaymentDates.PaymentDatesBuilder paymentDates;
		protected ResetDates.ResetDatesBuilder resetDates;
		protected CalculationPeriodAmount.CalculationPeriodAmountBuilder calculationPeriodAmount;
		protected StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder stubCalculationPeriodAmount;
		protected PrincipalExchanges.PrincipalExchangesBuilder principalExchanges;
		protected Cashflows.CashflowsBuilder cashflows;
		protected SettlementProvision.SettlementProvisionBuilder settlementProvision;
		protected Formula.FormulaBuilder formula;
	
		public InterestRateStreamBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDates")
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getCalculationPeriodDates() {
			return calculationPeriodDates;
		}
		
		@Override
		public CalculationPeriodDates.CalculationPeriodDatesBuilder getOrCreateCalculationPeriodDates() {
			CalculationPeriodDates.CalculationPeriodDatesBuilder result;
			if (calculationPeriodDates!=null) {
				result = calculationPeriodDates;
			}
			else {
				result = calculationPeriodDates = CalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		public PaymentDates.PaymentDatesBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public PaymentDates.PaymentDatesBuilder getOrCreatePaymentDates() {
			PaymentDates.PaymentDatesBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = PaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetDates")
		public ResetDates.ResetDatesBuilder getResetDates() {
			return resetDates;
		}
		
		@Override
		public ResetDates.ResetDatesBuilder getOrCreateResetDates() {
			ResetDates.ResetDatesBuilder result;
			if (resetDates!=null) {
				result = resetDates;
			}
			else {
				result = resetDates = ResetDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodAmount")
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder getCalculationPeriodAmount() {
			return calculationPeriodAmount;
		}
		
		@Override
		public CalculationPeriodAmount.CalculationPeriodAmountBuilder getOrCreateCalculationPeriodAmount() {
			CalculationPeriodAmount.CalculationPeriodAmountBuilder result;
			if (calculationPeriodAmount!=null) {
				result = calculationPeriodAmount;
			}
			else {
				result = calculationPeriodAmount = CalculationPeriodAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("stubCalculationPeriodAmount")
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder getStubCalculationPeriodAmount() {
			return stubCalculationPeriodAmount;
		}
		
		@Override
		public StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder getOrCreateStubCalculationPeriodAmount() {
			StubCalculationPeriodAmount.StubCalculationPeriodAmountBuilder result;
			if (stubCalculationPeriodAmount!=null) {
				result = stubCalculationPeriodAmount;
			}
			else {
				result = stubCalculationPeriodAmount = StubCalculationPeriodAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalExchanges")
		public PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges() {
			PrincipalExchanges.PrincipalExchangesBuilder result;
			if (principalExchanges!=null) {
				result = principalExchanges;
			}
			else {
				result = principalExchanges = PrincipalExchanges.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashflows")
		public Cashflows.CashflowsBuilder getCashflows() {
			return cashflows;
		}
		
		@Override
		public Cashflows.CashflowsBuilder getOrCreateCashflows() {
			Cashflows.CashflowsBuilder result;
			if (cashflows!=null) {
				result = cashflows;
			}
			else {
				result = cashflows = Cashflows.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementProvision")
		public SettlementProvision.SettlementProvisionBuilder getSettlementProvision() {
			return settlementProvision;
		}
		
		@Override
		public SettlementProvision.SettlementProvisionBuilder getOrCreateSettlementProvision() {
			SettlementProvision.SettlementProvisionBuilder result;
			if (settlementProvision!=null) {
				result = settlementProvision;
			}
			else {
				result = settlementProvision = SettlementProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("formula")
		public Formula.FormulaBuilder getFormula() {
			return formula;
		}
		
		@Override
		public Formula.FormulaBuilder getOrCreateFormula() {
			Formula.FormulaBuilder result;
			if (formula!=null) {
				result = formula;
			}
			else {
				result = formula = Formula.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public InterestRateStream.InterestRateStreamBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public InterestRateStream.InterestRateStreamBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodDates")
		public InterestRateStream.InterestRateStreamBuilder setCalculationPeriodDates(CalculationPeriodDates calculationPeriodDates) {
			this.calculationPeriodDates = calculationPeriodDates==null?null:calculationPeriodDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDates")
		public InterestRateStream.InterestRateStreamBuilder setPaymentDates(PaymentDates paymentDates) {
			this.paymentDates = paymentDates==null?null:paymentDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("resetDates")
		public InterestRateStream.InterestRateStreamBuilder setResetDates(ResetDates resetDates) {
			this.resetDates = resetDates==null?null:resetDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodAmount")
		public InterestRateStream.InterestRateStreamBuilder setCalculationPeriodAmount(CalculationPeriodAmount calculationPeriodAmount) {
			this.calculationPeriodAmount = calculationPeriodAmount==null?null:calculationPeriodAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("stubCalculationPeriodAmount")
		public InterestRateStream.InterestRateStreamBuilder setStubCalculationPeriodAmount(StubCalculationPeriodAmount stubCalculationPeriodAmount) {
			this.stubCalculationPeriodAmount = stubCalculationPeriodAmount==null?null:stubCalculationPeriodAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("principalExchanges")
		public InterestRateStream.InterestRateStreamBuilder setPrincipalExchanges(PrincipalExchanges principalExchanges) {
			this.principalExchanges = principalExchanges==null?null:principalExchanges.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashflows")
		public InterestRateStream.InterestRateStreamBuilder setCashflows(Cashflows cashflows) {
			this.cashflows = cashflows==null?null:cashflows.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementProvision")
		public InterestRateStream.InterestRateStreamBuilder setSettlementProvision(SettlementProvision settlementProvision) {
			this.settlementProvision = settlementProvision==null?null:settlementProvision.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("formula")
		public InterestRateStream.InterestRateStreamBuilder setFormula(Formula formula) {
			this.formula = formula==null?null:formula.toBuilder();
			return this;
		}
		
		@Override
		public InterestRateStream build() {
			return new InterestRateStream.InterestRateStreamImpl(this);
		}
		
		@Override
		public InterestRateStream.InterestRateStreamBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateStream.InterestRateStreamBuilder prune() {
			super.prune();
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (calculationPeriodDates!=null && !calculationPeriodDates.prune().hasData()) calculationPeriodDates = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (resetDates!=null && !resetDates.prune().hasData()) resetDates = null;
			if (calculationPeriodAmount!=null && !calculationPeriodAmount.prune().hasData()) calculationPeriodAmount = null;
			if (stubCalculationPeriodAmount!=null && !stubCalculationPeriodAmount.prune().hasData()) stubCalculationPeriodAmount = null;
			if (principalExchanges!=null && !principalExchanges.prune().hasData()) principalExchanges = null;
			if (cashflows!=null && !cashflows.prune().hasData()) cashflows = null;
			if (settlementProvision!=null && !settlementProvision.prune().hasData()) settlementProvision = null;
			if (formula!=null && !formula.prune().hasData()) formula = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getCalculationPeriodDates()!=null && getCalculationPeriodDates().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getResetDates()!=null && getResetDates().hasData()) return true;
			if (getCalculationPeriodAmount()!=null && getCalculationPeriodAmount().hasData()) return true;
			if (getStubCalculationPeriodAmount()!=null && getStubCalculationPeriodAmount().hasData()) return true;
			if (getPrincipalExchanges()!=null && getPrincipalExchanges().hasData()) return true;
			if (getCashflows()!=null && getCashflows().hasData()) return true;
			if (getSettlementProvision()!=null && getSettlementProvision().hasData()) return true;
			if (getFormula()!=null && getFormula().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestRateStream.InterestRateStreamBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestRateStream.InterestRateStreamBuilder o = (InterestRateStream.InterestRateStreamBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getCalculationPeriodDates(), o.getCalculationPeriodDates(), this::setCalculationPeriodDates);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getResetDates(), o.getResetDates(), this::setResetDates);
			merger.mergeRosetta(getCalculationPeriodAmount(), o.getCalculationPeriodAmount(), this::setCalculationPeriodAmount);
			merger.mergeRosetta(getStubCalculationPeriodAmount(), o.getStubCalculationPeriodAmount(), this::setStubCalculationPeriodAmount);
			merger.mergeRosetta(getPrincipalExchanges(), o.getPrincipalExchanges(), this::setPrincipalExchanges);
			merger.mergeRosetta(getCashflows(), o.getCashflows(), this::setCashflows);
			merger.mergeRosetta(getSettlementProvision(), o.getSettlementProvision(), this::setSettlementProvision);
			merger.mergeRosetta(getFormula(), o.getFormula(), this::setFormula);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestRateStream _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(calculationPeriodDates, _that.getCalculationPeriodDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(resetDates, _that.getResetDates())) return false;
			if (!Objects.equals(calculationPeriodAmount, _that.getCalculationPeriodAmount())) return false;
			if (!Objects.equals(stubCalculationPeriodAmount, _that.getStubCalculationPeriodAmount())) return false;
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!Objects.equals(cashflows, _that.getCashflows())) return false;
			if (!Objects.equals(settlementProvision, _that.getSettlementProvision())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodDates != null ? calculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (resetDates != null ? resetDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodAmount != null ? calculationPeriodAmount.hashCode() : 0);
			_result = 31 * _result + (stubCalculationPeriodAmount != null ? stubCalculationPeriodAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (cashflows != null ? cashflows.hashCode() : 0);
			_result = 31 * _result + (settlementProvision != null ? settlementProvision.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestRateStreamBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"calculationPeriodDates=" + this.calculationPeriodDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"resetDates=" + this.resetDates + ", " +
				"calculationPeriodAmount=" + this.calculationPeriodAmount + ", " +
				"stubCalculationPeriodAmount=" + this.stubCalculationPeriodAmount + ", " +
				"principalExchanges=" + this.principalExchanges + ", " +
				"cashflows=" + this.cashflows + ", " +
				"settlementProvision=" + this.settlementProvision + ", " +
				"formula=" + this.formula +
			'}' + " " + super.toString();
		}
	}
}
